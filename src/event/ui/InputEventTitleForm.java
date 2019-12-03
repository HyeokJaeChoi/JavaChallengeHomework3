package event.ui;

import javax.swing.*;
import java.awt.*;

public class InputEventTitleForm extends JPanel {
    private JLabel eventTitle;
    private JTextField inputEventTitle;

    public InputEventTitleForm() {
        eventTitle = new JLabel("제목");
        inputEventTitle = new JTextField(18);

        setLayout(new FlowLayout());
        add(eventTitle);
        add(inputEventTitle);
    }

    public String getEventTitle() {
        return inputEventTitle.getText();
    }

    public void setEventTitle(String title) {
        inputEventTitle.setText(title);
    }
}
