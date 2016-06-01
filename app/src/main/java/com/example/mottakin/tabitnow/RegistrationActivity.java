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

public class RegistrationActivity extends AppCompatActivity {

    EditText Name, Username, Institution, Email, PhoneNum, Password, ConfPass;
    Button regButton, cancelButton;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        Name=(EditText)findViewById(R.id.txtName);
        Username=(EditText)findViewById(R.id.txtUsername);
        Email=(EditText)findViewById(R.id.txtEmail);
        PhoneNum=(EditText)findViewById(R.id.txtPhone);
//        Institution=(EditText)findViewById(R.id.txtInstitution);
        Password=(EditText)findViewById(R.id.txtPassword);
        ConfPass=(EditText)findViewById(R.id.txtConfPassword);

        regButton=(Button)findViewById(R.id.btnRegister);
        cancelButton=(Button)findViewById(R.id.btnCancel);


        regButton.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {
//                    if(Name.getText().toString().equals("") || Username.getText().toString().equals("")
//                        || Institution.getText().toString().equals("") || Email.getText().toString().equals("") ||
//                        PhoneNum.getText().toString().equals("") || Password.getText().toString().equals("") ||
//                        ConfPass.getText().toString().equals(""))
                    if(Name.getText().toString().equals("") || Username.getText().toString().equals("")
                            || Email.getText().toString().equals("") ||
                            PhoneNum.getText().toString().equals("") || Password.getText().toString().equals("") ||
                            ConfPass.getText().toString().equals(""))
                    {
                        builder=new AlertDialog.Builder(RegistrationActivity.this);
                        builder.setTitle("Something went wrong :(");
                        builder.setMessage("Please fill all the fields with proper information.");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

                        AlertDialog alertDialog=builder.create();
                        alertDialog.show();
                    }
                    else if(!(Password.getText().toString().equals(ConfPass.getText().toString())))
                    {
                        builder=new AlertDialog.Builder(RegistrationActivity.this);
                        builder.setTitle("Something went wrong :(");
                        builder.setMessage("Passwords do not match.");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                Password.setText("");
                                ConfPass.setText("");
                            }
                        });

                        AlertDialog alertDialog=builder.create();
                        alertDialog.show();
                    }
                    else
                    {
                        BackgroundTask backgroundtask=new BackgroundTask(RegistrationActivity.this);
//                        backgroundtask.execute("register",Name.getText().toString(),Username.getText().toString(),
//                                Email.getText().toString(),PhoneNum.getText().toString(),Institution.getText().toString(),
//                                Password.getText().toString());

                        backgroundtask.execute("register",Name.getText().toString(),Username.getText().toString(),
                                Email.getText().toString(),PhoneNum.getText().toString(),Password.getText().toString());
                    }
                }
            }
        );


        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegistrationActivity.this,splashClass.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

    }

}
