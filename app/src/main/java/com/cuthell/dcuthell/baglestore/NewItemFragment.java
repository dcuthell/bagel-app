package com.cuthell.dcuthell.baglestore;

import android.os.Bundle;
import android.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by dcuthell on 10/16/2017.
 */

public class NewItemFragment extends DialogFragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_newitem, container, false);
        getDialog().setTitle("Simple Dialog");
        return rootView;
    }

}