package com.biswa.cognizantsoftvisiontest.network;


import java.net.ConnectException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ApiResponse implements IRequestInterface {

    public IResponseInterface iResponseInterface;

    /**
     * Constructor
     *
     * @param iResponseInterface
     */
    public ApiResponse(IResponseInterface iResponseInterface) {
        this.iResponseInterface = iResponseInterface;
    }

    @Override
    public void callApi(Call call, final String reqType) {
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                iResponseInterface.onResponseSuccess(response, reqType);
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                if (t instanceof ConnectException) {
                    iResponseInterface.onResponseFailure("No Internet Connection");
                } else {
                    t.printStackTrace();
                    iResponseInterface.onResponseFailure("CategoryResponse Failed");
                }
            }
        });
    }
}
