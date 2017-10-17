package com.cuthell.dcuthell.baglestore;


import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.cuthell.dcuthell.baglestore.R;

public class NewOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_order);

        FragmentManager fm = getFragmentManager();
        NewItemFragment newItemFragment = new NewItemFragment();
        newItemFragment.show(fm, "hi");

    }
}
