package com.mobilemke.mobmke;

import com.google.gson.Gson;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

import com.mobilemke.mobmke.Meeting;

public class MeetingDetail extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_detail);
        Gson gson = new Gson();
        Meeting meeting = gson.fromJson(this.getIntent().getStringExtra("object"), Meeting.class);
        
        TextView title = (TextView) this.findViewById(R.id.itemTitle);
        TextView start = (TextView) this.findViewById(R.id.itemStart);
        TextView end = (TextView) this.findViewById(R.id.itemEnd);
        TextView location = (TextView) this.findViewById(R.id.itemLocation);
        TextView speaker = (TextView) this.findViewById(R.id.itemSpeaker);
        
        title.setText(meeting.getTitle());
        start.setText(meeting.getStart().toString());
        end.setText(meeting.getEnd().toString());
        location.setText(meeting.getLocation());
        speaker.setText(meeting.getSpeaker());
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_meeting_detail, menu);
        
        return true;
    }
}
