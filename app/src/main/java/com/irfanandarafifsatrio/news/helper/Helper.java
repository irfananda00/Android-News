package com.irfanandarafifsatrio.news.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by irfanandarafifsatrio on 4/15/17.
 */

public class Helper {

    public static String dateFormater(String dateString){
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = fmt.parse(dateString);
            SimpleDateFormat fmtOut = new SimpleDateFormat("dd MMMM yyyy");
            return fmtOut.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

}
