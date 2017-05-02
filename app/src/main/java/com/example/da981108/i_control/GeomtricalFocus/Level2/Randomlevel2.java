package com.example.da981108.i_control.GeomtricalFocus.Level2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.da981108.i_control.GeomtricalFocus.Level2.Level21.Level21;
import com.example.da981108.i_control.GeomtricalFocus.Level2.Level22.Level22;
import com.example.da981108.i_control.GeomtricalFocus.Level2.Level23.Level23;
import com.example.da981108.i_control.R;
import com.example.da981108.i_control.RandomNumberGeneretor;

public class Randomlevel2 extends AppCompatActivity {

    private int y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_randomlevel2);

                y = RandomNumberGeneretor.getRandomIntBetween(0,4);
                if (y == 0 ) {
                    Toast.makeText(getApplicationContext(), "Level 2",
                            Toast.LENGTH_LONG).show();
                    Intent i = new Intent(Randomlevel2.this,Level2.class);
                    //starts new activity
                    startActivity(i);
                    finish();
                }
                if(y == 1){
                    Toast.makeText(getApplicationContext(), "Level 21",
                            Toast.LENGTH_LONG).show();
                    Intent i = new Intent(Randomlevel2.this,Level21.class);
                    //starts new activity
                    startActivity(i);
                    finish();
                }
                if(y == 2){
                    Toast.makeText(getApplicationContext(), "Level 22",
                            Toast.LENGTH_LONG).show();
                    Intent i = new Intent(Randomlevel2.this,Level22.class);
                    //starts new activity
                    startActivity(i);
                    finish();
                }
                if(y == 3){
                    Toast.makeText(getApplicationContext(), "Level 23",
                            Toast.LENGTH_LONG).show();
                    Intent i = new Intent(Randomlevel2.this,Level23.class);
                    //starts new activity
                    startActivity(i);
                    finish();
                }
    }
}


