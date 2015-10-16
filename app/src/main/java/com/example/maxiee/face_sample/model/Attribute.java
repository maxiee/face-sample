package com.example.maxiee.face_sample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by maxiee on 15/10/16.
 */
public class Attribute {

    @SerializedName("age")
    @Expose
    private Age age;
    @SerializedName("gender")
    @Expose
    private Gender gender;
    @SerializedName("glass")
    @Expose
    private Glass glass;
    @SerializedName("pose")
    @Expose
    private Pose pose;
    @SerializedName("race")
    @Expose
    private Race race;
    @SerializedName("smiling")
    @Expose
    private Smiling smiling;

    /**
     *
     * @return
     * The age
     */
    public Age getAge() {
        return age;
    }

    /**
     *
     * @param age
     * The age
     */
    public void setAge(Age age) {
        this.age = age;
    }

    /**
     *
     * @return
     * The gender
     */
    public Gender getGender() {
        return gender;
    }

    /**
     *
     * @param gender
     * The gender
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     *
     * @return
     * The glass
     */
    public Glass getGlass() {
        return glass;
    }

    /**
     *
     * @param glass
     * The glass
     */
    public void setGlass(Glass glass) {
        this.glass = glass;
    }

    /**
     *
     * @return
     * The pose
     */
    public Pose getPose() {
        return pose;
    }

    /**
     *
     * @param pose
     * The pose
     */
    public void setPose(Pose pose) {
        this.pose = pose;
    }

    /**
     *
     * @return
     * The race
     */
    public Race getRace() {
        return race;
    }

    /**
     *
     * @param race
     * The race
     */
    public void setRace(Race race) {
        this.race = race;
    }

    /**
     *
     * @return
     * The smiling
     */
    public Smiling getSmiling() {
        return smiling;
    }

    /**
     *
     * @param smiling
     * The smiling
     */
    public void setSmiling(Smiling smiling) {
        this.smiling = smiling;
    }

}
