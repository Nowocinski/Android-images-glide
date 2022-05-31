package com.example.android_images_glide;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PlanetsAdapter extends RecyclerView.Adapter<PlanetsViewHolder>{
    private final Planet[] planets;

    public PlanetsAdapter(Planet[] planets) {
        this.planets = planets;
    }

    @NonNull
    @Override
    public PlanetsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_solar_object, parent, false);
        return new PlanetsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetsViewHolder holder, int position) {
        Planet planet = planets[position];
        holder.setPlanet(planet);
    }

    @Override
    public int getItemCount() {
        return this.planets.length;
    }
}