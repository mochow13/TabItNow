package com.example.mottakin.tabitnow;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

/**
 * Created by mottakin on 4/30/16.
 */
public class pop extends Activity {

    protected  void onCreate(Bundle SavedInstanceState)
    {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.tournamentoption);

        DisplayMetrics dm= new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int w= dm.widthPixels;
        int h= dm.heightPixels;

        getWindow().setLayout((int)(w*.8),(int)(h*.8));


    }
}
