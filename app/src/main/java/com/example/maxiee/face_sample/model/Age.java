package com.example.maxiee.face_sample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by maxiee on 15/10/16.
 */
public class Age {

    @SerializedName("range")
    @Expose
    private Integer range;
    @SerializedName("value")
    @Expose
    private Integer value;

    /**
     *
     * @return
     * The range
     */
    public Integer getRange() {
        return range;
    }

    /**
     *
     * @param range
     * The range
     */
    public void setRange(Integer range) {
        this.range = range;
    }

    /**
     *
     * @return
     * The value
     */
    public Integer getValue() {
        return value;
    }

    /**
     *
     * @param value
     * The value
     */
    public void setValue(Integer value) {
        this.value = value;
    }

}