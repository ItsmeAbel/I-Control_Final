package com.example.da981108.i_control.GeomtricalFocus.Level3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.da981108.i_control.R;

public class AnswerSheet3 extends AppCompatActivity {

    private int varx = 0;
    private int donex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_sheet3);

        final ImageButton Hexagon= (ImageButton) findViewById(R.id.heartleaf_button3);
        Hexagon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                varx += 41;
                donex += 1;
                Hexagon.setVisibility(View.INVISIBLE);
            }
        });

        final ImageButton Square= (ImageButton) findViewById(R.id.lamp_button3);
        Square.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                varx *= 17;
                donex += 1;
                Square.setVisibility(View.INVISIBLE);
            }
        });

        final ImageButton Triangle= (ImageButton) findViewById(R.id.grass_button3);
        Triangle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                varx +=70;
                donex += 1;
                Triangle.setVisibility(View.INVISIBLE);
            }
        });

        final ImageButton Circle = (ImageButton) findViewById(R.id.ace_button3);
        Circle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                varx -= 12;
                donex += 1;
                Circle.setVisibility(View.INVISIBLE);


            }
        });

        final ImageButton Cube= (ImageButton) findViewById(R.id.arrows_button3);
        Cube.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                varx /= 13;
                donex += 1;
                //if(varx==0){
                //  varx +=1;
                //}else{
                //    fel = true;
                //    varx +=1;
                //}
                Cube.setVisibility(View.INVISIBLE);

            }
        });

        final ImageButton Diamond= (ImageButton) findViewById(R.id.lightning_button3);
        Diamond.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                varx += 28;
                donex += 1;
                Diamond.setVisibility(View.INVISIBLE);
            }
        });



        final Button Check = (Button) findViewById(R.id.check3);
        Check.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (donex != 6){
                    Toast.makeText(getApplicationContext(), "Please select all Figures!",
                            Toast.LENGTH_LONG).show();
                }
                if (donex == 6 && varx == 86) {
                    Toast.makeText(getApplicationContext(), "Success",
                            Toast.LENGTH_LONG).show();
                }
                if(donex == 6 && varx != 86){
                    Toast.makeText(getApplicationContext(), "Fail",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        final Button Refresh = (Button) findViewById(R.id.refresh3);
        Refresh.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent i = new Intent(AnswerSheet3.this,AnswerSheet3.class);
                //starts new activity
                startActivity(i);
                finish();
            }
        });


    }
}
