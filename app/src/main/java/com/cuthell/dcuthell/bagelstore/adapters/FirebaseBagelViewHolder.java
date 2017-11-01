package com.cuthell.dcuthell.bagelstore.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.cuthell.dcuthell.bagelstore.R;
import com.cuthell.dcuthell.bagelstore.models.Bagel;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by dcuthell on 10/30/2017.
 */

public class FirebaseBagelViewHolder extends RecyclerView.ViewHolder{

    View mView;
    Context mContext;

    @Bind(R.id.bagelTypeTextView) TextView mBagelTypeTextView;
    @Bind(R.id.bagelToppingsTextView) TextView mBagelToppingsTextView;

    public FirebaseBagelViewHolder(View itemView){
        super(itemView);
        mView = itemView;
        ButterKnife.bind(this, itemView);
        mContext = itemView.getContext();
    }

    public void bindBagel(Bagel bagel){
        mBagelTypeTextView.setText(bagel.getType());
        mBagelToppingsTextView.setText(bagel.getToppingsAsString());

    }
}
