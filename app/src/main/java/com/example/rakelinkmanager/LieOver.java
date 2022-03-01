package com.example.rakelinkmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LieOver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lie_over);
    }
    public void lieoverhours(View view)
    {
        Intent intent=new Intent(this, LieOverHours.class);
        startActivity(intent);
    }
    public void lieovertime(View view)
    {
        Intent intent=new Intent(this, LieOverTime.class);
        startActivity(intent);
    }
}