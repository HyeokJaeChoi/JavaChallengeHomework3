import calendar.ui.CalendarView;
import event.ui.InputEventFormView;

import javax.swing.*;
import java.awt.*;

public class Main {
    private final static String TITLE = "일정관리";

    public static void main(String[] args) {
        JFrame container = new JFrame(TITLE);

        container.setLayout(new BorderLayout());
        container.add(new CalendarView(), BorderLayout.CENTER);
        container.add(new InputEventFormView(), BorderLayout.EAST);
        container.setSize(750, 450);
        container.setVisible(true);
    }
}
