package com.cuthell.dcuthell.baglestore;


import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.cuthell.dcuthell.baglestore.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewOrder extends AppCompatActivity {

    @Bind(R.id.addItemButton) Button mAddItemButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_order);

        ButterKnife.bind(this);

        final FragmentManager fm = getFragmentManager();
        final NewItemFragment newItemFragment = new NewItemFragment();
        newItemFragment.show(fm, "This means nothing");

        mAddItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newItemFragment.show(fm, "This means nothing");
            }
        });

    }
}
