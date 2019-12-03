package event.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveRemoveButtonForm extends JPanel {
    private JButton saveButton;
    private JButton removeButton;
    private EventButtonListener eventButtonListener;

    static final String SAVE = "저장";
    static final String REMOVE = "삭제";

    public SaveRemoveButtonForm() {
        setLayout(new FlowLayout());

        saveButton = new JButton(SAVE);
        removeButton = new JButton(REMOVE);
        eventButtonListener = new EventButtonListener();

        saveButton.addActionListener(eventButtonListener);
        removeButton.addActionListener(eventButtonListener);

        add(saveButton);
        add(removeButton);
    }

    class EventButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String clickedCommand = ((JButton)e.getSource()).getText();

            ((InputEventFormView)getParent()).executeCommand(clickedCommand);
        }
    }
}
