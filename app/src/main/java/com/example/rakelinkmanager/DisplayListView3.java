package com.example.rakelinkmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplayListView3 extends AppCompatActivity {

    String JSON_STRING;
    JSONObject jsonObject;
    JSONArray jsonArray;
    ContactAdapter1 contactAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list_view3);
        contactAdapter=new ContactAdapter1(this, R.layout.row_layout1);
        listView=(ListView) findViewById(R.id.listview1);
        listView.setAdapter(contactAdapter);

        JSON_STRING=getIntent().getExtras().getString("json_data");
        String rakeno,trainname,lieoverduration,trainno;

        try {
            jsonObject=new JSONObject(JSON_STRING);
            int count=0;
            jsonArray=jsonObject.getJSONArray("server_response");
            while(count<jsonArray.length())
            {
                JSONObject JO=jsonArray.getJSONObject(count);
                rakeno=JO.getString("Rake no");
                trainname=JO.getString("trainname");
                lieoverduration=JO.getString("Liover duration");
                trainno=JO.getString("trainno");
                Contacts1 contacts=new Contacts1(rakeno,trainname,lieoverduration,trainno);
                contactAdapter.add(contacts);
                count++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}