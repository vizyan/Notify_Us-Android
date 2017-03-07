package com.example.deadroit.spectrum;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class Splashscreen extends AppCompatActivity {

    private static int splashInterval = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splashscreen);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent i = new Intent(Splashscreen.this, MainActivity.class);
                startActivity(i);
                this.finish();
            }

            private void finish() {
            }}, splashInterval);
    }
}
