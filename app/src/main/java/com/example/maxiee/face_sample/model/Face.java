package com.example.maxiee.face_sample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by maxiee on 15/10/16.
 */
public class Face {

    @SerializedName("attribute")
    @Expose
    private Attribute attribute;
    @SerializedName("face_id")
    @Expose
    private String faceId;
    @SerializedName("position")
    @Expose
    private Position position;
    @SerializedName("tag")
    @Expose
    private String tag;

    /**
     *
     * @return
     * The attribute
     */
    public Attribute getAttribute() {
        return attribute;
    }

    /**
     *
     * @param attribute
     * The attribute
     */
    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    /**
     *
     * @return
     * The faceId
     */
    public String getFaceId() {
        return faceId;
    }

    /**
     *
     * @param faceId
     * The face_id
     */
    public void setFaceId(String faceId) {
        this.faceId = faceId;
    }

    /**
     *
     * @return
     * The position
     */
    public Position getPosition() {
        return position;
    }

    /**
     *
     * @param position
     * The position
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     *
     * @return
     * The tag
     */
    public String getTag() {
        return tag;
    }

    /**
     *
     * @param tag
     * The tag
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

}
