package com.example.maxiee.face_sample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by maxiee on 15/10/16.
 */
public class Position {

    @SerializedName("center")
    @Expose
    private Center center;
    @SerializedName("eye_left")
    @Expose
    private EyeLeft eyeLeft;
    @SerializedName("eye_right")
    @Expose
    private EyeRight eyeRight;
    @SerializedName("height")
    @Expose
    private Double height;
    @SerializedName("mouth_left")
    @Expose
    private MouthLeft mouthLeft;
    @SerializedName("mouth_right")
    @Expose
    private MouthRight mouthRight;
    @SerializedName("nose")
    @Expose
    private Nose nose;
    @SerializedName("width")
    @Expose
    private Double width;

    /**
     *
     * @return
     * The center
     */
    public Center getCenter() {
        return center;
    }

    /**
     *
     * @param center
     * The center
     */
    public void setCenter(Center center) {
        this.center = center;
    }

    /**
     *
     * @return
     * The eyeLeft
     */
    public EyeLeft getEyeLeft() {
        return eyeLeft;
    }

    /**
     *
     * @param eyeLeft
     * The eye_left
     */
    public void setEyeLeft(EyeLeft eyeLeft) {
        this.eyeLeft = eyeLeft;
    }

    /**
     *
     * @return
     * The eyeRight
     */
    public EyeRight getEyeRight() {
        return eyeRight;
    }

    /**
     *
     * @param eyeRight
     * The eye_right
     */
    public void setEyeRight(EyeRight eyeRight) {
        this.eyeRight = eyeRight;
    }

    /**
     *
     * @return
     * The height
     */
    public Double getHeight() {
        return height;
    }

    /**
     *
     * @param height
     * The height
     */
    public void setHeight(Double height) {
        this.height = height;
    }

    /**
     *
     * @return
     * The mouthLeft
     */
    public MouthLeft getMouthLeft() {
        return mouthLeft;
    }

    /**
     *
     * @param mouthLeft
     * The mouth_left
     */
    public void setMouthLeft(MouthLeft mouthLeft) {
        this.mouthLeft = mouthLeft;
    }

    /**
     *
     * @return
     * The mouthRight
     */
    public MouthRight getMouthRight() {
        return mouthRight;
    }

    /**
     *
     * @param mouthRight
     * The mouth_right
     */
    public void setMouthRight(MouthRight mouthRight) {
        this.mouthRight = mouthRight;
    }

    /**
     *
     * @return
     * The nose
     */
    public Nose getNose() {
        return nose;
    }

    /**
     *
     * @param nose
     * The nose
     */
    public void setNose(Nose nose) {
        this.nose = nose;
    }

    /**
     *
     * @return
     * The width
     */
    public Double getWidth() {
        return width;
    }

    /**
     *
     * @param width
     * The width
     */
    public void setWidth(Double width) {
        this.width = width;
    }

}