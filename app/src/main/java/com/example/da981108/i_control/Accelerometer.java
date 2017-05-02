package com.example.da981108.i_control;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.TextView;



public class Accelerometer extends AppCompatActivity implements SensorEventListener{




    private SensorManager senSensorManager;
    private Sensor senAccelerometer;
    private Sensor mStepCounterSensor;
    private long lastUpdate = 0;
    private float last_x, last_y, last_z;
    private static final int SHAKE_THRESHOLD = 10000;

    boolean startValue = false;
    float startX;
    float startY;
    float startZ;
    private int startStep;
    private boolean hasStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);
        senSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        senAccelerometer = senSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        senSensorManager.registerListener(this, senAccelerometer , SensorManager.SENSOR_DELAY_NORMAL);
        mStepCounterSensor = senSensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        //textSteps = (TextView)findViewById(R.id.steps);
        hasStarted = false;


    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor mySensor = sensorEvent.sensor;
        Sensor sensor = sensorEvent.sensor;

        if (sensor.getType() == Sensor.TYPE_STEP_COUNTER) {
            float[] values = sensorEvent.values;
            int value = -1;

            if (values.length > 0) {
                value = (int)sensorEvent.values[0];
            }

            if(!hasStarted && value != -1){
                startStep = (int)sensorEvent.values[0];
                hasStarted = true;
            }


            //textSteps.setText("Step Counter Detected : " + value);

            if (Math.abs(value - startStep)>15){
                Intent i = new Intent(this,YouMadeIt.class);
                startActivity(i);
                finish();
            }

        }


        if (mySensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            // getting the values n putting them in  float variables
            float x = Math.abs(sensorEvent.values[0])*100;
            float y = Math.abs(sensorEvent.values[1])*100;
            float z = Math.abs(sensorEvent.values[2])*100;



            if (!startValue){
                startX = x;
                startY = y;
                startZ = z;
                startValue = true;
            }
            long curTime = System.currentTimeMillis();


            //var 100 millisekund körs koden i if-satsen
            if ((curTime - lastUpdate) > 100) {
                long diffTime = (curTime - lastUpdate);
                lastUpdate = curTime;

                float speed = Math.abs(x + y + z - last_x - last_y - last_z)/ diffTime * 10000;

                if (speed > SHAKE_THRESHOLD && (Math.abs(startX-x)> 500 || Math.abs(startZ - z)>500)) {
                    Intent i = new Intent(this,Youdrunk.class);
                    startActivity(i);
                    finish();

                }

                last_x = x;
                last_y = y;
                last_z = z;
            }
        }
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    protected void onPause() {
        super.onPause();
        senSensorManager.unregisterListener(this,senAccelerometer);
        senSensorManager.unregisterListener(this, mStepCounterSensor);
    }

    protected void onResume() {
        super.onResume();
        senSensorManager.registerListener(this, senAccelerometer, SensorManager.SENSOR_DELAY_FASTEST);
        senSensorManager.registerListener(this, mStepCounterSensor, SensorManager.SENSOR_DELAY_FASTEST);
    }
}
