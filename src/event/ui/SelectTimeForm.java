package event.ui;

import javax.swing.*;
import java.awt.*;

public class SelectTimeForm extends JPanel {
    private JLabel title;
    private JComboBox<Integer>[] timeBoxes;

    public SelectTimeForm(String title) {
        setLayout(new FlowLayout());

        this.title = new JLabel(title);
        this.timeBoxes = new JComboBox[3];

        add(this.title);

        for(int i = 0; i < timeBoxes.length; i++) {
            timeBoxes[i] = new JComboBox<>();
            add(timeBoxes[i]);
        }
        for(int i = 0; i < 24; i++) {
            timeBoxes[0].addItem(i);
        }
        for(int i = 0; i < 60; i++) {
            timeBoxes[1].addItem(i);
        }
        for(int i = 0; i < 60; i++) {
            timeBoxes[2].addItem(i);
        }
    }

    public String getSelectedTimes() {
        return timeBoxes[0].getSelectedItem()
                + "/"
                + timeBoxes[1].getSelectedItem()
                + "/"
                + timeBoxes[2].getSelectedItem();

    }

    public void setSelectedTimes(String selectedTime) {
        String[] selectedTimes;
        if(selectedTime.isEmpty()) {
            selectedTimes = new String[]{"0", "0", "0"};
        }
        else {
            selectedTimes = selectedTime.split("/");

        }

        for(int i = 0; i < selectedTimes.length; i++) {
            timeBoxes[i].setSelectedIndex(Integer.parseInt(selectedTimes[i]));
        }
    }
}
