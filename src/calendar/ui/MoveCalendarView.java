package calendar.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MoveCalendarView extends JPanel {
    private JButton leftButton;
    private JButton rightButton;
    private JLabel currentYearMonth;
    private MoveCalendarEventListener moveCalendarEventListener;

    public MoveCalendarView(int initialYear, int initialMonth) {
        String initialTitle = initialYear + "년 " + initialMonth + "월";

        leftButton = new JButton("<");
        rightButton = new JButton(">");
        currentYearMonth = new JLabel(initialTitle);
        moveCalendarEventListener = new MoveCalendarEventListener();

        setLayout(new FlowLayout());
        leftButton.setSize(20,15);
        rightButton.setSize(20, 15);
        leftButton.addMouseListener(moveCalendarEventListener);
        rightButton.addMouseListener(moveCalendarEventListener);

        add(leftButton);
        add(currentYearMonth);
        add(rightButton);
    }

    public void updateView(int updatedYear, int updatedMonth) {
        String updatedTitle = updatedYear + "년 " + updatedMonth + "월";
        currentYearMonth.setText(updatedTitle);
    }

    class MoveCalendarEventListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            JButton clickedButton = (JButton)e.getSource();
            String clickedButtonText = clickedButton.getText();

            ((CalendarView)getParent()).updateCalendar(clickedButtonText);
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
