package com.mobilemke.mobmke;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

public class Meetings extends Activity {

	ListView meetingsList;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meetings);

        meetingsList = (ListView)this.findViewById(R.id.meetingsList);
        
        MeetingRetriever retriever = new MeetingRetriever(getApplicationContext(), meetingsList);
        retriever.execute();
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_meetings, menu);
        return true;
    }
}
