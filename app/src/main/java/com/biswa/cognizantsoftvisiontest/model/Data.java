package com.biswa.cognizantsoftvisiontest.model;

import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("title")
    private String mTitle;

    @SerializedName("description")
    private String mDescription;

    @SerializedName("imageHref")
    private String mImageUrl;

    public Data(String title, String description, String imageUrl) {
        this.mTitle = title;
        this.mDescription = description;
        this.mImageUrl = imageUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.mImageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Data{" +
                "mTitle='" + mTitle + '\'' +
                ", mDescription='" + mDescription + '\'' +
                ", mImageUrl='" + mImageUrl + '\'' +
                '}';
    }
}
