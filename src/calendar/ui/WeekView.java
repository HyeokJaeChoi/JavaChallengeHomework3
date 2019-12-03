package calendar.ui;

import util.DateUtil;

import javax.swing.*;
import java.awt.*;

public class WeekView extends JPanel {
    private JLabel dayOfTheWeeks[];
    private DayView dayViews[];
    private final int cellGap = 2;

    public WeekView(int initialStartDayOfTheWeek, int initialDays) {
        dayOfTheWeeks = new JLabel[7];
        dayViews = new DayView[42];

        setLayout(new GridLayout(7, 7, cellGap, cellGap));

        for(int i = 0; i < dayOfTheWeeks.length; i++) {
            dayOfTheWeeks[i] = new JLabel("", SwingConstants.CENTER);
            dayOfTheWeeks[i].setSize(60, 20);
            dayOfTheWeeks[i].setText(DateUtil.getDayOfTheWeek(i));
            add(dayOfTheWeeks[i]);
        }

        for(int i = 0; i < dayViews.length; i++) {
            dayViews[i] = new DayView();
            dayViews[i].setBackground(Color.WHITE);
            add(dayViews[i]);
        }

        for(int i = initialStartDayOfTheWeek; i < initialStartDayOfTheWeek + initialDays; i++) {
            dayViews[i].setDay(i - (initialStartDayOfTheWeek - 1));
        }
    }

    public void updateView(int updatedStartDayOfTheWeek, int updatedDays) {
        for(int i = 0; i < updatedStartDayOfTheWeek; i++) {
            dayViews[i].setDay(DayView.EMPTY);
            dayViews[i].updateDayUnSelected();
        }

        for(int i = updatedStartDayOfTheWeek; i < updatedStartDayOfTheWeek + updatedDays; i++) {
            dayViews[i].setDay(i - (updatedStartDayOfTheWeek - 1));
            dayViews[i].updateDayUnSelected();
        }

        for(int i = updatedStartDayOfTheWeek + updatedDays; i < 42; i++) {
            dayViews[i].setDay(DayView.EMPTY);
            dayViews[i].updateDayUnSelected();
        }
    }
}
