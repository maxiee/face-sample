package com.example.maxiee.face_sample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by maxiee on 15/10/16.
 */
public class Gender {

    @SerializedName("confidence")
    @Expose
    private Double confidence;
    @SerializedName("value")
    @Expose
    private String value;

    /**
     *
     * @return
     * The confidence
     */
    public Double getConfidence() {
        return confidence;
    }

    /**
     *
     * @param confidence
     * The confidence
     */
    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }

    /**
     *
     * @return
     * The value
     */
    public String getValue() {
        return value;
    }

    /**
     *
     * @param value
     * The value
     */
    public void setValue(String value) {
        this.value = value;
    }

}
