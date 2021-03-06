package com.cuthell.dcuthell.bagelstore.ui;


import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


import com.cuthell.dcuthell.bagelstore.Constants;
import com.cuthell.dcuthell.bagelstore.R;
import com.cuthell.dcuthell.bagelstore.adapters.FirebaseBagelListAdapter;
import com.cuthell.dcuthell.bagelstore.adapters.FirebaseBagelViewHolder;
import com.cuthell.dcuthell.bagelstore.models.Bagel;
import com.cuthell.dcuthell.bagelstore.util.ItemTouchHelperAdapter;
import com.cuthell.dcuthell.bagelstore.util.OnStartDragListener;
import com.cuthell.dcuthell.bagelstore.util.SimpleItemTouchHelperCallback;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.cuthell.dcuthell.bagelstore.Constants.FIREBASE_CHILD_BAGELS;

public class NewOrder extends AppCompatActivity implements OnStartDragListener{

//    @Bind(R.id.itemList) ListView mItemList;
    @Bind(R.id.addItemButton) Button mAddItemButton;
    @Bind(R.id.submitOrderButton) Button mSubmitOrderButton;
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;

    private DatabaseReference mBagelReference;
    private FirebaseBagelListAdapter mFirebaseAdapter;
    private ItemTouchHelper mItemTouchHelper;

    private ArrayList<Bagel> bagelList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_order);

        ButterKnife.bind(this);

        setUpFirebaseAdapter();

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

    public void setUpFirebaseAdapter(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        Query query = FirebaseDatabase.getInstance().getReference(FIREBASE_CHILD_BAGELS).child(uid).orderByChild(Constants.FIREBASE_QUERY_INDEX);

//        mBagelReference = FirebaseDatabase.getInstance().getReference(FIREBASE_CHILD_BAGELS).child(uid);

        mFirebaseAdapter = new FirebaseBagelListAdapter(Bagel.class, R.layout.bagel_list_item, FirebaseBagelViewHolder.class, query, this, this);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(mFirebaseAdapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.cleanup();
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }
//    public void onStart(){
//        super.onStart();
//
//
//
////        //Test Data
////        Bagel testBagel1 = new Bagel();
////        testBagel1.setType("Plain");
////        testBagel1.addTopping("Test Topping 1");
////        bagelList.add(testBagel1);
////        Bagel testBagel2 = new Bagel();
////        testBagel2.setType("Plain");
////        testBagel2.addTopping("Test Topping 1");
////        testBagel2.addTopping("Test Topping 2");
////        bagelList.add(testBagel2);
////        Bagel testBagel3 = new Bagel();
////        testBagel3.setType("Plain");
////        testBagel3.addTopping("Test Topping 1");
////        testBagel3.addTopping("Test Topping 2");
////        testBagel3.addTopping("Test Topping 3");
////        bagelList.add(testBagel3);
////        //End Test Data
////
//////        if(getIntent().getStringExtra("bagelType") != null){
////////            test = getIntent().getStringExtra("bagelType");
//////            Bagel newBagel = new Bagel();
//////            newBagel.setType(getIntent().getStringExtra("bagelType"));
//////            newBagel.setToppings((ArrayList<String>)getIntent().getSerializableExtra("bagelToppings"));
//////            bagelList.add(newBagel);
//////        }
////        if(getIntent().getExtras() != null){
////            Bagel newBagel = Parcels.unwrap(getIntent().getParcelableExtra("bagel"));
////            bagelList.add(newBagel);
////        }
////
////
////        BagelArrayAdapter adapter = new BagelArrayAdapter(this, android.R.layout.simple_list_item_1, bagelList);
////        mItemList.setAdapter(adapter);
//    }

}
