package com.biswa.cognizantsoftvisiontest;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.biswa.cognizantsoftvisiontest.model.DataResponse;

public class MainActivity extends AppCompatActivity implements IDataView {

    private IDataPresenter mIDataPresenter;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private TextView mPullText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSwipeRefreshLayout = findViewById(R.id.swipe_container);
        mPullText = findViewById(R.id.pull_to_refres);
        mRecyclerView = findViewById(R.id.recycler_view);
        mIDataPresenter = new DataPresenter(this);
        mIDataPresenter.getDataFromUrl();

        mSwipeRefreshLayout.setOnRefreshListener(() -> {
            mPullText.setVisibility(View.GONE);
            mIDataPresenter.getDataFromUrl();
        });
    }


    @Override
    public void onRowItem(DataResponse dataResponse, String title) {
        mPullText.setVisibility(View.VISIBLE);
        mSwipeRefreshLayout.setRefreshing(false);
        DataAdapter adapter = new DataAdapter(MainActivity.this, dataResponse);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onFail(String failMsg) {
        //error screen
    }
}