package com.example.maxiee.face_sample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by maxiee on 15/10/16.
 */
public class MouthLeft {

    @SerializedName("x")
    @Expose
    private Double x;
    @SerializedName("y")
    @Expose
    private Double y;

    /**
     *
     * @return
     * The x
     */
    public Double getX() {
        return x;
    }

    /**
     *
     * @param x
     * The x
     */
    public void setX(Double x) {
        this.x = x;
    }

    /**
     *
     * @return
     * The y
     */
    public Double getY() {
        return y;
    }

    /**
     *
     * @param y
     * The y
     */
    public void setY(Double y) {
        this.y = y;
    }

}