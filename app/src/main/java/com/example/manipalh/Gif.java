package com.example.manipalh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class Gif extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif);
        Toast.makeText(getApplicationContext(),"Loading", Toast.LENGTH_LONG).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent openMainActivity =  new Intent(Gif.this, SplashActivity.class);
                startActivity(openMainActivity);
                finish();
            }
        }, 1000);

    }
}
