package com.example.convertisseur;

public class SpinnerItem {
    private final String text;
    private final int imageResId; // Resource ID of the image

    public SpinnerItem(String text, int imageResId) {
        this.text = text;
        this.imageResId = imageResId;
    }

    public String getText() {
        return text;
    }

    public int getImageResId() {
        return imageResId;
    }
}