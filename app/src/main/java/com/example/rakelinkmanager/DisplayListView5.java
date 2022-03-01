package com.example.rakelinkmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplayListView5 extends AppCompatActivity {

    String JSON_STRING;
    JSONObject jsonObject;
    JSONArray jsonArray;
    ContactAdapter3 contactAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list_view5);
        contactAdapter=new ContactAdapter3(this, R.layout.row_layout3);
        listView=(ListView) findViewById(R.id.listview3);
        listView.setAdapter(contactAdapter);

        JSON_STRING=getIntent().getExtras().getString("json_data");
        String arrtime, deptime, rakeno, trainname, trainno;

        try {
            jsonObject=new JSONObject(JSON_STRING);
            int count=0;
            jsonArray=jsonObject.getJSONArray("server_response");
            while(count<jsonArray.length())
            {
                JSONObject JO=jsonArray.getJSONObject(count);
                //rakeno=JO.getString("Rake no");
                arrtime=JO.getString("Arrtime");
                deptime=JO.getString("Depttime");
                rakeno=JO.getString("rakeno");
                trainname=JO.getString("trainname");
                trainno=JO.getString("trainno");

                Contacts3 contacts=new Contacts3(arrtime, deptime, rakeno, trainname, trainno);
                contactAdapter.add(contacts);
                count++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}