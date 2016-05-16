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
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;

public class AfterLoginActivity extends AppCompatActivity {

    TextView receivedUsername;

    Button joinTournamentButton;
    Button createTournamentButton;
    Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        createTournamentButton=(Button)findViewById(R.id.btnCreateTournament);

        createTournamentButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                Intent intent=new Intent(AfterLoginActivity.this,CreateTournamentActivity.class);

                startActivity(intent);
            }
        });

        receivedUsername=(TextView)findViewById(R.id.welcomUserTextView);
        receivedUsername.setText("Welcome, "+getIntent().getStringExtra("USER_NAME")+"!");

        logoutButton=(Button)findViewById(R.id.btnLogout);

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(AfterLoginActivity.this,splashClass.class);
                startActivity(intent);

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
