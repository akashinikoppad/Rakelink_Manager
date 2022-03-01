package com.example.rakelinkmanager;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void rakenosearch(View view)
    {
        Intent intent=new Intent(this, DisplayListView2.class);
        startActivity(intent);
    }
    public void stationlieover(View view)
    {
        Intent intent=new Intent(this, StationLieOver.class);
        startActivity(intent);
    }
    public void lieover(View view)
    {
        Intent intent=new Intent(this, LieOver.class);
        startActivity(intent);
    }
}