package com.example.ex13;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
    implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;

    TextView xTextView;
    TextView yTextView;
    TextView zTextView;

    float x = (float)50.3;
    float y = (float)50.3;
    float z = (float)50.3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        setContentView(R.layout.activity_main);

        xTextView = findViewById(R.id.xTextView);
        yTextView = findViewById(R.id.yTextView);
        zTextView = findViewById(R.id.zTextView);

    }

    @Override
    protected void onResume(){
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause(){
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
       float diffX = Math.abs(event.values[0] - x);
       float diffY = Math.abs(event.values[1] - y);
       float diffZ = Math.abs(event.values[2] - z);

       if((diffX > 5 || diffY > 5 || diffZ > 5) && x != (float)50.3) {
           Intent intent = new Intent(MainActivity.this, DisplayMessage.class);
           startActivity(intent);
       }
       x = event.values[0];
       y = event.values[1];
       z = event.values[2];

       xTextView.setText(Float.toString(x));
       yTextView.setText(Float.toString(y));
       zTextView.setText(Float.toString(z));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}
