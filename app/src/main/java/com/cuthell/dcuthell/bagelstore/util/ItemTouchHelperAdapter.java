package com.cuthell.dcuthell.bagelstore.util;

/**
 * Created by dcuthell on 11/7/2017.
 */

public interface ItemTouchHelperAdapter {
    boolean onItemMove(int fromPosition, int toPosition);
    void onItemDismiss(int position);
}
