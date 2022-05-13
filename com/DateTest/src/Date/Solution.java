package Date;

import java.text.ParseException;
import java.util.Date;
import java.util.Calendar;

import static java.util.Date.parse;
/*
Работа с датой
*/

public class Solution {
    public static void main(String[] args)  throws ParseException{
        System.out.println(isDateOdd("MAY 1 1990"));
    }

    public static int isDateOdd(String date)  throws ParseException{
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(Date.parse(date)));
         return cal.get(Calendar.MONTH) ;

    }
}

