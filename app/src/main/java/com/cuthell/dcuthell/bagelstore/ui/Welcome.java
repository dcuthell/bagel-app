package com.cuthell.dcuthell.bagelstore.ui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cuthell.dcuthell.bagelstore.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Welcome extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Bind(R.id.newOrderButton) Button mNewOrderButton;
    @Bind(R.id.viewOrdersButton) Button mViewOrdersButton;
    @Bind(R.id.signOutButton) Button mSignOutButton;
    @Bind(R.id.welcomeTextView) TextView mWelcomeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        ButterKnife.bind(this);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    mWelcomeTextView.setText("Welcome, " + user.getDisplayName() + "!");
                } else {

                }
            }
        };

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
                Toast.makeText(Welcome.this, "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        });

        mSignOutButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                logout();
                Toast.makeText(Welcome.this, "You've been signed out", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Welcome.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(Welcome.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}
