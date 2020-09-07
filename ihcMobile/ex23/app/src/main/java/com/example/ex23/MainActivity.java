package com.example.ex23;

import android.Manifest;
import android.location.Location;
import android.location.LocationListener;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView l1;
    TextView l2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.locationBtn);
        l1 = findViewById(R.id.l1);
        l2 = findViewById(R.id.l2);
        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 123);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                GPSTracker g = new GPSTracker(getApplicationContext());
                Location l = g.getLocation();
                if(l != null){
                    double lat = l.getLatitude();
                    double longi = l.getLongitude();
                    l1.setText(Double.toString(lat));
                    l2.setText(Double.toString(longi));
                }
            }
        });
    }
}
