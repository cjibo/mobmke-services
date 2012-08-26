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
	
	public MeetingArrayAdapter(Context context, int resource, ArrayList<Meeting> items) {
		super(context, resource, items);
		this.resource = resource;
		this.items = items;
	}

	@Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
		LinearLayout itemView;
		
		Meeting meeting = getItem(position);
		
		if (convertView == null)
		{
			itemView = new LinearLayout(getContext());
			String inflater = Context.LAYOUT_INFLATER_SERVICE;
			LayoutInflater vi;
			vi = (LayoutInflater)getContext().getSystemService(inflater);
			vi.inflate(resource, itemView, true);
		} else {
			itemView = (LinearLayout)convertView;
		}
		
		TextView startText = (TextView)itemView.findViewById(R.id.txtStart);
		TextView endText = (TextView)itemView.findViewById(R.id.txtEnd);
		TextView titleText = (TextView)itemView.findViewById(R.id.txtTitle);
		
		startText.setText(meeting.getStart().toString());
		endText.setText(meeting.getEnd().toString());
		titleText.setText(meeting.getTitle());
		
		return itemView;
		
    }
}
