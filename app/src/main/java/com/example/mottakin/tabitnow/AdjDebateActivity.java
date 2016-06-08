package com.example.mottakin.tabitnow;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdjDebateActivity extends AppCompatActivity {

    Button submitScore;
    EditText Round, Gov, Gov1, Gov2, Gov3, GovReb, Opp, Opp1, Opp2, Opp3, OppReb;
    AlertDialog.Builder builder;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adj_debate);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        submitScore=(Button)findViewById(R.id.btnSubmitMarks);
        Round=(EditText)findViewById(R.id.txtRound);
        Gov=(EditText)findViewById(R.id.textGovTeam);
        Gov1=(EditText)findViewById(R.id.txtGov1);
        Gov2=(EditText)findViewById(R.id.txtGov2);
        Gov3=(EditText)findViewById(R.id.txtGov3);
        Opp=(EditText)findViewById(R.id.txtOppTeam);
        Opp1=(EditText)findViewById(R.id.txtOpp1);
        Opp2=(EditText)findViewById(R.id.txtOpp2);
        Opp3=(EditText)findViewById(R.id.txtOpp3);
        GovReb=(EditText)findViewById(R.id.txtGovRebuttal);
        OppReb=(EditText)findViewById(R.id.txtOppRebuttal);

//        submitScore.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(Round.equals("") || Gov.equals("") || Gov1.equals("") || Gov2.equals("") || Gov3.equals("") || Opp.equals("") ||
//                        Opp1.equals("") || Opp2.equals("") || Opp3.equals("") || GovReb.equals("") || OppReb.equals(""))
//                {
//                    builder=new AlertDialog.Builder(AdjDebateActivity.this);
//                    builder.setTitle("Something went wrong :(");
//                    builder.setMessage("You have forgot to put someone's marks!");
//                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            dialog.dismiss();
//                        }
//                    });
//                }
//                else
//                {
//                    int govTotal=Integer.parseInt(Gov1.getText().toString())+Integer.parseInt(Gov2.getText().toString())
//                            +Integer.parseInt(Gov3.getText().toString())+Integer.parseInt(GovReb.getText().toString());
//                    String govtotal=Integer.toString(govTotal);
//
//                    int oppTotal=Integer.parseInt(Opp1.getText().toString())+Integer.parseInt(Opp2.getText().toString())
//                            +Integer.parseInt(Opp3.getText().toString())+Integer.parseInt(OppReb.getText().toString());
//                    String opptotal=Integer.toString(govTotal);
//
//                    String winner;
//
//                    if(govTotal>oppTotal) winner=Gov.getText().toString();
//                    else winner=Gov.getText().toString();
//
//
//                }
//            }
//        });

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
