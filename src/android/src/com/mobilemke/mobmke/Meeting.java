package com.mobilemke.mobmke;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

public class Meeting {
	private String title;
	private Date start;
	private Date end;
	private String location;
	private String speaker;
	private int id;
	
	public Meeting() {
	
	}
	
	public Meeting(int id) {
		this.id = id;
	}
	public Meeting(JSONObject json) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		
		try {
			this.title = json.getString("title");
			this.start = df.parse(json.getString("start_time"));
			this.end  = df.parse(json.getString("end_time"));
			this.location = json.getString("location");
			this.speaker = json.getString("speaker");
			this.id = json.getInt("id");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public int getId() {
		return id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSpeaker() {
		return speaker;
	}
	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
}
