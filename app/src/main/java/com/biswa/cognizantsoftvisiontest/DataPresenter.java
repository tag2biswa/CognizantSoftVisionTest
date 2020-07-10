package com.biswa.cognizantsoftvisiontest;

import android.util.Log;

import com.biswa.cognizantsoftvisiontest.model.DataResponse;
import com.biswa.cognizantsoftvisiontest.network.IRequestInterface;
import com.biswa.cognizantsoftvisiontest.network.IResponseInterface;
import com.biswa.cognizantsoftvisiontest.network.MyRetrofit;
import com.biswa.cognizantsoftvisiontest.network.ApiResponse;

import retrofit2.Response;

public class DataPresenter implements IDataPresenter, IResponseInterface {
    private IRequestInterface mIRequestInterface;
    private IDataView mIDataView;

    DataPresenter(IDataView iDataView) {
        this.mIDataView = iDataView;
        this.mIRequestInterface = new ApiResponse(this);
    }

    @Override
    public void getDataFromUrl() {
        if (MyRetrofit.getInstance() == null){
            Log.d("DataPresenter", "getDataFromUrl: biswa_2");

        }
        mIRequestInterface.callApi(MyRetrofit.getInstance().service.getDataFromUrl(), "req_data");
    }

    @Override
    public void onResponseSuccess(Response response, String reqType) {
        if (reqType.equalsIgnoreCase("req_data")) {
            Log.e("GetAllRoomListURL", String.valueOf(response.raw().request().url()));
            Log.e("GetAllRoomListResponse", response.body().toString());
            mIDataView.onRowItem((DataResponse) response.body(), ((DataResponse) response.body()).getTitle());

        }
    }

    @Override
    public void onResponseFailure(String responseError) {
        mIDataView.onFail(responseError);
    }


}
