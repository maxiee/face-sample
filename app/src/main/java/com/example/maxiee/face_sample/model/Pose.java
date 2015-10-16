package com.example.maxiee.face_sample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by maxiee on 15/10/16.
 */
public class Pose {

    @SerializedName("pitch_angle")
    @Expose
    private PitchAngle pitchAngle;
    @SerializedName("roll_angle")
    @Expose
    private RollAngle rollAngle;
    @SerializedName("yaw_angle")
    @Expose
    private YawAngle yawAngle;

    /**
     *
     * @return
     * The pitchAngle
     */
    public PitchAngle getPitchAngle() {
        return pitchAngle;
    }

    /**
     *
     * @param pitchAngle
     * The pitch_angle
     */
    public void setPitchAngle(PitchAngle pitchAngle) {
        this.pitchAngle = pitchAngle;
    }

    /**
     *
     * @return
     * The rollAngle
     */
    public RollAngle getRollAngle() {
        return rollAngle;
    }

    /**
     *
     * @param rollAngle
     * The roll_angle
     */
    public void setRollAngle(RollAngle rollAngle) {
        this.rollAngle = rollAngle;
    }

    /**
     *
     * @return
     * The yawAngle
     */
    public YawAngle getYawAngle() {
        return yawAngle;
    }

    /**
     *
     * @param yawAngle
     * The yaw_angle
     */
    public void setYawAngle(YawAngle yawAngle) {
        this.yawAngle = yawAngle;
    }

}
