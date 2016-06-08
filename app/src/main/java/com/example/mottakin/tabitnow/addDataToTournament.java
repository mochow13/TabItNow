package com.example.mottakin.tabitnow;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class addDataToTournament extends AppCompatActivity {

    TextView Title, Organizer, Code, Host, Venue, Startdate, Enddate, Champion, Runnerup, Bestspeaker;
    Button Add, Cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data_to_tournament);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String foundData=getIntent().getStringExtra("TOURNAMENT_INFO");

        final ArrayList<String> tournamentInfo=new ArrayList<>();

        StringTokenizer ST=new StringTokenizer(foundData,"#");

        while(ST.hasMoreTokens())
        {
            String now=ST.nextToken();
            tournamentInfo.add(now);
        }

        Title=(TextView)findViewById(R.id.TitleText);
        Title.setText(tournamentInfo.get(1));

        Code=(TextView)findViewById(R.id.CodeText);
        Code.setText("Tournament ID: "+ tournamentInfo.get(0));

        Organizer=(TextView)findViewById(R.id.OrgText);
        Organizer.setText("Organized by: "+tournamentInfo.get(2));

        Venue=(TextView)findViewById(R.id.VenueText);
        Venue.setText("Venue: "+tournamentInfo.get(4));

        Startdate=(TextView)findViewById(R.id.StartText);
        Startdate.setText("Start Date: "+tournamentInfo.get(5));

        Enddate=(TextView)findViewById(R.id.EndText);
        Enddate.setText("End Date: "+tournamentInfo.get(6));

        Champion=(TextView)findViewById(R.id.ChampText);
        Champion.setText("Champion Team: "+tournamentInfo.get(7));

        Runnerup=(TextView)findViewById(R.id.RunText);
        Runnerup.setText("Runner Up Team: "+tournamentInfo.get(8));

        Bestspeaker=(TextView)findViewById(R.id.BestText);
        Bestspeaker.setText("Best Speaker: "+tournamentInfo.get(9));

        Add=(Button)findViewById(R.id.btnAddData);
        Cancel=(Button)findViewById(R.id.btnCancelAdding);

        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(addDataToTournament.this,LoadTournament.class);
                intent.putExtra("TOURNAMENT_CODE",tournamentInfo.get(0));
                startActivity(intent);
            }
        });

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
