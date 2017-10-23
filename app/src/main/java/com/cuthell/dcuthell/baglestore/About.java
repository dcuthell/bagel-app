package com.cuthell.dcuthell.baglestore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.cuthell.dcuthell.baglestore.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class About extends AppCompatActivity {

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
                try{
                    String jsonData = response.body().string();
                    Log.v("TESTING", jsonData);
                } catch(IOException e){
                    e.printStackTrace();
                }
            }
        });
    }
}
