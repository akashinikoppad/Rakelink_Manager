package com.example.rakelinkmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplayListView4 extends AppCompatActivity {

    String JSON_STRING;
    JSONObject jsonObject;
    JSONArray jsonArray;
    ContactAdapter2 contactAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list_view4);
        contactAdapter=new ContactAdapter2(this, R.layout.row_layout2);
        listView=(ListView) findViewById(R.id.listview2);
        listView.setAdapter(contactAdapter);

        JSON_STRING=getIntent().getExtras().getString("json_data");
        String lieoverduration, rakeno, trainname, trainno;

        try {
            jsonObject=new JSONObject(JSON_STRING);
            int count=0;
            jsonArray=jsonObject.getJSONArray("server_response");
            while(count<jsonArray.length())
            {
                JSONObject JO=jsonArray.getJSONObject(count);
                //rakeno=JO.getString("Rake no");
                lieoverduration=JO.getString("Liover duration");
                rakeno=JO.getString("Rake no");
                trainname=JO.getString("Train name");
                trainno=JO.getString("Train no");

                Contacts2 contacts=new Contacts2(lieoverduration, rakeno, trainname, trainno);
                contactAdapter.add(contacts);
                count++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}