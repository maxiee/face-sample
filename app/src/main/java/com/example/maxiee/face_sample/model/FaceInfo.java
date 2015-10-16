package com.example.maxiee.face_sample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maxiee on 15/10/16.
 */
public class FaceInfo {

    @SerializedName("face")
    @Expose
    private List<Face> face = new ArrayList<Face>();
    @SerializedName("img_height")
    @Expose
    private Integer imgHeight;
    @SerializedName("img_id")
    @Expose
    private String imgId;
    @SerializedName("img_width")
    @Expose
    private Integer imgWidth;
    @SerializedName("session_id")
    @Expose
    private String sessionId;
    @SerializedName("url")
    @Expose
    private String url;

    /**
     *
     * @return
     * The face
     */
    public List<Face> getFace() {
        return face;
    }

    /**
     *
     * @param face
     * The face
     */
    public void setFace(List<Face> face) {
        this.face = face;
    }

    /**
     *
     * @return
     * The imgHeight
     */
    public Integer getImgHeight() {
        return imgHeight;
    }

    /**
     *
     * @param imgHeight
     * The img_height
     */
    public void setImgHeight(Integer imgHeight) {
        this.imgHeight = imgHeight;
    }

    /**
     *
     * @return
     * The imgId
     */
    public String getImgId() {
        return imgId;
    }

    /**
     *
     * @param imgId
     * The img_id
     */
    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

    /**
     *
     * @return
     * The imgWidth
     */
    public Integer getImgWidth() {
        return imgWidth;
    }

    /**
     *
     * @param imgWidth
     * The img_width
     */
    public void setImgWidth(Integer imgWidth) {
        this.imgWidth = imgWidth;
    }

    /**
     *
     * @return
     * The sessionId
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     *
     * @param sessionId
     * The session_id
     */
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    /**
     *
     * @return
     * The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     * The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

}
