package com.example.da981108.i_control.GeomtricalFocus.Level2.Level21;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.da981108.i_control.R;

public class NextReplay21 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_replay21);

        Button Replay = (Button) findViewById(R.id.replay21);
        Replay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click. go to the Level1 activity
                Intent i = new Intent(NextReplay21.this,Level21.class);
                //starts the activity
                startActivity(i);
                finish();
            }
        });

        Button Next = (Button) findViewById(R.id.next21);
        Next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click. go to the AnswerSheet activity
                Intent i = new Intent(NextReplay21.this,AnswerSheet21.class);
                //starts the activity
                startActivity(i);
                finish();
            }
        });
    }
}
