package com.cuthell.dcuthell.baglestore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SignIn extends AppCompatActivity {

    @Bind(R.id.signInButton) Button mSignInButton;
    @Bind(R.id.usernameInputText) EditText mUsernameInputText;
    @Bind(R.id.passwordInputText) EditText mPasswordInputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        ButterKnife.bind(this);

        mSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(TextUtils.isEmpty(mUsernameInputText.getText().toString())){
                    Toast.makeText(SignIn.this, "Please enter a username", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(mPasswordInputText.getText().toString())){
                    Toast.makeText(SignIn.this, "Please enter a password", Toast.LENGTH_SHORT).show();
                }
                if(!TextUtils.isEmpty(mUsernameInputText.getText().toString()) && !TextUtils.isEmpty(mPasswordInputText.getText().toString())){
                    Intent intent = new Intent(SignIn.this, Welcome.class);
                    startActivity(intent);
                }
            }
        });
    }
}
