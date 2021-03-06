package com.cuthell.dcuthell.bagelstore.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cuthell.dcuthell.bagelstore.Constants;
import com.cuthell.dcuthell.bagelstore.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @Bind(R.id.signInButton) Button mSignInButton;
    @Bind(R.id.signUpButton) Button mSignUpButton;
    @Bind(R.id.aboutButton) Button mAboutButton;
    @Bind(R.id.welcomeText) TextView mWelcomeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        Typeface keepOnTruckinFont = Typeface.createFromAsset(getAssets(), "fonts/keepOnTruckin.ttf");
        mWelcomeText.setTypeface(keepOnTruckinFont);

        mSignInButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, SignIn.class);
                startActivity(intent);
            }
        });

        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, SignUp.class);
                startActivity(intent);
            }
        });

        mAboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                addToSharedPreferences("bundys-bagels-portland");
                Intent intent = new Intent(MainActivity.this, About.class);
                startActivity(intent);
            }
        });
    }

    private void addToSharedPreferences(String location) {
        mEditor.putString(Constants.YELP_BUSINESS_ID, location).apply();
    }
}
