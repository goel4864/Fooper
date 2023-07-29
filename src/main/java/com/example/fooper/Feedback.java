package com.example.fooper;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Feedback extends AppCompatActivity {

    TextView tvFeedback;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        tvFeedback = findViewById(R.id.tvFeedback);
        btnSubmit = findViewById(R.id.btnSubmit);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Feedback");
        actionBar.setDisplayShowHomeEnabled(true);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
