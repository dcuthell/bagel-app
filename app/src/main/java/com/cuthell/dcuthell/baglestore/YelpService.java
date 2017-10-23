package com.cuthell.dcuthell.baglestore;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by dcuthell on 10/22/2017.
 */

public class YelpService {
    public static void getReviews(Callback callback){
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
}
