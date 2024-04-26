package Client.view;

import Entity.Message;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LPanel extends JPanel {
    private JLabel userNameLabel;
    private JList<Message> leftPanelList;
    private JTextArea textChatBox;
    private JButton btnlogIn;
    private JButton btnRegUser;
    private JButton btnLogOut;
    private JButton btnSend;
    private JButton btnExit;


    private int width;
    private int height;

    private MainFrame mainFrame;


    public LPanel(int width, int height, MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.setLayout(null);
        this.width = width;
        this.height = height;
        this.setSize(width, height);
        setLocation(0, 0);
        setUp();

        leftPanelList = new JList<Message>();
        leftPanelList.setLocation(0, 23);
        leftPanelList.setSize(width, height - 100);
        this.add(leftPanelList);

        textChatBox = new JTextArea();
        textChatBox.setLineWrap(true);
        textChatBox.setWrapStyleWord(true);
        textChatBox.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textChatBox);
        scrollPane.setBounds(0, 0, width, height - 100);
        this.add(scrollPane);

        userNameLabel = new JLabel();
        userNameLabel.setFont(new Font("Serif", Font.BOLD, 14));
        userNameLabel.setSize(width, 20);
        userNameLabel.setLocation(0, 15);
        this.add(userNameLabel);
    }

    private void setUp() {

        btnlogIn = new JButton("Log In");
        btnlogIn.setEnabled(true);
        btnlogIn.setSize(width / 5, 30);
        btnlogIn.setLocation(0, height - 75);
        btnlogIn.addActionListener(l -> mainFrame.buttonPressed(ButtonType.Log_In));
        this.add(btnlogIn);

        btnRegUser = new JButton("Register user");
        btnRegUser.setEnabled(true);
        btnRegUser.setSize(width / 5, 30);
        btnRegUser.setLocation((width / 5), height - 75);
        btnRegUser.addActionListener(e -> {
            //RegisterUserFrame registerUserFrame = new RegisterUserFrame();
            btnRegUser.addActionListener(l -> mainFrame.buttonPressed(ButtonType.Register_new_user));
        });
        this.add(btnRegUser);

        btnSend = new JButton("Send Message");
        btnSend.setEnabled(true);
        btnSend.setSize(width / 5, 30);
        btnSend.setLocation((width / 5) * 2, height - 75);
        btnSend.addActionListener(l -> mainFrame.buttonPressed(ButtonType.send));
        this.add(btnSend);

        btnLogOut = new JButton("Log Out");
        btnLogOut.setEnabled(true);
        btnLogOut.setSize(width / 5, 30);
        btnLogOut.addActionListener(l -> mainFrame.buttonPressed(ButtonType.Log_Out));
        btnLogOut.setLocation((width / 5) * 3, height - 75);
        this.add(btnLogOut);

    }

    protected JList<Message> getLeftPanelList() {
        return leftPanelList;
    }

    protected JButton getBtnSend() {
        return btnSend;
    }


    protected JButton getBtnLogOut() {
        return btnLogOut;
    }


    protected JButton getBtnlogIn() {
        return btnlogIn;
    }


    protected JButton getBtnRegUser() {
        return btnRegUser;

    }


    public void populateList(ArrayList<Message> messages) {
        DefaultListModel<Message> listModel = new DefaultListModel<>();
        for (Message message : messages) {
            if(message.getSender() != null){

            }
            listModel.addElement(message);
        }
        leftPanelList.setModel(listModel);
    }

    protected JTextArea getTextChatBox() {
        return textChatBox;
    }

}
