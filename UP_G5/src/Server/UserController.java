package Server;

import Entity.Buffer;
import Entity.Message;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class UserController implements PropertyChangeListener {
    private ServerNetworkBoundary serverNetworkBoundary;
    private Buffer<Message> loginBuffer = new Buffer<>();


    public UserController(ServerNetworkBoundary serverNetworkBoundary){
        this.serverNetworkBoundary = serverNetworkBoundary;
        serverNetworkBoundary.addPropertyChangeListener(this);
    }
    public Buffer<Message> getLoginBuffer() {
        return loginBuffer;
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("login".equals(evt.getPropertyName())){
            loginBuffer.put((Message) evt.getNewValue());
        }

    }
}
