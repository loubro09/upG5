package Entity;

import javax.swing.*;
import java.util.*;
public class User {

    private String userName;
    private Icon userPicture;
    private List<User> contactList;

    public User(String userName, Icon userPicture) {
        this.userName = userName;
        this.userPicture = userPicture;
    }

    public String getUserName() {
        return userName;
    }

    public List<User> getContactList() {
        return contactList;
    }

    public Icon getImageIcon(){
        return userPicture;
    }

    public void setContactList(List<User> contactList) {
        this.contactList = contactList;
    }
    public int hashCode () {
        return 1;
    }
}