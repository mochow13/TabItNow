package com.example.mottakin.tabitnow;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by mottakin on 4/29/16.
 */
public class splashClass extends Activity {

    EditText inputUsername;
    EditText inputPassword;
    Button loginButton;
    Button signupButton;

    AlertDialog.Builder builder;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        inputUsername=(EditText)findViewById(R.id.usernameTextField);
        inputPassword=(EditText)findViewById(R.id.passwordTextField);
        loginButton=(Button)findViewById(R.id.btnLogin);
        signupButton=(Button)findViewById(R.id.btnSignup);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String usernameString=inputUsername.getText().toString();
                String userPassword=inputPassword.getText().toString();

//                Intent intent=new Intent(splashClass.this,AfterLoginActivity.class);
//
//                intent.putExtra("USER_NAME",usernameString);
//                intent.putExtra("USER_PASSWORD",userPassword);
//
//                startActivity(intent);

                if(usernameString.equals("") || userPassword.equals(""))
                {
                    builder=new AlertDialog.Builder(splashClass.this);
                    builder.setTitle("Something went wrong :(");
                    builder.setMessage("Some field is empty.");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });

                    AlertDialog alertDialog=builder.create();
                    alertDialog.show();
                }
                else
                {
                    BackgroundTask backgroundtask=new BackgroundTask(splashClass.this);
                    backgroundtask.execute("login",inputUsername.getText().toString(),inputPassword.getText().toString());
                }
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(splashClass.this,RegistrationActivity.class);
                startActivity(intent);

            }
        });
    }
}
