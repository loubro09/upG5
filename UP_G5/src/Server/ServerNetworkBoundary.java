package Server;

import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerNetworkBoundary {

    private ServerSocket serverSocket;

    private PropertyChangeSupport propertyChangeSupport;

    public ServerNetworkBoundary(int port) {
        try {
            this.serverSocket=new ServerSocket(port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

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
