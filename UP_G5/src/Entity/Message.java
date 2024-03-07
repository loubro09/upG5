package Entity;

import javax.swing.*;
import java.util.Date;
import java.util.List;

public class Message {
    private String text;
    private Icon ImageIcon;
    private User sender;
    private List<User> receivers;
    private Date timeDelivered;
    private Date timeReceived;

    public Message(String text, User sender,List<User> receivers, Date timeDelivered, Date timeReceived) {
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
