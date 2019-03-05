package com.subham.assessment.utils;

public class DateUtils {
    public String dateIncrement(String date){
        int day = (date.charAt(0) - '0') * 10 + (date.charAt(1) -'0') * 1;
        int month = (date.charAt(3) - '0') * 10 + (date.charAt(4) - '0') * 1;
        int year = (date.charAt(6) - '0') * 1000 + (date.charAt(7) - '0') * 100 + (date.charAt(8) - '0') * 10 + (date.charAt(9) - '0');
        day++;
        if(day == 32){
            day = 1;
            month++;
        }
        if(month == 13){
            month = 1;
            year++;
        }
        String sday;
        if(day < 10){
            sday = new String("0" + String.valueOf(day));
        }
        else{
            sday = new String(String.valueOf(day));
        }
        String smonth;
        if(month < 10){
            smonth = new String("0" + String.valueOf(month));
        }
        else{
            smonth = new String(String.valueOf(month));
        }
        String syear = new String(String.valueOf(year));
        return (sday + "/" + smonth + "/" + syear);
    }

    public int dateDifference(String startDate, String endDate){
        int daysCount = 0;
        while (!startDate.equals(endDate)){
            startDate = dateIncrement(startDate);
            ++daysCount;
        }
        return daysCount;
    }
}
