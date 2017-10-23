package com.cuthell.dcuthell.baglestore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.cuthell.dcuthell.baglestore.R;
import com.cuthell.dcuthell.baglestore.models.Review;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class About extends AppCompatActivity {

    @Bind(R.id.locationTextView) TextView mLocationTextView;
    @Bind(R.id.listView) ListView mListView;

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
                try{
                    String jsonData = response.body().string();
                    if(response.isSuccessful()){
                        Log.v("TESTING", jsonData);
                        reviews = yelpService.processResults(response);
                    }

                } catch(IOException e){
                    e.printStackTrace();
                }
            }
        });
    }
}
