package Server;

import Entity.Buffer;
import Entity.Message;
import Entity.User;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;

public class UserController implements PropertyChangeListener {
    private ServerNetworkBoundary serverNetworkBoundary;
    private Buffer<Message> loginBuffer = new Buffer<>();
    private Buffer<Message> registerUserBuffer = new Buffer<>();



    public UserController(ServerNetworkBoundary serverNetworkBoundary){
        this.serverNetworkBoundary = serverNetworkBoundary;
        serverNetworkBoundary.addPropertyChangeListener(this);
    }
    public Buffer<Message> getLoginBuffer() {
        return loginBuffer;
    }

    public boolean checkMessage(Message msg) {
        User sender = msg.getSender();

        return false;
    }

    public void addClient() {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("login".equals(evt.getPropertyName())){
            loginBuffer.put((Message) evt.getNewValue());
        }
        else if("register".equals(evt.getPropertyName())) {
            registerUserBuffer.put((Message) evt.getNewValue());
        }
        else if("sendClient".equals(evt.getPropertyName())) {
            ServerNetworkBoundary.ClientHandler client = (ServerNetworkBoundary.ClientHandler) evt.getNewValue();
        }
    }
}
