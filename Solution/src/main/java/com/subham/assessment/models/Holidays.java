package com.subham.assessment.models;

import lombok.ToString;

import java.util.ArrayList;

@ToString
public class Holidays {
    private  ArrayList<HolidayArguement> holidays;

    public Holidays(){
        holidays = new ArrayList<HolidayArguement>();
        holidays.add(new HolidayArguement("21/03/2019", "Holi"));
        holidays.add(new HolidayArguement("26/01/2019", "Republic Day"));
        holidays.add(new HolidayArguement("15/08/2019", "Independence Day"));
    }


    public  void view(){
        for(HolidayArguement holidayArguement : holidays){
            System.out.println(holidayArguement.toString());
        }
    }

    public void add(String date, String holidayname){
        holidays.add(new HolidayArguement(date, holidayname));
    }

    public void remove(String date, String holidayname){
        holidays.remove(new HolidayArguement(date, holidayname));
    }

    public boolean isHoliday(String date){
        for(HolidayArguement holidayArguement : holidays){
            if(holidayArguement.getDate().equals(date)){
                return true;
            }
        }
        return false;
    }
}
