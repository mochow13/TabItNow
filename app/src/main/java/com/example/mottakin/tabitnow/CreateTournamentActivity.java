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
import android.widget.EditText;

import java.util.Date;

public class CreateTournamentActivity extends AppCompatActivity {

    EditText codeName, compTitle, orgClub, venueName;
    EditText startDate, endDate;
    Button createButton, cancelButton;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_tournament);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        codeName=(EditText)findViewById(R.id.txtCodeName);
        compTitle=(EditText)findViewById(R.id.txtCompTitle);
        orgClub=(EditText)findViewById(R.id.txtOrgClub);
        venueName=(EditText)findViewById(R.id.txtVenue);
        startDate=(EditText) findViewById(R.id.dateStart);
        endDate=(EditText)findViewById(R.id.dateEnd);

        createButton=(Button)findViewById(R.id.btnCreateTournament);
        cancelButton=(Button)findViewById(R.id.btnCancel);

        final String currUser=getIntent().getStringExtra("USER_NAME");

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                session.logoutUser();
                Intent intent=new Intent(CreateTournamentActivity.this,AfterLoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

            }
        });

        createButton.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v)
             {
                 if(codeName.getText().toString().equals("") || compTitle.getText().toString().equals("")
                         || orgClub.getText().toString().equals("") || venueName.getText().toString().equals("")
                         || startDate.getText().toString().equals("") ||
                         endDate.getText().toString().equals("")) {
                     builder = new AlertDialog.Builder(CreateTournamentActivity.this);
                     builder.setTitle("Something went wrong :(");
                     builder.setMessage("Please fill all the fields with proper information.");
                     builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which) {
                             dialog.dismiss();
                         }
                     });

                     AlertDialog alertDialog = builder.create();
                     alertDialog.show();
                 }
                 else
                 {
                     BackgroundTask backgroundtask=new BackgroundTask(CreateTournamentActivity.this);
                     backgroundtask.execute("create_tournament",codeName.getText().toString(),compTitle.getText().toString(),
                             orgClub.getText().toString(),currUser,venueName.getText().toString(),
                             startDate.getText().toString(),endDate.getText().toString());
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
