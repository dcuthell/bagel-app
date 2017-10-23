package com.cuthell.dcuthell.baglestore.services;

import android.util.Log;

import com.cuthell.dcuthell.baglestore.Constants;
import com.cuthell.dcuthell.baglestore.models.Review;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by dcuthell on 10/22/2017.
 */

public class YelpService {

    public static void getReviews(Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.YELP_BASE_URL).newBuilder();
        urlBuilder.addPathSegment(Constants.YELP_BUSINESS_ID)
                .addPathSegment("reviews");
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .header("Authorization", Constants.YELP_TOKEN)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Review> processResults(Response response) {
        ArrayList<Review> reviews = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            JSONObject yelpJSON = new JSONObject(jsonData);
            JSONArray reviewsJSON = yelpJSON.getJSONArray("reviews");
            for (int i = 0; i < reviewsJSON.length(); i++) {
                JSONObject reviewJSON = reviewsJSON.getJSONObject(i);
                String url = reviewJSON.getString("url");
                String text = reviewJSON.getString("text");
                double rating = reviewJSON.getDouble("rating");
                ArrayList<String> user = new ArrayList<>();
                if (reviewJSON.getJSONObject("user").getString("image_url") != null) {
                    user.add(reviewJSON.getJSONObject("user").getString("image_url"));
                }
                user.add(reviewJSON.getJSONObject("user").getString("name"));

                String timeCreated = reviewJSON.getString("time_created");
                Review review = new Review(url, text, rating, user, timeCreated);
                reviews.add(review);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reviews;
    }
}
