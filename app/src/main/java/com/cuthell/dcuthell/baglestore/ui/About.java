package com.cuthell.dcuthell.baglestore.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.cuthell.dcuthell.baglestore.R;
import com.cuthell.dcuthell.baglestore.services.YelpService;
import com.cuthell.dcuthell.baglestore.models.Review;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class About extends AppCompatActivity {

//    @Bind(R.id.locationTextView) TextView mLocationTextView;
//    @Bind(R.id.listView) ListView mListView;

    public ArrayList<Review> reviews = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

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
                        for (Review review : reviews) {
                            Log.d("TESTTTTTTTTTTTTT", "URL " +review.getUrl());
                        }
                    }
                });
            }
        });
    }
}
