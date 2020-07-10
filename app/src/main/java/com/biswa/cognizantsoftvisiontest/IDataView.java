package com.biswa.cognizantsoftvisiontest;

import com.biswa.cognizantsoftvisiontest.model.DataResponse;

public interface IDataView {
    /**
     * Resposne row item
     *
     * @param roomResponse
     * @param title
     */
    void onRowItem(DataResponse roomResponse, String title);

    /**
     * Response fail message
     *
     * @param failMsg
     */
    void onFail(String failMsg);
}
