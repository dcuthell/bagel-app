package com.cuthell.dcuthell.bagelstore.adapters;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.View;

import com.cuthell.dcuthell.bagelstore.models.Bagel;
import com.cuthell.dcuthell.bagelstore.util.ItemTouchHelperAdapter;
import com.cuthell.dcuthell.bagelstore.util.OnStartDragListener;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

/**
 * Created by dcuthell on 11/7/2017.
 */

public class FirebaseBagelListAdapter extends FirebaseRecyclerAdapter<Bagel, FirebaseBagelViewHolder> implements ItemTouchHelperAdapter {
    private DatabaseReference mRef;
    private OnStartDragListener mOnStartDragListener;
    private Context mContext;

    public FirebaseBagelListAdapter(Class<Bagel> modelClass, int modelLayout, Class<FirebaseBagelViewHolder> viewHolderClass, Query ref, OnStartDragListener onStartDragListener, Context context) {
        super(modelClass, modelLayout, viewHolderClass, ref);
        mRef = ref.getRef();
        mOnStartDragListener = onStartDragListener;
        mContext = context;
    }

    @Override
    protected void populateViewHolder(final FirebaseBagelViewHolder viewHolder, Bagel model, int position) {
        viewHolder.bindBagel(model);
        viewHolder.mReorderImageView.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN){
                    mOnStartDragListener.onStartDrag(viewHolder);
                }
                return false;
            }
        });
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition){
        notifyItemMoved(fromPosition, toPosition);
        return false;
    }

    @Override
    public void onItemDismiss(int position){
        getRef(position).removeValue();
    }
}
