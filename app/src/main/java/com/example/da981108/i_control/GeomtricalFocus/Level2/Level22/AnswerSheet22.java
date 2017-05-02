package com.example.da981108.i_control.GeomtricalFocus.Level2.Level22;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.da981108.i_control.R;

public class AnswerSheet22 extends AppCompatActivity {

    private int varx = 0;
    private int donex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_sheet22);

        final ImageButton Ace= (ImageButton) findViewById(R.id.grass_button22);
        Ace.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                varx += 45;
                donex += 1;
                Ace.setVisibility(View.INVISIBLE);
            }
        });

        final ImageButton Arrow= (ImageButton) findViewById(R.id.ace_button);
        Arrow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                varx *=4;
                donex += 1;
                Arrow.setVisibility(View.INVISIBLE);
            }
        });

        final ImageButton Grass= (ImageButton) findViewById(R.id.arrows_button22);
        Grass.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Grass.setVisibility(View.INVISIBLE);
                varx -= 30;
                donex += 1;


            }
        });

        final ImageButton Heartleaf= (ImageButton) findViewById(R.id.lightning_button);
        Heartleaf.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Heartleaf.setVisibility(View.INVISIBLE);
                varx /= 15;
                donex += 1;
            }
        });

        final Button Check = (Button) findViewById(R.id.check22);
        Check.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (donex != 4){
                    Toast.makeText(getApplicationContext(), "Please select all Figures!",
                            Toast.LENGTH_LONG).show();
                }
                if (donex == 4 && varx == 10) {
                    Toast.makeText(getApplicationContext(), "Success",
                            Toast.LENGTH_SHORT).show();
                }
                if(donex == 4 && varx != 10){
                    Toast.makeText(getApplicationContext(), "Fail",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        final Button Refresh = (Button) findViewById(R.id.refresh22);
        Refresh.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent i = new Intent(AnswerSheet22.this,AnswerSheet22.class);
                //starts new activity
                startActivity(i);
                finish();
            }
        });
    }
}
