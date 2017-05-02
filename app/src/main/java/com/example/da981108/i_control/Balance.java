package com.example.da981108.i_control;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Balance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance);
    }
    public void goToAccelerometer (View view){
        Intent i = new Intent(this,Accelerometer.class);
        startActivity(i);
        finish();
    }

}
