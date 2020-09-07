package com.example.ex13;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_display);

        Intent intent = getIntent();
        TextView msg = findViewById(R.id.woah);

        msg.setText("wOAH!");

    }
}
