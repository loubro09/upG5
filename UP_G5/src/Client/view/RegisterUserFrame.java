package Client.view;

import Client.ClientViewController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class RegisterUserFrame extends JFrame implements ActionListener {

    private JPanel mainPanel;
    private JTextArea enterUserName;
    private JButton enterPhoto;
    private File file;
    private JLabel picture;
    private ClientViewController controller;


    public RegisterUserFrame(ClientViewController controller) {
        this.controller = controller;
        setTitle("Register New User");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        setupPanel();
        pack();
        setMinimumSize(new Dimension(400,500));
        setVisible(true);

    }


    public void setupPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel lblUserName = new JLabel("Enter username: ");
        lblUserName.setAlignmentX(Component.LEFT_ALIGNMENT);
        mainPanel.add(lblUserName);

        enterUserName = new JTextArea();
        enterUserName.setAlignmentX(Component.LEFT_ALIGNMENT);
        mainPanel.add(enterUserName);

        enterPhoto = new JButton("Choose Photo");
        enterPhoto.setAlignmentX(Component.LEFT_ALIGNMENT);
        enterPhoto.addActionListener(this);
        mainPanel.add(enterPhoto);

        picture = new JLabel();
        picture.setAlignmentX(Component.LEFT_ALIGNMENT);
        mainPanel.add(picture);



        JButton registerbtn= new JButton("Register");
        registerbtn.setAlignmentX(Component.LEFT_ALIGNMENT);
        registerbtn.addActionListener(this);
        mainPanel.add(registerbtn);
        getContentPane().add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enterPhoto) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                file = fileChooser.getSelectedFile();
                picture.setText(file.getAbsolutePath());
                Image img = null;
                try {
                    img = ImageIO.read(file);
                    Image scaledImg = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH); // Adjust size if needed
                    picture.setIcon(new ImageIcon(scaledImg));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }else if(e.getActionCommand().equals("Register")){
            controller.getLc().addUser(enterUserName.getText(), enterPhoto.getIcon());
            dispose();
        }
    }

}
