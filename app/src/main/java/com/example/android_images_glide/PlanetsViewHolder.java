package com.example.android_images_glide;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlanetsViewHolder extends RecyclerView.ViewHolder {
    private final String LOG_KEY = "LOG_KEY@" + this.getClass().getSimpleName();
    @BindView(R.id.itemImageView)
    ImageView itemImageView;
    @BindView(R.id.itemTextView)
    TextView itemTextView;
    private Planet planet;

    public PlanetsViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
        this.itemTextView.setText(this.planet.getName());
        Glide.with(this.itemImageView.getContext())
                .load("file:///android_asset/" + this.planet.getImageLocal())
                .into(this.itemImageView);
    }

    public Planet getPlanet() {
        return planet;
    }
}
