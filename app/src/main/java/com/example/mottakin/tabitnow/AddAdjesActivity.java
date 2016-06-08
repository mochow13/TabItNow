package com.example.mottakin.tabitnow;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddAdjesActivity extends AppCompatActivity {

    EditText adjUsername, adjInstitution;
    Button addAdj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_adjes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final String tournamentCode=getIntent().getStringExtra("TOURNAMENT_CODE");

        adjInstitution=(EditText)findViewById(R.id.txtAdjInstitution);
        adjUsername=(EditText)findViewById(R.id.txtAdjUsername);
        addAdj=(Button)findViewById(R.id.btnAddAdj);

        addAdj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackgroundTask backgroundTask=new BackgroundTask(AddAdjesActivity.this);
                backgroundTask.execute("add_adj", tournamentCode+"_people", adjUsername.getText().toString(), adjInstitution.getText().toString());
                adjUsername.setText("");
                adjInstitution.setText("");
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
