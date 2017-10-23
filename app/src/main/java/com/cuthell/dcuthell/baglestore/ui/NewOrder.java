package com.cuthell.dcuthell.baglestore.ui;


import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


import com.cuthell.dcuthell.baglestore.R;
import com.cuthell.dcuthell.baglestore.models.Bagel;

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
                newItemFragment.show(fm, "newItem");
            }
        });

        mSubmitOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NewOrder.this, "Order Submitted", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(NewOrder.this, Welcome.class);
                startActivity(intent);
            }
        });

    }

    public void onStart(){
        super.onStart();

        //Test Data
        Bagel testBagel1 = new Bagel();
        testBagel1.setType("Plain");
        testBagel1.addTopping("Test Topping 1");
        bagelList.add(testBagel1);
        Bagel testBagel2 = new Bagel();
        testBagel2.setType("Plain");
        testBagel2.addTopping("Test Topping 1");
        testBagel2.addTopping("Test Topping 2");
        bagelList.add(testBagel2);
        Bagel testBagel3 = new Bagel();
        testBagel3.setType("Plain");
        testBagel3.addTopping("Test Topping 1");
        testBagel3.addTopping("Test Topping 2");
        testBagel3.addTopping("Test Topping 3");
        bagelList.add(testBagel3);
        //End Test Data

        if(getIntent().getStringExtra("bagelType") != null){
//            test = getIntent().getStringExtra("bagelType");
            Bagel newBagel = new Bagel();
            newBagel.setType(getIntent().getStringExtra("bagelType"));
            newBagel.setToppings((ArrayList<String>)getIntent().getSerializableExtra("bagelToppings"));
            bagelList.add(newBagel);
        }

        BagelArrayAdapter adapter = new BagelArrayAdapter(this, android.R.layout.simple_list_item_1, bagelList);
        mItemList.setAdapter(adapter);
    }

}
