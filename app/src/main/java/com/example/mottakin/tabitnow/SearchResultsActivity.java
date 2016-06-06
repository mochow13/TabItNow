package com.example.mottakin.tabitnow;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class SearchResultsActivity extends AppCompatActivity {

    ArrayAdapter<String> adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_archive);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final String data=getIntent().getStringExtra("SEARCH_RESULT");

        final ArrayList<String> SearchResults=new ArrayList<>();
        final ArrayList<String> tagOfResults=new ArrayList<>();

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

//        SearchResults.add(temp);

        for(String now: SearchResults)
        {
            StringTokenizer st=new StringTokenizer(now,"#");
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

        if(tagOfResults.size()==0) tagOfResults.add("No match found! :(");

        listView=(ListView)findViewById(R.id.listResults);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,tagOfResults);
        listView.setAdapter(adapter);

        if(SearchResults.size()>0) {
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(SearchResultsActivity.this, SearchJoin.class);
                    String now = SearchResults.get(position);
                    intent.putExtra("TOURNAMENT_DETAILS", now);
                    startActivity(intent);
                }
            });
        }

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
