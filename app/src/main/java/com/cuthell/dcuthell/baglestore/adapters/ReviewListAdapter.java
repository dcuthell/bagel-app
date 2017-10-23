package com.cuthell.dcuthell.baglestore.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cuthell.dcuthell.baglestore.R;
import com.cuthell.dcuthell.baglestore.models.Review;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by dcuthell on 10/22/2017.
 */

public class ReviewListAdapter extends RecyclerView.Adapter<ReviewListAdapter.ReviewViewHolder> {
    private ArrayList<Review> mReviews = new ArrayList<>();
    private Context mContext;

    public ReviewListAdapter(Context context, ArrayList<Review> mReviews) {
        this.mReviews = mReviews;
        this.mContext = context;
    }

    public class ReviewViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.reviewImageView) ImageView mReviewImageView;
        @Bind(R.id.reviewTextView) TextView mReviewTextView;

        private Context context;

        public ReviewViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindReview(Review review){
            mReviewTextView.setText(review.getText());
            if(review.getUser().size() > 1 ){
                Picasso.with(mContext).load(review.getUser().get(0)).into(mReviewImageView);
            }
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
