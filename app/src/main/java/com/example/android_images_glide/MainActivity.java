package com.example.android_images_glide;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private final String LOG_KEY = "LOG_KEY@" + this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Planet[] planets = Planet.loadArrayFromJSON(this, "Planets");
    }
}