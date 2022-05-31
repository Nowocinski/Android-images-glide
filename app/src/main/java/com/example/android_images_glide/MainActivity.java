package com.example.android_images_glide;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private final String LOG_KEY = "LOG_KEY@" + this.getClass().getSimpleName();
    private RecyclerView planetsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Planet[] planets = Planet.loadArrayFromJSON(this, "Planets");

        this.planetsRecyclerView = findViewById(R.id.planetsRecyclerView);
        this.planetsRecyclerView.setLayoutManager(new GridLayoutManager(/*getActivity()*/this, 2));
        this.planetsRecyclerView.setAdapter(new PlanetsAdapter(planets));
    }
}