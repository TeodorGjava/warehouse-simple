package com.ClassesAndFrames.common;

import java.util.GregorianCalendar;

public class DateTime {
    public DateTime() {
    }

    GregorianCalendar cal = new GregorianCalendar();
    int month = cal.get(java.util.Calendar.MONTH);
    int day = cal.get(java.util.Calendar.DAY_OF_MONTH);
    int year = cal.get(java.util.Calendar.YEAR);
    public String getDate(){
        return (day + "/" + (month + 1) + "/" + year);
    }
}
