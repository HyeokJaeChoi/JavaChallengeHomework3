package event.ui;

import javax.swing.*;
import java.awt.*;

public class InputEventContentForm extends JPanel {
    private JLabel title;
    private JTextArea inputContent;

    public InputEventContentForm() {
        setLayout(new FlowLayout());

        title = new JLabel("메모");
        inputContent = new JTextArea(14, 18);

        add(title);
        add(inputContent);
    }

    public String getEventContent() {
        return inputContent.getText();
    }

    public void setEventContent(String content) {
        inputContent.setText(content);
    }
}
