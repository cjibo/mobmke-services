package com.mobilemke.mobmke;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Meetings extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meetings);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_meetings, menu);
        return true;
    }
}
