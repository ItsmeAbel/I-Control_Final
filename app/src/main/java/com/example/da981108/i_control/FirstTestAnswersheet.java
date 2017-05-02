package com.example.da981108.i_control;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.da981108.i_control.GeomtricalFocus.Level1.Randomlevel1;
import com.example.da981108.i_control.GeomtricalFocus.Level2.Randomlevel2;
import com.example.da981108.i_control.GeomtricalFocus.Level3.Randomlevel3;

public class FirstTestAnswersheet extends AppCompatActivity {

    private int varx = 0;
    private int donex = 0;
    private int lvl = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_test_answer_sheet);

        final ImageButton Ace= (ImageButton) findViewById(R.id.ace2);
        Ace.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                varx += 17;
                donex += 1;
                Ace.setVisibility(View.INVISIBLE);
            }
        });

        final ImageButton Arrow= (ImageButton) findViewById(R.id.arrow2);
        Arrow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                varx *=3;
                donex += 1;
                Arrow.setVisibility(View.INVISIBLE);
            }
        });

        final ImageButton Grass= (ImageButton) findViewById(R.id.grass2);
        Grass.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Grass.setVisibility(View.INVISIBLE);
                donex += 1;
                if (varx == 51){
                    varx -= 13;
                    lvl = 1;
                }
            }
        });

        final ImageButton Heartleaf= (ImageButton) findViewById(R.id.heartleaf2);
        Heartleaf.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Heartleaf.setVisibility(View.INVISIBLE);
                donex += 1;
                if (varx == 38){
                    varx /= 2;
                    lvl += 3;
                }
            }
        });

        final ImageButton Lamp= (ImageButton) findViewById(R.id.lamp2);
        Lamp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                varx += 21;
                donex += 1;
                Lamp.setVisibility(View.INVISIBLE);
            }
        });

        final ImageButton Lightning= (ImageButton) findViewById(R.id.lightning2);
        Lightning.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Lightning.setVisibility(View.INVISIBLE);
                donex += 1;
                if (varx == 40){
                    varx *=4;
                    lvl *=3;
                }
            }
        });

        final Button Check = (Button) findViewById(R.id.FirstTestCheck);
        Check.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (donex != 6){
                    Toast.makeText(getApplicationContext(), "Please select all Figures!",
                            Toast.LENGTH_LONG).show();
                }
                if (donex == 6 && lvl == 1){
                    Toast.makeText(getApplicationContext(), "Random level 1, activated!",
                            Toast.LENGTH_LONG).show();
                    Intent i = new Intent(FirstTestAnswersheet.this,Randomlevel1.class);
                    //starts new activity
                    startActivity(i);
                    finish();

                    SharedPreferences sharedPreferences = getSharedPreferences("SavedData", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("SavedLevel", lvl);
                    editor.commit();
                    Toast.makeText(getApplicationContext(), "Activation Saved",
                            Toast.LENGTH_LONG).show();

                }
                if(donex == 6 && lvl == 4){
                    Toast.makeText(getApplicationContext(), "Random level 2, activated!",
                            Toast.LENGTH_LONG).show();
                    Intent i = new Intent(FirstTestAnswersheet.this,Randomlevel2.class);
                    //starts new activity
                    startActivity(i);
                    finish();

                    SharedPreferences sharedPreferences = getSharedPreferences("SavedData", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("SavedLevel", lvl);
                    editor.commit();
                    Toast.makeText(getApplicationContext(), "Activation Saved",
                            Toast.LENGTH_LONG).show();
                }
                if(donex == 6 && lvl == 12){
                    Toast.makeText(getApplicationContext(), "Random level 3, activated!",
                            Toast.LENGTH_LONG).show();
                    Intent i = new Intent(FirstTestAnswersheet.this,Randomlevel3.class);
                    //starts new activity
                    startActivity(i);
                    finish();

                    SharedPreferences sharedPreferences = getSharedPreferences("SavedData", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("SavedLevel", lvl);
                    editor.commit();
                    Toast.makeText(getApplicationContext(), "Activation Saved",
                            Toast.LENGTH_LONG).show();
                }
                if(donex == 6 && lvl != 4 && lvl != 1 && lvl !=12){
                    Toast.makeText(getApplicationContext(), "Oops!You got all wrong.",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        final Button Refresh = (Button) findViewById(R.id.refresh_first_test);
        Refresh.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent i = new Intent(FirstTestAnswersheet.this,FirstTestAnswersheet.class);
                //starts new activity
                startActivity(i);
                finish();
            }
        });
    }
}
