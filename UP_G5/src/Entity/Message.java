package Entity;

import javax.swing.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

<<<<<<< HEAD
public class Message {
=======
public class Message implements Serializable {
    private MessageType messageType;
>>>>>>> 7950a75b52e9dabd9588f823db9d5328fbec831a
    private String text;
    private Icon ImageIcon;
    private User sender;
    private List<User> receivers;
    private LocalDateTime timeDelivered;
    private LocalDateTime timeReceived;

    public Message(String text, User sender, List<User> receivers, LocalDateTime timeDelivered, LocalDateTime timeReceived) {
        this.text = text;
        this.sender = sender;
        this.receivers = receivers;
        this.timeDelivered = timeDelivered;
        this.timeReceived = timeReceived;
    }

    public String getText(){
        return text;
    }
    public Icon getImageIcon(){
        return ImageIcon;
    }
    public User getSender(){
        return sender;
    }
    public List<User> getReceivers(){
        return receivers;
    }
    public Date getTimeReceived(){
        return timeReceived;
    }
    public void setTimeReceived(Date timeReceived) {
        this.timeReceived = timeReceived;
    }
    public Date getTimeDelivered(){
        return timeDelivered;
    }
}
