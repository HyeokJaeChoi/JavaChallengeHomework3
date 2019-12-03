package util;

import calendar.data.CustomDate;

public class DateUtil {
    private static final int[] daysInMonth = { 31,28,31,30,31,30,31,31,30,31,30,31 };

    public static String getDayOfTheWeek(int dayOfTheWeek) {
        switch(dayOfTheWeek) {
            case 0 :
                return "월";
            case 1 :
                return "화";
            case 2 :
                return "수";
            case 3 :
                return "목";
            case 4 :
                return "금";
            case 5 :
                return "토";
            case 6 :
                return "일";
        }

        return null;
    }

    public static int getDaysInMonth(int year, int month) {
        if(isLeapYear(year)) {
            daysInMonth[1]++;
        }

        int days = daysInMonth[month - 1];
        if(isLeapYear(year)) {
            daysInMonth[1]--;
        }

        return days;
    }

    public static int getFirstDayOfTheWeek(int year, int month) {
        int daySum = 0;

        for(int i = 1; i < year; i++) {
            if(isLeapYear(year)) {
                daySum += 366;
            }
            else {
                daySum += 365;
            }
        }

        if(isLeapYear(year)) {
            daysInMonth[1]++;
        }

        for(int i = 0; i < month - 1; i++) {
            daySum += daysInMonth[i];
        }

        if(isLeapYear(year)) {
            daysInMonth[1]--;
        }

        return daySum % 7;
    }

    public static int getLastDayOfTheWeek(int year, int month, int firstDayOfTheWeek) {
        if(month == 2 && isLeapYear(year)) {
            daysInMonth[1]++;
        }

        int lastDayOfTheWeekPointer = (daysInMonth[month - 1] % 7) - 1;
        if(month == 2 && isLeapYear(year)) {
            daysInMonth[1]--;
        }

        return (firstDayOfTheWeek + lastDayOfTheWeekPointer) % 7;
    }

    private static boolean isLeapYear(int year) {
        return ((year % 4 == 0) && !(year % 100 == 0)) || (year % 400) == 0;
    }

    public static void moveDateBeforeMonth(CustomDate date) {
        if(date.getMonth() == 1) {
            date.setMonth(12);
            date.setYear(date.getYear() - 1);
        }
        else {
            date.setMonth(date.getMonth() - 1);
        }

        if(isLeapYear(date.getYear())) {
            daysInMonth[1]++;
        }

        date.setDays(daysInMonth[date.getMonth() - 1]);

        if(date.getFirstDayOfTheWeek() == 0) {
            date.setLastDayOfTheWeek(6);
        }
        else {
            date.setLastDayOfTheWeek(date.getFirstDayOfTheWeek() - 1);
        }

        int firstDayOfTheWeekPointer = daysInMonth[date.getMonth() - 1] - 28 - 1;

        if(isLeapYear(date.getYear())) {
            daysInMonth[1]--;
        }

        int firstDayOfTheWeek = date.getLastDayOfTheWeek() - firstDayOfTheWeekPointer;
        if(firstDayOfTheWeek < 0) {
            firstDayOfTheWeek += 7;
        }

        date.setFirstDayOfTheWeek(firstDayOfTheWeek % 7);
    }

    public static void moveDateAfterMonth(CustomDate date) {
        if(date.getMonth() == 12) {
            date.setMonth(1);
            date.setYear(date.getYear() + 1);
        }
        else {
            date.setMonth(date.getMonth() + 1);
        }

        if(isLeapYear(date.getYear())) {
            daysInMonth[1]++;
        }

        date.setDays(daysInMonth[date.getMonth() - 1]);

        if(date.getLastDayOfTheWeek() == 6) {
            date.setFirstDayOfTheWeek(0);
        }
        else {
            date.setFirstDayOfTheWeek(date.getLastDayOfTheWeek() + 1);
        }

        int lastDayOfTheWeekPointer = daysInMonth[date.getMonth() -1] - 28 - 1;
        if(isLeapYear(date.getYear())) {
            daysInMonth[1]--;
        }

        date.setLastDayOfTheWeek((date.getFirstDayOfTheWeek() + lastDayOfTheWeekPointer) % 7);
    }

    public static int getDayViewPos(int dayOfTheWeek) {
        if(dayOfTheWeek > 0) {
            return --dayOfTheWeek;
        }
        else {
            return 6;
        }
    }
}