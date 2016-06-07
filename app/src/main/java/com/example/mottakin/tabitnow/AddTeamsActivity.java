package com.example.mottakin.tabitnow;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddTeamsActivity extends AppCompatActivity {

    EditText  teamName, member1, member2, member3;
    Button addThisTeam, doneAdding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teams);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        teamName=(EditText)findViewById(R.id.txtNameOfTeam);
        member1=(EditText)findViewById(R.id.txtMember1);
        member2=(EditText)findViewById(R.id.txtMember2);
        member3=(EditText)findViewById(R.id.txtMember3);

        doneAdding=(Button)findViewById(R.id.btnDoneAdding);
        addThisTeam=(Button)findViewById(R.id.btnAddThisTeam);

        doneAdding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        addThisTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackgroundTask backgroundTask=new BackgroundTask(AddTeamsActivity.this);
                backgroundTask.execute("add_debater",member1.getText().toString()+" "+teamName.getText().toString());
                backgroundTask.execute("add_debater",member2.getText().toString()+" "+teamName.getText().toString());
                backgroundTask.execute("add_debater",member3.getText().toString()+" "+teamName.getText().toString());
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
