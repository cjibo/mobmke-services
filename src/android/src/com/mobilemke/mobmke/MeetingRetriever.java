package com.mobilemke.mobmke;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;

public class MeetingRetriever extends AsyncTask<Object, Void, List<Meeting>> {
	
	private ListView view;
	
	public MeetingRetriever(ListView view, MeetingArrayAdapter adapter)
	{
		this.view = view;
	}
	@Override
	protected List<Meeting> doInBackground(Object... params) {
		JSONArray jsonArray = null;
		URL url;
		HttpURLConnection urlConnection = null;
		try {
			url = new URL("http://cryptic-hamlet-3757.herokuapp.com/meetings.json");
			urlConnection = (HttpURLConnection) url.openConnection();
		        
			BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		        
			StringBuilder sb = new StringBuilder();
			String line;
			while((line = br.readLine()) != null) {
				sb.append(line+"\n");
			}
			br.close();
		     
			jsonArray = new JSONArray(sb.toString());
		} catch (Exception ex) {
			Log.v("Exception", ex.getMessage());
		}
		urlConnection.disconnect();
		
		List<Meeting> list = new ArrayList<Meeting>();
		
		for(int i = 0; i < jsonArray.length(); i++) {
			Meeting meeting = new Meeting();
			try {
				SimpleDateFormat df = new SimpleDateFormat();
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				meeting.setTitle(jsonObject.getString("title"));
				
				meeting.setStart(df.parse(jsonObject.getString("start_time")));
				meeting.setEnd(df.parse(jsonObject.getString("end_time")));
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list.add(meeting);
		}
		
		
		return list;
	}

	@Override
	protected void onPostExecute(List<Meeting> result)
	{
		
		Log.v("Test", "results stop point");
	}
}
