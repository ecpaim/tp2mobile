package com.example.ex21;

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
    private Sensor light;
    TextView lightValue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lightValue = findViewById(R.id.lightValue);
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        light = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        if(light != null){
            sensorManager.registerListener(MainActivity.this, light, SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            lightValue.setText("Light sensor not supported");
        }


    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    public void onSensorChanged(SensorEvent event) {

        lightValue.setText(Float.toString(event.values[0]));

        if(event.values[0] > 21 ){
            Toast.makeText(this,"Too bright!", Toast.LENGTH_LONG).show();
        }
        if(event.values[0] < 3 ){
            Toast.makeText(this,"Too dark!", Toast.LENGTH_LONG).show();
        }
    }
}
