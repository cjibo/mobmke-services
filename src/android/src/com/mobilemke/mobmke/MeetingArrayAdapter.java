package com.mobilemke.mobmke;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MeetingArrayAdapter extends ArrayAdapter<Meeting> {

	int resource;
	ArrayList<Meeting> items;
	Context context;
	
	public MeetingArrayAdapter(Context context, int resource, ArrayList<Meeting> items) {
		super(context, resource, items);
		this.resource = resource;
		this.items = items;
		this.context = context;
	}

	@Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
		
		View v = convertView;
		Meeting meeting = getItem(position);
		
		if (convertView == null)
		{
			String inflater = Context.LAYOUT_INFLATER_SERVICE;
			LayoutInflater vi;
			vi = (LayoutInflater)getContext().getSystemService(inflater);
			v = vi.inflate(R.layout.meeting_item, null);
		} else {
			v = (LinearLayout)convertView;
		}
		
		TextView startText = (TextView)v.findViewById(R.id.txtStart);
		TextView endText = (TextView)v.findViewById(R.id.txtEnd);
		TextView titleText = (TextView)v.findViewById(R.id.txtTitle);
		
		startText.setText(meeting.getStart().toString());
		endText.setText(meeting.getEnd().toString());
		v.setTag(meeting.getId());	
		titleText.setText(meeting.getTitle());
		
		return v;
		
    }
}
