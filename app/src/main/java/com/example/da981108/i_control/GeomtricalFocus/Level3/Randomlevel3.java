package com.example.da981108.i_control.GeomtricalFocus.Level3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.da981108.i_control.GeomtricalFocus.Level3.Level31.Level31;
import com.example.da981108.i_control.GeomtricalFocus.Level3.Level32.Level32;
import com.example.da981108.i_control.R;
import com.example.da981108.i_control.RandomNumberGeneretor;

public class Randomlevel3 extends AppCompatActivity {

    private int y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_randomlevel3);

        y = RandomNumberGeneretor.getRandomIntBetween(0,3);
        if (y == 0 ) {
            Toast.makeText(getApplicationContext(), "Level 3",
                    Toast.LENGTH_LONG).show();
            Intent i = new Intent(Randomlevel3.this,Level3.class);
            //starts new activity
            startActivity(i);
            finish();
        }
        if(y == 1){
            Toast.makeText(getApplicationContext(), "Level 31",
                    Toast.LENGTH_LONG).show();
            Intent i = new Intent(Randomlevel3.this,Level31.class);
            //starts new activity
            startActivity(i);
            finish();
        }
        if(y == 2){
            Toast.makeText(getApplicationContext(), "Level 32",
                    Toast.LENGTH_LONG).show();
            Intent i = new Intent(Randomlevel3.this,Level32.class);
            //starts new activity
            startActivity(i);
            finish();
        }
    }
}
