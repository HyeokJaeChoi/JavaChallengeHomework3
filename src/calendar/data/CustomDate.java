package calendar.data;

import util.DateUtil;

public class CustomDate {
    private int year;
    private int month;
    private int firstDayOfTheWeek;
    private int lastDayOfTheWeek;
    private int days;

    public CustomDate(int year, int month) {
        this.year = year;
        this.month = month;
        this.firstDayOfTheWeek = DateUtil.getFirstDayOfTheWeek(this.year, this.month);
        this.lastDayOfTheWeek = DateUtil.getLastDayOfTheWeek(this.year, this.month, this.firstDayOfTheWeek);
        this.days = DateUtil.getDaysInMonth(this.year, this.month);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getFirstDayOfTheWeek() {
        return firstDayOfTheWeek;
    }

    public void setFirstDayOfTheWeek(int firstDayOfTheWeek) {
        this.firstDayOfTheWeek = firstDayOfTheWeek;
    }

    public int getLastDayOfTheWeek() {
        return lastDayOfTheWeek;
    }

    public void setLastDayOfTheWeek(int lastDayOfTheWeek) {
        this.lastDayOfTheWeek = lastDayOfTheWeek;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
