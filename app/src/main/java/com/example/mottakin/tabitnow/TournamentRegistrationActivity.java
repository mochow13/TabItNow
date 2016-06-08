package com.example.mottakin.tabitnow;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class TournamentRegistrationActivity extends AppCompatActivity {

    EditText ClubInitials, TeamName;
    RadioButton Debater, Adjudicator;
    Button JoinNow, Discard;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament_registration);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final String tournamentCode=getIntent().getStringExtra("TOURNAMENT_CODE");
        final String user=getIntent().getStringExtra("USER_NAME");

        ClubInitials=(EditText)findViewById(R.id.txtClubInitials);
        TeamName=(EditText)findViewById(R.id.txtTeamName);

        Debater=(RadioButton) findViewById(R.id.radioDebater);
        Adjudicator=(RadioButton) findViewById(R.id.radioAdj);

        JoinNow=(Button)findViewById(R.id.btnJoinNow);
        Discard=(Button)findViewById(R.id.btnDiscard);

        Discard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        JoinNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String clubInitial=ClubInitials.getText().toString();
                String teamName=TeamName.getText().toString();

                if((clubInitial.length()==0 || teamName.length()==0) && (!Debater.isChecked() && !Adjudicator.isChecked()))
                {
                    builder=new AlertDialog.Builder(TournamentRegistrationActivity.this);
                    builder.setTitle("Something went wrong :(");
                    builder.setMessage("Please fill all the fields with proper information.");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                }
                else if(teamName.length()>0 && Adjudicator.isChecked())
                {
                    builder=new AlertDialog.Builder(TournamentRegistrationActivity.this);
                    builder.setTitle("Something went wrong :(");
                    builder.setMessage("An adjudicator cannot have a team.");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                }
                else
                {
//                    Intent intent=new Intent(TournamentRegistrationActivity.this,splashClass.class);
//                    startActivity(intent);
                    BackgroundTask backgroundTask=new BackgroundTask(TournamentRegistrationActivity.this);
                    String role;
                    if(Adjudicator.isChecked()) role="adj";
                    else role="debater";
                    if(Adjudicator.isChecked()) teamName="N/A";
                    backgroundTask.execute("join_tournament", tournamentCode+"_people", user, clubInitial, teamName, role);
                    ClubInitials.setText("");
                    TeamName.setText("");
                }
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
