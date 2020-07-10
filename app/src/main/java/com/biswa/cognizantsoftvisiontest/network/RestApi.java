package com.biswa.cognizantsoftvisiontest.network;

import com.biswa.cognizantsoftvisiontest.model.DataResponse;

import retrofit2.Call;
import retrofit2.http.POST;

public interface RestApi {
    /**
     * Get data from webservice
     *
     * @return
     */
    @POST("/s/2iodh4vg0eortkl/facts.json")
    Call<DataResponse> getDataFromUrl();
}
