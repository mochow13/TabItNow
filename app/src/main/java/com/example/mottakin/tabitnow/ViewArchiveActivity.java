package com.example.mottakin.tabitnow;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class ViewArchiveActivity extends AppCompatActivity {

    ArrayAdapter<String> adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_archive);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final String data=getIntent().getStringExtra("ARCHIVE_SEARCH_RESULT");

        ArrayList<String> SearchResults=new ArrayList<>();
        ArrayList<String> tagOfResults=new ArrayList<>();

        String temp="";

        for(int i=0; i<data.length(); i++)
        {
            if(data.charAt(i)=='$')
            {
                SearchResults.add(temp);
                temp="";
            }
            else temp+=data.charAt(i);
        }

        SearchResults.add(temp);

        for(String now: SearchResults)
        {
            StringTokenizer st=new StringTokenizer(now,"_");
            int cnt=0;

            while(st.hasMoreTokens())
            {
                cnt++;
                String val=st.nextToken();
                if(cnt==2)
                {
                    tagOfResults.add(val);
                    break;
                }
            }
        }

        listView=(ListView)findViewById(R.id.listResults);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,tagOfResults);
        listView.setAdapter(adapter);

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
