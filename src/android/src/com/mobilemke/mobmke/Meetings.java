package com.mobilemke.mobmke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Meetings extends Activity {

	ListView meetingsList;
	ArrayList<Meeting> meetingsResults;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meetings);

        meetingsList = (ListView)this.findViewById(R.id.meetingsList);
        
        MeetingRetriever retriever = new MeetingRetriever(getApplicationContext(), meetingsList);
        retriever.execute();
        
        meetingsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parentView, View view, int position,
					long id) {
				int itemId = (Integer) view.getTag();
			
				setDetail(position);
			}
		});
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_meetings, menu);
        return true;
    }
    
    private void setDetail(int position) {
    	Intent intent = new Intent(this, MeetingDetail.class);
    	Meeting meeting = this.meetingsResults.get(position);
    	Gson gson = new Gson();
    	intent.putExtra("object", gson.toJson(meeting));
    	startActivity(intent);
    }
    
    public class MeetingRetriever extends AsyncTask<Object, Void, ArrayList<Meeting>> {
    	
    	private ListView view;
    	private Context context;
    	private ArrayList<Meeting> meetings;
    	
    	public MeetingRetriever(Context context, ListView view)
    	{
    		this.context = context;
    		this.view = view;
    	}
    	@Override
    	protected ArrayList<Meeting> doInBackground(Object... params) {
    		
    		// Old Version just for example
    		
    		HttpClient client = new DefaultHttpClient();
    		HttpGet request = new HttpGet("http://cryptic-hamlet-3757.herokuapp.com/meetings.json");
    		try {
				HttpResponse response = client.execute(request);
				String html = "";
				InputStream in = response.getEntity().getContent();
				BufferedReader reader = new BufferedReader(new InputStreamReader(in));
				StringBuilder str = new StringBuilder();
				String line = null;
				while((line = reader.readLine()) != null) {
					str.append(line);
				}
				in.close();
				html = str.toString();
				Log.v("Testing", html);
				
			} catch (ClientProtocolException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		
    		
    		
    		// End Testing
    		
    		// New version
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
    		
    		meetings = new ArrayList<Meeting>();
    		
    		for(int i = 0; i < jsonArray.length(); i++) {
    			try {
    				
    				JSONObject jsonObject = jsonArray.getJSONObject(i);
    				Meeting meeting = new Meeting(jsonObject);
    				
    			
    				meetings.add(meeting);
    			} catch (JSONException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    			
    		}
    		
    		
    		return meetings;
    	}
    	
    	@Override
    	protected void onPostExecute(ArrayList<Meeting> result)
    	{
    		MeetingArrayAdapter adapter = new MeetingArrayAdapter(this.context, 1, result);
    		this.view.setAdapter(adapter);
    		meetingsResults = result;
    		adapter.notifyDataSetChanged();
    		Log.v("Test", "results stop point");
    	}
    }
}
