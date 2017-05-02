package com.example.da981108.i_control.GeomtricalFocus.Level1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.da981108.i_control.GeomtricalFocus.Level1.Level11.Level11;
import com.example.da981108.i_control.GeomtricalFocus.Level1.Level12.Level12;
import com.example.da981108.i_control.R;
import com.example.da981108.i_control.RandomNumberGeneretor;

public class Randomlevel1 extends AppCompatActivity {

    private int y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_randomlevel1);

        y = RandomNumberGeneretor.getRandomIntBetween(0,3);
        if (y == 0 ) {
            Toast.makeText(getApplicationContext(), "Level 1",
                    Toast.LENGTH_LONG).show();
            Intent i = new Intent(Randomlevel1.this,Level1.class);
            //starts new activity
            startActivity(i);
            finish();
        }
        if(y == 1){
            Toast.makeText(getApplicationContext(), "Level 11",
                    Toast.LENGTH_LONG).show();
            Intent i = new Intent(Randomlevel1.this,Level11.class);
            //starts new activity
            startActivity(i);
            finish();
        }
        if(y == 2){
            Toast.makeText(getApplicationContext(), "Level 12",
                    Toast.LENGTH_LONG).show();
            Intent i = new Intent(Randomlevel1.this,Level12.class);
            //starts new activity
            startActivity(i);
            finish();
        }

    }
}
