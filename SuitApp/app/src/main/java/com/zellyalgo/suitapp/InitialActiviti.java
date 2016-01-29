package com.zellyalgo.suitapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class InitialActiviti extends AppCompatActivity {

    private static String APP_TAG = "SuitApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_activiti);
        getSupportActionBar().hide();
    }

    public void createOutfit (View view){
        Intent intent = new Intent(this, CreateOutfit.class);
        startActivity(intent);
    }

    public void openDesk (View view){
        Intent intent = new Intent(this, CreateOutfit.class);
        startActivity(intent);
    }

}
