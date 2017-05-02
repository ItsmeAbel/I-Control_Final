package com.example.da981108.i_control.GeomtricalFocus.Level2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.da981108.i_control.R;

public class AnswerSheet2 extends AppCompatActivity {

    int varx = 0;
    int donex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_sheet2);

        final ImageButton Ace= (ImageButton) findViewById(R.id.grass_button);
        Ace.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                varx += 24;
                donex += 1;
                Ace.setVisibility(View.INVISIBLE);
            }
        });

        final ImageButton Arrow= (ImageButton) findViewById(R.id.heartleaf_button);
        Arrow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                varx *=3;
                donex += 1;
                Arrow.setVisibility(View.INVISIBLE);
            }
        });

        final ImageButton Grass= (ImageButton) findViewById(R.id.arrows_button);
        Grass.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Grass.setVisibility(View.INVISIBLE);
                varx += 90;
                donex += 1;


            }
        });

        final ImageButton Heartleaf= (ImageButton) findViewById(R.id.lamp_button);
        Heartleaf.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Heartleaf.setVisibility(View.INVISIBLE);
                donex += 1;
                varx /= 9;


            }
        });

        final Button Check = (Button) findViewById(R.id.check2);
        Check.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (donex != 4){
                    Toast.makeText(getApplicationContext(), "Please select all Figures!",
                            Toast.LENGTH_LONG).show();
                }
                if (donex == 4 && varx == 18) {
                    Toast.makeText(getApplicationContext(), "Success",
                            Toast.LENGTH_SHORT).show();
                }
                if(donex == 4 && varx != 18){
                    Toast.makeText(getApplicationContext(), "Fail",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        final Button Refresh = (Button) findViewById(R.id.refresh);
        Refresh.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent i = new Intent(AnswerSheet2.this,AnswerSheet2.class);
                //starts new activity
                startActivity(i);
                finish();
            }
        });
    }

   /* @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){
            varx -= 19;
            donex += 1;
        }
        else {
            varx += 19;
            donex -= 1;
        }
    }*/



    /*@Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }*/
}
