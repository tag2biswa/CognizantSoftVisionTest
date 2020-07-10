package com.biswa.cognizantsoftvisiontest.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataResponse {
    @SerializedName("title")
    private String title;

    @SerializedName("rows")
    private List<Data> rows;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Data> getRows() {
        return rows;
    }

    public void setRows(List<Data> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "DataResponse{" +
                "title='" + title + '\'' +
                ", rows=" + rows +
                '}';
    }
}
