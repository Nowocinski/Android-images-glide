package com.example.android_images_glide;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlanetsViewHolder extends RecyclerView.ViewHolder {
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
    }

    public Planet getPlanet() {
        return planet;
    }
}
