package com.biswa.cognizantsoftvisiontest.network;

import retrofit2.Call;

public interface IRequestInterface {
    void callApi(Call call, final String reqType);
}
