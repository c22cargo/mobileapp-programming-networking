package com.example.networking;

import com.google.gson.annotations.SerializedName;

public class Mountain {
    private String name;
    private String location;
    @SerializedName("size")
    private int height;

    public Mountain(String name, String location, int height) {
        this.name = name;
        this.location = location;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Name: '" + name + '\'' +
                ", Location: '" + location + '\'' +
                ", Height: " + height;
    }
}
