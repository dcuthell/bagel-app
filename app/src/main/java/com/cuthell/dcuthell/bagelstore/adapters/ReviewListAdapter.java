package com.cuthell.dcuthell.bagelstore.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.cuthell.dcuthell.bagelstore.R;
import com.cuthell.dcuthell.bagelstore.models.Review;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by dcuthell on 10/22/2017.
 */

public class ReviewListAdapter extends RecyclerView.Adapter<ReviewListAdapter.ReviewViewHolder> {
    private Context mContext;
    private ArrayList<Review> mReviews = new ArrayList<>();

    public ReviewListAdapter(Context mContext, ArrayList<Review> mReviews) {
        this.mContext = mContext;
        this.mReviews = mReviews;
    }

    public class ReviewViewHolder extends RecyclerView.ViewHolder {
//        @Bind(R.id.reviewImageView) ImageView mReviewImageView;
        @Bind(R.id.reviewTextView) TextView mReviewTextView;
        @Bind(R.id.readMoreButton) Button mReadMoreButton;

        private Context context;
        private int mOrientation;

        public ReviewViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            mOrientation = itemView.getResources().getConfiguration().orientation;
        }

        public void bindReview(final Review review){
            mReviewTextView.setText(review.getText());
//            if(review.getUser().size() > 1 ){
//                Picasso.with(mContext).load(review.getUser().get(0)).into(mReviewImageView);
//            }
            mReadMoreButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(review.getUrl()));
                    mContext.startActivity(webIntent);
                }
            });
        }

    }

    @Override
    public ReviewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_list_item, parent, false);
        ReviewViewHolder viewHolder = new ReviewViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ReviewListAdapter.ReviewViewHolder holder, int position) {
        holder.bindReview(mReviews.get(position));
    }

    @Override
    public int getItemCount() {
        return mReviews.size();
    }
}
