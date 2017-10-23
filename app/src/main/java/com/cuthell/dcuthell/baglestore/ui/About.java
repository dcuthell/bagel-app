package com.cuthell.dcuthell.baglestore.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.cuthell.dcuthell.baglestore.R;
import com.cuthell.dcuthell.baglestore.adapters.ReviewListAdapter;
import com.cuthell.dcuthell.baglestore.services.YelpService;
import com.cuthell.dcuthell.baglestore.models.Review;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class About extends AppCompatActivity {

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    private ReviewListAdapter mAdapter;

    public ArrayList<Review> reviews = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);

        getReviews();
    }

    private void getReviews(){
        final YelpService yelpService = new YelpService();
        yelpService.getReviews(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                reviews = yelpService.processResults(response);

                About.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter = new ReviewListAdapter(getApplicationContext(), reviews);
                        Log.d("TESSSSSSTTT", mAdapter.getItemCount()+"");
                        Log.d("TESSSSSSTTT", mRecyclerView+"");
                        mRecyclerView.setAdapter(mAdapter);
                        Log.d("TESSSSSSTTT", "Oh hey");
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(About.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                        for (Review review : reviews) {
                            Log.d("TESTTTTTTTTTTTTT", "URL " +review.getUrl());
                        }
                    }
                });
            }
        });
    }
}
