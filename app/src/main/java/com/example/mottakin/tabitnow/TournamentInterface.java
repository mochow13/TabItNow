package com.example.mottakin.tabitnow;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

/**
 * Created by mottakin on 6/7/16.
 */
public class TournamentInterface {

    public void TournamentInterface(){}

    public void execute(String data) throws ParseException {

        StringTokenizer ST=new StringTokenizer(data);
        ArrayList<String> info=new ArrayList<>();

        while(ST.hasMoreTokens())
        {
            String now=ST.nextToken();
            info.add(now);
        }

//        Date currDate=new SimpleDateFormat("yyyy-mm-dd").format(new Date());
//        SimpleDateFormat format=new SimpleDateFormat("yyyy-mm-dd");
//
//        Date dateStart=format.parse(info.get(5));
//        Date dateEnd=format.parse(info.get(6));


    }
}
