package calendar.ui;

import calendar.data.CustomDate;
import event.ui.InputEventFormView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DayView extends JPanel {
    private JLabel dayLabel;
    private JLabel eventNameLabel;
    static final int EMPTY = 0;

    public DayView() {
        dayLabel = new JLabel();
        eventNameLabel = new JLabel();

        dayLabel.setSize(60, 30);
        eventNameLabel.setSize(60, 30);

        dayLabel.setHorizontalAlignment(SwingConstants.CENTER);
        eventNameLabel.setHorizontalAlignment(SwingConstants.CENTER);

        setSize(60, 60);
        setLayout(new GridLayout(2, 1));

        add(dayLabel);
        add(eventNameLabel);
        addMouseListener(new DayClickEventListener());
    }

    public void setDay(int day) {
        if(day == EMPTY) {
            dayLabel.setText("");
        }
        else {
            dayLabel.setText(String.valueOf(day));
        }
    }

    public String getEventName() {
        return this.eventNameLabel.getText();
    }

    public void setEventName(String eventName) {
        eventNameLabel.setText(eventName);
    }

    public void updateDaySelected() {
        dayLabel.setForeground(Color.RED);
        eventNameLabel.setVisible(true);
    }

    public void updateDayUnSelected() {
        dayLabel.setForeground(Color.BLACK);
        eventNameLabel.setVisible(false);
    }

    class DayClickEventListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            DayView clickedDayView = (DayView)e.getSource();

            JFrame root = (JFrame) SwingUtilities.getRoot(clickedDayView);
            Component[] components = root.getContentPane().getComponents();
            CustomDate currentYearMonth = ((CalendarView)components[0]).getDate();
            String currentDate = Integer.toString(currentYearMonth.getYear()) + "/" + Integer.toString(currentYearMonth.getMonth()) + "/" + dayLabel.getText();

            ((InputEventFormView)components[1]).setDaySelected(clickedDayView, currentDate);
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
