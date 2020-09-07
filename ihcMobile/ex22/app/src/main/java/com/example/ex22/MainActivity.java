package com.example.ex22;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor proximity;
    TextView distance;
    TextView msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        proximity = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        distance = findViewById(R.id.distance);
        msg = findViewById(R.id.message);

        if(proximity != null){
            sensorManager.registerListener(MainActivity.this, proximity, SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            msg.setText("Proximity sensor not supported!");
        }
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    public void onSensorChanged(SensorEvent event) {

        distance.setText(Float.toString(event.values[0]));

        if(event.values[0] < 1 ){
            msg.setText("You are too close!");
        } else {
            msg.setText("Come closer");
        }


    }
}
