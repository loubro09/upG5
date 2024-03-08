package Client.view;

import javax.swing.*;
import java.awt.*;

public class TextChatBox extends JPanel {
    private JTextArea chatArea;
    private JScrollPane scrollPane;

    public TextChatBox(int width, int height){
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(width,height));

        chatArea = new JTextArea();

    }
}
