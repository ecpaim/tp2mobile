package com.example.ex11;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "criou", Toast.LENGTH_LONG).show();

        final Button resultButton = findViewById(R.id.addButton);

        final EditText n1 = findViewById(R.id.number1);
        final EditText n2 = findViewById(R.id.number2);

        final TextView result = findViewById(R.id.result);

        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sum = Integer.parseInt(n1.getText().toString()) + Integer.parseInt(n2.getText().toString());

                result.setText(Integer.toString(sum));
            }
        });


    }

    @Override
    protected void onStop() {
        super.onStop();

        Toast.makeText(this,"app nao esta visivel", Toast.LENGTH_LONG).show();
    }
}
