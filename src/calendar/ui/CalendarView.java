package calendar.ui;

import calendar.data.CustomDate;
import util.DateUtil;

import javax.swing.*;
import java.awt.*;

public class CalendarView extends JPanel {
    private final int initialYear = 2019;
    private final int initialMonth = 2;

    private MoveCalendarView moveCalendarView;
    private WeekView weekView;
    private CustomDate customDate;

    public CalendarView() {
        setLayout(new BorderLayout());
        setSize(420, 450);

        customDate = new CustomDate(initialYear, initialMonth);

        moveCalendarView = new MoveCalendarView(initialYear, initialMonth);
        add(moveCalendarView, BorderLayout.NORTH);
        weekView = new WeekView(DateUtil.getDayViewPos(customDate.getFirstDayOfTheWeek()), customDate.getDays());
        add(weekView, BorderLayout.CENTER);
    }

    public void updateCalendar(String command) {
        switch (command) {
            case "<" :
                DateUtil.moveDateBeforeMonth(customDate);
                break;
            case ">" :
                DateUtil.moveDateAfterMonth(customDate);
                break;
        }

        moveCalendarView.updateView(customDate.getYear(), customDate.getMonth());
        weekView.updateView(DateUtil.getDayViewPos(customDate.getFirstDayOfTheWeek()), customDate.getDays());
    }

    public CustomDate getDate() {
        return customDate;
    }
}
