package Client;

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
        //Osäker var denna ska vara
        ServerNetworkBoundary serverNetworkBoundary = new ServerNetworkBoundary(socket.getPort());

    }

    synchronized public void sendMessage(){

    }

    synchronized public void receiveMessage(){

    }

    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener){
        propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);
    }


    private class Listener implements Runnable{

        @Override
        public void run() {

        }
    }

}
