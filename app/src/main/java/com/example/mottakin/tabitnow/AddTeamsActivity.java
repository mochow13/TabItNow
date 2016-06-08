package com.example.mottakin.tabitnow;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddTeamsActivity extends AppCompatActivity {

    EditText  teamName, member1, member2, member3, instName;
    Button addMember1, addMember2, addMember3, doneAdding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teams);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final String tournamentCode=getIntent().getStringExtra("TOURNAMENT_CODE");

        teamName=(EditText)findViewById(R.id.txtNameOfTeam);
        member1=(EditText)findViewById(R.id.txtMember1);
        member2=(EditText)findViewById(R.id.txtMember2);
        member3=(EditText)findViewById(R.id.txtMember3);
        instName=(EditText)findViewById(R.id.txtInstName);

        doneAdding=(Button)findViewById(R.id.btnDoneAdding);
        addMember1=(Button)findViewById(R.id.btnAddMember1);
        addMember2=(Button)findViewById(R.id.btnAddMember2);
        addMember3=(Button)findViewById(R.id.btnAddMember3);

        doneAdding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        addMember1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackgroundTask backgroundTask=new BackgroundTask(AddTeamsActivity.this);

//                Intent intent=new Intent(AddTeamsActivity.this, splashClass.class);
//                startActivity(intent);

                backgroundTask.execute("add_debater", tournamentCode+"_people", member1.getText().toString(), teamName.getText().toString(),
                                        instName.getText().toString());
            }
        });

        addMember2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackgroundTask backgroundTask=new BackgroundTask(AddTeamsActivity.this);

                backgroundTask.execute("add_debater", tournamentCode+"_people", member2.getText().toString(), teamName.getText().toString(),
                        instName.getText().toString());
            }
        });

        addMember3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackgroundTask backgroundTask=new BackgroundTask(AddTeamsActivity.this);

                backgroundTask.execute("add_debater", tournamentCode+"_people", member3.getText().toString(), teamName.getText().toString(),
                        instName.getText().toString());
            }
        });

        teamName.setText("");
        member1.setText("");
        member2.setText("");
        member3.setText("");
        instName.setText("");

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
