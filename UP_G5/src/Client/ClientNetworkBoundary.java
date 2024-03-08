package Client;

import Entity.Message;
import Server.ServerNetworkBoundary;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientNetworkBoundary {
    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private PropertyChangeSupport propertyChangeSupport;

    public ClientNetworkBoundary(String ip, int port){
        this.propertyChangeSupport=new PropertyChangeSupport(this);
        try{
            this.socket=new Socket(ip, port);
            this.ois=new ObjectInputStream(socket.getInputStream());
            this.oos=new ObjectOutputStream(socket.getOutputStream());
            new Thread(new Listener()).start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    synchronized public void sendMessage(Message message){
    try{
        oos.writeObject(message);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    }

    synchronized public void receiveMessage(Message message){

    }

    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener){
        propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);
    }


    private class Listener implements Runnable{

        private String serverAdress;
        private int port;

        @Override
        public void run() {
            try {
                Socket socket = new Socket(serverAdress, port);
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                while (true) {
                    Message message = (Message) ois.readObject();
                    propertyChangeSupport.firePropertyChange("Message received", null, message);
                }
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }

    }


}
