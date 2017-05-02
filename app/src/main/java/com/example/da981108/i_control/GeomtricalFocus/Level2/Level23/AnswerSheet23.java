package com.example.da981108.i_control.GeomtricalFocus.Level2.Level23;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.da981108.i_control.R;

public class AnswerSheet23 extends AppCompatActivity {

    private int varx = 0;
    private int donex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_sheet23);

        final ImageButton Ace= (ImageButton) findViewById(R.id.ace_button23);
        Ace.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                varx += 48;
                donex += 1;
                Ace.setVisibility(View.INVISIBLE);
            }
        });

        final ImageButton Arrow= (ImageButton) findViewById(R.id.heartleaf_button23);
        Arrow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                varx *=6;
                donex += 1;
                Arrow.setVisibility(View.INVISIBLE);
            }
        });

        final ImageButton Grass= (ImageButton) findViewById(R.id.lamp_button23);
        Grass.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Grass.setVisibility(View.INVISIBLE);
                varx -= 143;
                donex += 1;


            }
        });

        final ImageButton Heartleaf= (ImageButton) findViewById(R.id.grass_button23);
        Heartleaf.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Heartleaf.setVisibility(View.INVISIBLE);
                varx /= 5;
                donex += 1;
            }
        });

        final Button Check = (Button) findViewById(R.id.check23);
        Check.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (donex != 4){
                    Toast.makeText(getApplicationContext(), "Please select all Figures!",
                            Toast.LENGTH_LONG).show();
                }
                if (donex == 4 && varx == 29) {
                    Toast.makeText(getApplicationContext(), "Success",
                            Toast.LENGTH_SHORT).show();
                }
                if(donex == 4 && varx != 29){
                    Toast.makeText(getApplicationContext(), "Fail",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        final Button Refresh = (Button) findViewById(R.id.refresh23);
        Refresh.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent i = new Intent(AnswerSheet23.this,AnswerSheet23.class);
                //starts new activity
                startActivity(i);
                finish();
            }
        });
    }
}
