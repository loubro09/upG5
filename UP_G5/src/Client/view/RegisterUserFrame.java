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
    private JTextField enterUserName;
    private JButton enterPhoto;
    private File file;
    private JLabel picture;


    public RegisterUserFrame() {

        setTitle("Register New User");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        setupPanel();
        pack();
        setMinimumSize(new Dimension(300,300));
        setVisible(true);

    }


    public void setupPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));

        JLabel lblUserName = new JLabel("Enter username: ");
        inputPanel.add(lblUserName);
        //lblUserName.setAlignmentX(Component.LEFT_ALIGNMENT);
       // mainPanel.add(lblUserName);

        enterUserName = new JTextField();
        enterUserName.setAlignmentX(Component.LEFT_ALIGNMENT);
        enterUserName.setPreferredSize(new Dimension(100,25));
        inputPanel.add(enterUserName);
        mainPanel.add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        enterPhoto = new JButton("Choose Photo");
        enterPhoto.setAlignmentX(Component.LEFT_ALIGNMENT);
        enterPhoto.addActionListener(this);
        buttonPanel.add(enterPhoto);

        picture = new JLabel();
        picture.setAlignmentX(Component.LEFT_ALIGNMENT);
        buttonPanel.add(picture);


        JButton registerbtn= new JButton("Register");
        registerbtn.setAlignmentX(Component.LEFT_ALIGNMENT);
        registerbtn.addActionListener(this);
        buttonPanel.add(registerbtn);

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
                    Image scaledImg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Adjust size if needed
                    picture.setIcon(new ImageIcon(scaledImg));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }else if(e.getActionCommand().equals("Register")){
            dispose();
        }
    }

}
