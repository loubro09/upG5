package Server;

import Client.ClientNetworkBoundary;
import Entity.Message;
import Entity.User;

import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;


public class ServerNetworkBoundary {


    private ServerSocket serverSocket;

    private PropertyChangeSupport propertyChangeSupport;
    private ArrayList<ClientHandler> connectedClients = new ArrayList<>();
    private Message message;
    private ClientNetworkBoundary clientNetworkBoundary;
    private HashMap<User, ClientHandler> clients = new HashMap<>();

    public void put(User user, ClientHandler clientHandler){
        clients.put(user, clientHandler);
    }

   

    public ServerNetworkBoundary(int port) {
        try {
            this.serverSocket=new ServerSocket(port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ClientHandler clientHandler = new ClientHandler();
        Thread thread = new Thread(clientHandler);
        thread.start();

    }

    private class Connection extends Thread{


        @Override
        public void run() {
            Socket socket = null;
            try{
            while(true) {
                try {
                    socket= serverSocket.accept();

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class ClientHandler extends Thread{
        private ObjectOutputStream oos;
        private ObjectInputStream ois;
        private Socket socket;

        public ClientHandler() {
            try {
                oos = new ObjectOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            start();
        }

        @Override
        public void run() {

        }
    }


}
