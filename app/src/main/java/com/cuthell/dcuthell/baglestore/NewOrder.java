package com.cuthell.dcuthell.baglestore;


import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;


import com.cuthell.dcuthell.baglestore.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewOrder extends AppCompatActivity {

    @Bind(R.id.itemList) ListView mItemList;
    @Bind(R.id.addItemButton) Button mAddItemButton;
    @Bind(R.id.submitOrderButton) Button mSubmitOrderButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_order);

        ButterKnife.bind(this);

        final FragmentManager fm = getFragmentManager();
        final NewItemFragment newItemFragment = new NewItemFragment();

        ArrayList<Bagel> bagelList = new ArrayList<>();
        Log.d("testing", "RESET CRAP");
        Bagel testBagel = new Bagel();
        testBagel.setType("Plain");
        testBagel.addTopping("Cheese");
        testBagel.addTopping("Cheese1");
        testBagel.addTopping("Cheese2");
        bagelList.add(testBagel);

        BagelArrayAdapter adapter = new BagelArrayAdapter(this, android.R.layout.simple_list_item_1, bagelList);
        mItemList.setAdapter(adapter);

        mAddItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newItemFragment.show(fm, "This means nothing");
            }
        });

    }

    public void onStart(){
        super.onStart();
        Bagel newBagel = new Bagel();
        String test = getIntent().getStringExtra("bagelType");

        Log.d("testing", "STARTING TOO?");
//
//        BagelArrayAdapter adapter = new BagelArrayAdapter(this, android.R.layout.simple_list_item_1, bagelList);
//        mItemList.setAdapter(adapter);


    }

}
