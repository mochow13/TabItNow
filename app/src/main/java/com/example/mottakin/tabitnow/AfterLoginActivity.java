package com.example.mottakin.tabitnow;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;

public class AfterLoginActivity extends AppCompatActivity {

    TextView receivedUsername;

    Button showArchive;
    Button createTournamentButton;
    Button logoutButton;
    Button searchButton;
    Button myTournaments;

    EditText searchBar;
    EditText searchBarArchive;

//    SessionManager session=new SessionManager(getApplicationContext());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final String recUser=getIntent().getStringExtra("USER_NAME");

        receivedUsername=(TextView)findViewById(R.id.welcomUserTextView);
        receivedUsername.setText("Welcome, "+recUser+"!");

        createTournamentButton=(Button)findViewById(R.id.btnCreateTournament);
        createTournamentButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                Intent intent=new Intent(AfterLoginActivity.this,CreateTournamentActivity.class);
                intent.putExtra("USER_NAME", recUser);
                startActivity(intent);
            }
        });

        logoutButton=(Button)findViewById(R.id.btnLogout);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                session.logoutUser();
                Intent intent=new Intent(AfterLoginActivity.this,splashClass.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

            }
        });

        searchButton=(Button)findViewById(R.id.btnSearch);
        searchBar=(EditText)findViewById(R.id.searchTextField);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackgroundTask backgroundtask=new BackgroundTask(AfterLoginActivity.this);
                backgroundtask.execute("search",searchBar.getText().toString());
            }
        });

        showArchive=(Button)findViewById(R.id.btnShowArchive);
        searchBarArchive=(EditText)findViewById(R.id.searchArchiveField);

        showArchive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(AfterLoginActivity.this,ViewArchiveActivity.class);
//                startActivity(intent);
                BackgroundTask backgroundtask=new BackgroundTask(AfterLoginActivity.this);
                backgroundtask.execute("search_archive",searchBarArchive.getText().toString());
            }
        });

        myTournaments=(Button)findViewById(R.id.btnMyTournaments);

        myTournaments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackgroundTask backgroundTask=new BackgroundTask(AfterLoginActivity.this);
                backgroundTask.execute("show_my_tournaments",recUser);
            }
        });

//        down= (ImageButton) findViewById(R.id.down);
//
//        down.setOnClickListener(new View.OnClickListener()
//        {
//            public void onClick(View v)
//            {
//                startActivity(new Intent(AfterLoginActivity.this, pop.class));
//            }
//        }
//        );
//        out= (ImageButton) findViewById(R.id.logout);
//
//        out.setOnClickListener(new View.OnClickListener()
//            {
//                public void onClick(View v)
//                {
//                    startActivity(new Intent(AfterLoginActivity.this, splashClass.class));
//                }
//            }
//        );

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
