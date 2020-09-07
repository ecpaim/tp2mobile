package com.example.ex12;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayMessage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        // sets new page
        setContentView(R.layout.message_display);

        // get intent
        Intent intent = getIntent();
        String message = intent.getStringExtra("theMessage");

        // get id of textview
        TextView msg = findViewById(R.id.msgTextView);

        msg.setText(message);
    }
}
