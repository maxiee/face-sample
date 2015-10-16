package com.example.maxiee.face_sample.api;

import com.example.maxiee.face_sample.model.FaceInfo;
import com.squareup.okhttp.RequestBody;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created by maxiee on 15/10/16.
 */
public interface DetectionApi {
    @POST("/v2/detection/detect")
    Call<FaceInfo> detect(
        @Body RequestBody post
    );
}
