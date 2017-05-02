package com.example.da981108.i_control;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class YouMadeIt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_made_it);
    }
    public void goToMain (View view){
        Intent r = new Intent(this,MainActivity.class);
        startActivity(r);
        finish();
    }
}
