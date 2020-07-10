package com.biswa.cognizantsoftvisiontest.network;

import retrofit2.Response;


public interface IResponseInterface {

    void onResponseSuccess(Response response, String reqType);

    void onResponseFailure(String responseError);
}
