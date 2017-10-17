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

    private ArrayList<Bagel> bagelList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_order);

        ButterKnife.bind(this);

        mAddItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                NewItemFragment newItemFragment = new NewItemFragment();
                newItemFragment.show(fm, "This means nothing");
            }
        });

    }

    public void onStart(){
        super.onStart();
        String test = "Lame";

        Log.d("testing", "RESET CRAP");
        Bagel testBagel = new Bagel();
        testBagel.setType("Plain");
        testBagel.addTopping("Cheese");
        testBagel.addTopping("Cheese1");
        testBagel.addTopping("Cheese2");
        bagelList.add(testBagel);


        if(getIntent().getStringExtra("bagelType") != null){
            test = getIntent().getStringExtra("bagelType");
            Bagel newBagel = new Bagel();
            newBagel.setType(test);
            test = newBagel.getType() + "WOOOO";
            bagelList.add(newBagel);
        }

        BagelArrayAdapter adapter = new BagelArrayAdapter(this, android.R.layout.simple_list_item_1, bagelList);
        mItemList.setAdapter(adapter);

        Log.d("testing", test);
//
//        BagelArrayAdapter adapter = new BagelArrayAdapter(this, android.R.layout.simple_list_item_1, bagelList);
//        mItemList.setAdapter(adapter);


    }

}
