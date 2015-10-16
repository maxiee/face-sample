package com.example.maxiee.face_sample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by maxiee on 15/10/16.
 */
public class Smiling {

    @SerializedName("value")
    @Expose
    private Double value;

    /**
     *
     * @return
     * The value
     */
    public Double getValue() {
        return value;
    }

    /**
     *
     * @param value
     * The value
     */
    public void setValue(Double value) {
        this.value = value;
    }

}
