package com.example.fooper;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Suppport extends AppCompatActivity {

    ImageView ivCall,ivMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suppport);

        ivCall = findViewById(R.id.ivCall);
        ivMail = findViewById(R.id.ivMail);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Support");
        actionBar.setDisplayShowHomeEnabled(true);

        ivCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"180096005225")));
            }
        });
        ivMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/html");
                intent.putExtra(Intent.EXTRA_EMAIL, "emailaddress@emailaddress.com");
                intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
                intent.putExtra(Intent.EXTRA_TEXT, "Your queries here.");

                startActivity(Intent.createChooser(intent, "Send Email"));
            }
        });
    }
}
