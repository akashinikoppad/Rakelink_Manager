package com.example.rakelinkmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class LieOverHours extends AppCompatActivity {
    EditText station_code, hours;
    String stationcode, liehours;
    String json_string;
    String JSON_STRING;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lie_over_hours);
        station_code=(EditText) findViewById(R.id.statcode);
        hours=(EditText) findViewById(R.id.hours);
    }
    public void displayhours(View view)
    {
        stationcode=station_code.getText().toString();
        liehours=hours.getText().toString();
        String method="displaythehours";
        BackgroundTask2 backgroundTask2=new BackgroundTask2(this);
        backgroundTask2.execute(method,stationcode,liehours);
    }

    public void parsejson(View view)
    {
        Intent intent=new Intent(this,DisplayListView4.class);
        intent.putExtra("json_data", JSON_STRING);
        startActivity(intent);
    }

    public class BackgroundTask2 extends AsyncTask<String, Void, String>
    {
        Context ctx;
        BackgroundTask2(Context ctx)
        {
            this.ctx=ctx;
        }
        @Override
        protected String doInBackground(String... params) {
            String json_url="https://southrailways.000webhostapp.com/3rdobjective.php";
            String method=params[0];
            if(method.equals("displaythehours"))
            {
                String stationcode=params[1];
                String liehours=params[2];
            }
            try {
                URL url=new URL(json_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream os=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
                String data= URLEncoder.encode("code","UTF-8")+"="+URLEncoder.encode(stationcode,"UTF-8")+"&"+
                        URLEncoder.encode("time","UTF-8")+"="+URLEncoder.encode(liehours,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                StringBuilder stringBuilder=new StringBuilder();

                while((json_string=bufferedReader.readLine())!=null)
                {
                    stringBuilder.append(json_string+"\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        public BackgroundTask2() {
            super();
        }

        @Override
        protected void onPostExecute(String result) {
            TextView textView=(TextView) findViewById(R.id.textview1);
            textView.setText(result);
            JSON_STRING=result;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }
}