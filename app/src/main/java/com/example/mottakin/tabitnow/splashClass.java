package com.example.mottakin.tabitnow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

                Intent intent=new Intent(splashClass.this,AfterLoginActivity.class);

                intent.putExtra("USER_NAME",usernameString);
                intent.putExtra("USER_PASSWORD",userPassword);

                startActivity(intent);
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
