package com.example.android_images_glide;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class Planet {
    private final String LOG_KEY = "LOG_KEY@" + this.getClass().getSimpleName();
    private String position;
    private String name;
    private String imageURl;
    private String imageLocal;
    private String velocity;
    private String distance;
    private String description;

    public Planet(JSONObject jsonObject) throws JSONException {
        this.position = jsonObject.getString("position");
        this.name = jsonObject.getString("name");
        this.imageURl = jsonObject.getString("image");
        this.imageLocal = String.format("images/%s.jpg", name.toLowerCase());
        this.velocity = jsonObject.getString("velocity");
        this.distance = jsonObject.getString("distance");
        this.description = jsonObject.getString("description");
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURl() {
        return imageURl;
    }

    public void setImageURl(String imageURl) {
        this.imageURl = imageURl;
    }

    public String getVelocity() {
        return velocity;
    }

    public void setVelocity(String velocity) {
        this.velocity = velocity;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageLocal() {
        return imageLocal;
    }

    public void setImageLocal(String imageLocal) {
        this.imageLocal = imageLocal;
    }

    public static String loadStringFromAssets(Context context, String fileName) throws IOException {
        InputStream inputStream = context.getAssets().open(fileName);
        int size = inputStream.available();
        byte[] buffer = new byte[size];
        inputStream.read(buffer);
        inputStream.close();
        return new String(buffer, "UTF-8");
    }

    public static Planet[] loadArrayFromJSON(Context context, String type) {
        try {
            String json = loadStringFromAssets(context, "planets.json");
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray(type);
            Planet[] solarObjects = new Planet[jsonArray.length()];
            for (int i = 0; i < jsonArray.length(); i++) {
                Planet solarObject = new Planet(jsonArray.getJSONObject(i));
                solarObjects[i] = solarObject;
            }
            return solarObjects;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new Planet[0];
    }
}
