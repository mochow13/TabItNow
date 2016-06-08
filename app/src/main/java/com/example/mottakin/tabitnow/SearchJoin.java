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

public class SearchJoin extends AppCompatActivity {

    TextView Title, Organizer, Code, Host, Venue, Startdate, Enddate, Champion, Runnerup, Bestspeaker;
    Button Join, Cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_join);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String foundResult=getIntent().getStringExtra("TOURNAMENT_DETAILS");
        final String user=getIntent().getStringExtra("USER_NAME");

//        Title=(TextView)findViewById(R.id.txtTitle);
//        Title.setText(foundResult);

        final ArrayList<String> tournamentInfo=new ArrayList<>();

        StringTokenizer ST=new StringTokenizer(foundResult,"#");

        while(ST.hasMoreTokens())
        {
            String now=ST.nextToken();
            tournamentInfo.add(now);
        }

        Title=(TextView)findViewById(R.id.textTitle);
        Title.setText(tournamentInfo.get(1));

        Code=(TextView)findViewById(R.id.textCode);
        Code.setText("Tournament ID: "+ tournamentInfo.get(0));

        Organizer=(TextView)findViewById(R.id.textOrg);
        Organizer.setText("Organized by: "+tournamentInfo.get(2));

        Host=(TextView)findViewById(R.id.textHost);
        Host.setText("Host username: "+tournamentInfo.get(3));

        Venue=(TextView)findViewById(R.id.textVenue);
        Venue.setText("Venue: "+tournamentInfo.get(4));

        Startdate=(TextView)findViewById(R.id.textStart);
        Startdate.setText("Start Date: "+tournamentInfo.get(5));

        Enddate=(TextView)findViewById(R.id.textEnd);
        Enddate.setText("End Date: "+tournamentInfo.get(6));

        Champion=(TextView)findViewById(R.id.textChamp);
        Champion.setText("Champion Team: "+tournamentInfo.get(7));

        Runnerup=(TextView)findViewById(R.id.textRunn);
        Runnerup.setText("Runner Up Team: "+tournamentInfo.get(8));

        Bestspeaker=(TextView)findViewById(R.id.textBest);
        Bestspeaker.setText("Best Speaker: "+tournamentInfo.get(9));

        Join=(Button)findViewById(R.id.btnJoin);
        Cancel=(Button)findViewById(R.id.btnCancel);

        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(SearchJoin.this,SearchResultsActivity.class);
//                startActivity(intent);
                finish();
            }
        });

        Join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SearchJoin.this,TournamentRegistrationActivity.class);
                intent.putExtra("TOURNAMENT_CODE",tournamentInfo.get(0));
                intent.putExtra("USER_NAME",user);
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
