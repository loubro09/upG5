package Client.view;

import javax.swing.*;

public class RPanel extends JPanel {
    private MainFrame mainFrame;
    private JList<Object> rightPanelList;

    private JButton btnFriends;
    private JButton btnAllUsers;
    private JButton btnSelectContact;

    private JButton btnViewSelectedOrder;
    private JLabel lblTitle;
    private JLabel lblCost;
    private int width;
    private int height;

    public RPanel(int width, int height, MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.setLayout(null);
        this.width = width;
        this.height = height;
        this.setSize(width, height);
        setLocation(width, 0);
        setUp();
    }

    private void setUp() {
        lblTitle = new JLabel("USER LIST");
        lblTitle.setLocation(2, 0);
        lblTitle.setSize((width / 2)-100, 20);
        this.add(lblTitle);


        rightPanelList = new JList<>();
        rightPanelList.setLocation(0, 23);
        rightPanelList.setSize(width, height - 100);
        this.add(rightPanelList);

        btnFriends = new JButton("Friend List");
        btnFriends.setEnabled(true);
        btnFriends.setSize(width / 5, 30);
        btnFriends.setLocation(0, height - 75);
        btnFriends.addActionListener(l -> mainFrame.buttonPressed(ButtonType.friends));
        this.add(btnFriends);

        btnAllUsers = new JButton("All Users");
        btnAllUsers.setEnabled(false);
        btnAllUsers.setSize(width / 5, 30);
        btnAllUsers.setLocation(width / 5, height - 75);
        btnAllUsers.addActionListener(l -> mainFrame.buttonPressed(ButtonType.allUsers));
        this.add(btnAllUsers);

        btnSelectContact = new JButton("Select Contact");
        btnSelectContact.setEnabled(true);
        btnSelectContact.setSize(width / 5, 30);
        btnSelectContact.setLocation((width/5)*4, height - 75);
        btnSelectContact.addActionListener(l -> mainFrame.buttonPressed(ButtonType.Choose_Contact));
        this.add(btnSelectContact);
    }

    /**
     * This method sets the information in the panel's list view.
     *
     * @param informationArray An array of String where each element will be shown
     *                        one line in the panel.
     */
    protected void populateList(String[] informationArray){
        rightPanelList.setListData(informationArray);
    }

    /**
     * This method removes information in the panels list.
     * There are some problems with this in this code and "ghost items" might
     * appear in the list view at the top of the list after use of this method.
     * This might throw selected indexes of synchronization if this is used.
     *
     * This is a "hack" and not a perfect solution - GUIs are annoying to work with!
     *
     * Several solutions have been tested but none worked to satisfaction.
     * Please notify teachers if you might come across a solution that actually works well.
     *
     */
    protected void clearList(){
        String[] defaultString = new String[1];
        defaultString[0] = "Nothing selected";
        populateList(defaultString);
    }

    protected void setTextTitleLabel(String labelText){
        lblTitle.setText(labelText);
    }

    protected void setTextCostLabel(String labelText){
        lblCost.setText(labelText);
    }

    public JButton getBtnAllUsers() {
        return btnAllUsers;
    }

    public JButton getBtnFriends() {
        return btnFriends;
    }

    protected JButton getBtnSelectContact() {
        return btnSelectContact;
    }

    protected JButton getBtnViewSelectedOrder() {return btnViewSelectedOrder;}
}

