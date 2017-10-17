package com.cuthell.dcuthell.baglestore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.cuthell.dcuthell.baglestore.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Welcome extends AppCompatActivity {

    @Bind(R.id.newOrderButton) Button mNewOrderButton;
    @Bind(R.id.viewOrdersButton) Button mViewOrdersButton;
    @Bind(R.id.signOutButton) Button mSignOutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        ButterKnife.bind(this);

        mNewOrderButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Welcome.this, NewOrder.class);
                startActivity(intent);
            }
        });

        mViewOrdersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

            }
        });

        mSignOutButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(Welcome.this, "You've been signed out", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Welcome.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
}
