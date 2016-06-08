package com.example.mottakin.tabitnow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DebugActivity extends AppCompatActivity {

    TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debug);

        String received=getIntent().getStringExtra("DEBUG");

        txtView=(TextView)findViewById(R.id.textView);

        txtView.setText(received);
    }
}
