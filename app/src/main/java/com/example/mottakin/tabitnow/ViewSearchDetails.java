package com.example.mottakin.tabitnow;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class ViewSearchDetails extends AppCompatActivity {

    TextView Title, Organizer, Host, Venue, Startdate, Enddate, Champion, Runnerup, Bestspeaker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_details);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        String foundResult=getIntent().getStringExtra("TOURNAMENT_DETAILS");

//        Title=(TextView)findViewById(R.id.txtTitle);
//        Title.setText(foundResult);

        ArrayList<String> tournamentInfo=new ArrayList<>();

        StringTokenizer ST=new StringTokenizer(foundResult,"#");

        while(ST.hasMoreTokens())
        {
            String now=ST.nextToken();
            tournamentInfo.add(now);
        }

        Title=(TextView)findViewById(R.id.txtTitle);
        Title.setText(tournamentInfo.get(1));

        Organizer=(TextView)findViewById(R.id.txtOrg);
        Organizer.setText("Organized by: "+tournamentInfo.get(2));

        Host=(TextView)findViewById(R.id.txtHost);
        Host.setText("Host username: "+tournamentInfo.get(3));

        Venue=(TextView)findViewById(R.id.txtVenue);
        Venue.setText("Venue: "+tournamentInfo.get(4));

        Startdate=(TextView)findViewById(R.id.txtStart);
        Startdate.setText("Start Date: "+tournamentInfo.get(5));

        Enddate=(TextView)findViewById(R.id.txtEnd);
        Enddate.setText("End Date: "+tournamentInfo.get(6));

        Champion=(TextView)findViewById(R.id.txtChamp);
        Champion.setText("Champion Team: "+tournamentInfo.get(7));

        Runnerup=(TextView)findViewById(R.id.txtRunn);
        Runnerup.setText("Runner Up Team: "+tournamentInfo.get(8));

        Bestspeaker=(TextView)findViewById(R.id.txtBest);
        Bestspeaker.setText("Best Speaker: "+tournamentInfo.get(9));

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

}
