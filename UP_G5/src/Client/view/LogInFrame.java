package Client.view;

import Client.ClientViewController;
import Entity.User;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class LogInFrame  extends JFrame implements ActionListener{
        private JPanel mainPanel;
        private ClientViewController controller;
        private JButton login;
        private JTextField enterUserName;
        private JTextField enterIP;
        private JTextField enterPort;
        private JButton enterPhoto;
        private File file;
        private JLabel picture;
        private User user;


        public LogInFrame(ClientViewController controller) {
            mainPanel = new JPanel(new GridLayout(3, 1));
            setSize(600, 400);
            this.setContentPane(mainPanel);
            setupPanel();
            this.setTitle("Log in");
            this.setVisible(true);
            this.setResizable(false);
            this.controller = controller;
        }

        /**
         * Method that creates all GUI-components of the Custom Pizza Frame.
         * @author Louis Brown
         */
        public void setupPanel() {
            //a label that instructs the user to choose toppings from the dropdown list
            JLabel lblUserName = new JLabel("Enter username: ");
            lblUserName.setVisible(true);
            add(lblUserName);


            enterUserName = new JTextField();
            enterUserName.setVisible(true);
            add(enterUserName);

            enterPhoto = new JButton("Choose Photo");
            enterPhoto.setVisible(true);
            enterPhoto.setEnabled(true);
            enterPhoto.addActionListener(this);
            add(enterPhoto);


            JLabel lblIP = new JLabel("Enter IP address: ");
            lblIP.setVisible(true);
            add(lblIP);

            enterIP = new JTextField();
            enterIP.setVisible(true);
            add(enterIP);


            picture = new JLabel();
            picture.setVisible(true);
            add(picture);

            JLabel lblPort = new JLabel("Enter port: ");
            lblPort.setVisible(true);
            add(lblPort);

            enterPort = new JTextField();
            enterPort.setVisible(true);
            add(enterPort);

            login = new JButton("Log in");
            login.setVisible(true);
            login.setEnabled(true);
            add(login);
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
            }
            else if (e.getSource() == login) {
                controller.getLc().logIn(enterUserName.getText(), enterIP.getText(), enterPort.getText(), picture.getIcon());
            }
    }
}
