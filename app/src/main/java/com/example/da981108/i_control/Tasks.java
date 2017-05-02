package com.example.da981108.i_control;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.da981108.i_control.GeomtricalFocus.Level1.Randomlevel1;
import com.example.da981108.i_control.GeomtricalFocus.Level2.Randomlevel2;
import com.example.da981108.i_control.GeomtricalFocus.Level3.Randomlevel3;

public class Tasks extends AppCompatActivity {

    private int ontask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        ontask = 2;

        SharedPreferences sp = getSharedPreferences("SavedData", Context.MODE_PRIVATE);
        final int myIntValue = sp.getInt("SavedLevel", -1);

        final Button GeomtricalFocus = (Button) findViewById(R.id.geometricalFocus);
        GeomtricalFocus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (myIntValue == 1){
                    Intent i = new Intent(Tasks.this,Randomlevel1.class);
                    //starts new activity
                    startActivity(i);
                    finish();
                }
                if(myIntValue == 4){
                    Intent i = new Intent(Tasks.this,Randomlevel2.class);
                    //starts new activity
                    startActivity(i);
                    finish();
                }
                if (myIntValue == 12){
                    Intent i = new Intent(Tasks.this,Randomlevel3.class);
                    //starts new activity
                    startActivity(i);
                    finish();
                }
                if (myIntValue != 1 && myIntValue != 4 && myIntValue != 12){
                    Toast.makeText(getApplicationContext(), "Please do the PreTest first!",
                            Toast.LENGTH_LONG).show();
                    Intent i = new Intent(Tasks.this,FirstTest.class);
                    //starts new activity
                    startActivity(i);
                    finish();
                }

            }
        });
    }
    public void goToBalance (View v){
        Intent b = new Intent(this,Balance.class);
        startActivity(b);
    }
}
