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
        private JButton login;
        private JTextField enterUserName;
        private JButton enterPhoto;
        private File file;
        private JLabel picture;



        public LogInFrame() {
            setTitle("Log in");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLocationRelativeTo(null);
            setResizable(true);
            setupPanel();
            pack();
            setMinimumSize(new Dimension(300,300));
            //mainPanel = new JPanel(new GridLayout(3, 1));
            //setSize(600, 400);
            setVisible(true);
        }

        public void setupPanel() {
            mainPanel = new JPanel();
            mainPanel.setLayout(new BorderLayout());
            JPanel inputPanel2 = new JPanel();
            inputPanel2.setLayout(new BoxLayout(inputPanel2, BoxLayout.Y_AXIS));



            JLabel lblUserName = new JLabel("Enter username: ");
            inputPanel2.add(lblUserName);


            enterUserName = new JTextField();
            enterUserName.setVisible(true);
            enterUserName.setAlignmentX(Component.LEFT_ALIGNMENT);
            enterUserName.setPreferredSize(new Dimension(100,25));
            inputPanel2.add(enterUserName);
            mainPanel.add(inputPanel2, BorderLayout.NORTH);
            //add(enterUserName);

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
            enterPhoto = new JButton("Choose Photo");
            enterPhoto.setAlignmentX(Component.LEFT_ALIGNMENT);
            enterPhoto.addActionListener(this);
            buttonPanel.add(enterPhoto);



            picture = new JLabel();
            picture.setAlignmentX(Component.LEFT_ALIGNMENT);
            buttonPanel.add(picture);



            JButton login= new JButton("Log in");
            login.setAlignmentX(Component.LEFT_ALIGNMENT);
            login.addActionListener(this);
            buttonPanel.add(login);

            mainPanel.add(buttonPanel, BorderLayout.CENTER);
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
            }else if(e.getActionCommand().equals("Log in")){
                dispose();
            }
    }
}
