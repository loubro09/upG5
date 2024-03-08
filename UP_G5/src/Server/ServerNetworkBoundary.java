package Server;


import Entity.Buffer;
import Entity.Message;
import Entity.MessageType;
import Entity.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ServerNetworkBoundary {


    private ServerSocket serverSocket;
    private PropertyChangeSupport propertyChangeSupport;
    private HashMap<User, ClientHandler> clients = new HashMap<>();
    private Buffer<Message> messageBuffer = new Buffer<>();
    private Buffer<Message> logoutBuffer = new Buffer<>();


    public ServerNetworkBoundary(int port) {
        try {
            this.serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        startListening();

    }



    public void addPropertyChangeListener (PropertyChangeListener pcl) {
        propertyChangeSupport.addPropertyChangeListener(pcl);
    }

    private void startListening() {
        Connection connection = new Connection();
        connection.start();
    }

    private void handleClientConnection(Socket socket) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());


            User user = (User) ois.readObject();


            if (!clients.containsKey(user)) {
                ClientHandler clientHandler = new ClientHandler(socket, ois, oos, user);

                clients.put(user, clientHandler);

                clientHandler.start();
            } else {
                oos.writeObject("User already logged in");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private class Connection extends Thread {

        @Override
        public void run() {
            try {
                while (true) {
                    Socket socket = serverSocket.accept();
                    handleClientConnection(socket);
                }
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }


    public class ClientHandler extends Thread {
        private ObjectOutputStream oos;
        private ObjectInputStream ois;
        private Socket socket;
        private User user;

        public ClientHandler(Socket socket, ObjectInputStream ois, ObjectOutputStream oos, User user) {
            this.socket = socket;
            this.ois = ois;
            this.oos = oos;
            this.user = user;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    Message message = (Message) ois.readObject();
                    MessageType messageType = message.getMessageType();
                    switch (messageType) {
                        case message:
                            messageBuffer.put(message);
                            break;
                        case logIn:
                            propertyChangeSupport.firePropertyChange("login",null,message);
                            break;
                        case logOut:
                            logoutBuffer.put(message);
                            break;
                        case registerUser:
                            propertyChangeSupport.firePropertyChange("sendClient", null, this);
                            propertyChangeSupport.firePropertyChange("register",null,message);
                            break;
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                clients.remove(user);

            } finally {
                try {
                    ois.close();
                    oos.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}