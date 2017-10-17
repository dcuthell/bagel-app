package com.cuthell.dcuthell.baglestore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cuthell.dcuthell.baglestore.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SignUp extends AppCompatActivity {

    @Bind(R.id.createAccountButton) Button mCreateAccountButton;
    @Bind(R.id.usernameInputText) EditText mUsernameInputText;
    @Bind(R.id.passwordInputText) EditText mPasswordInputText;
    @Bind(R.id.emailInputText) EditText mEmailInputText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ButterKnife.bind(this);

        mCreateAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(mUsernameInputText.getText().toString())){
                    Toast.makeText(SignUp.this, "Please enter a username", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(mPasswordInputText.getText().toString())){
                    Toast.makeText(SignUp.this, "Please enter a password", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(mEmailInputText.getText().toString())){
                    Toast.makeText(SignUp.this, "Please enter an email", Toast.LENGTH_SHORT).show();
                }
                if(!TextUtils.isEmpty(mUsernameInputText.getText().toString()) && !TextUtils.isEmpty(mPasswordInputText.getText().toString()) && !TextUtils.isEmpty(mEmailInputText.getText().toString())){
                    String welcomeString = "Account Created | Welcome!";
                    Toast.makeText(SignUp.this, welcomeString, Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SignUp.this, Welcome.class);
                    startActivity(intent);
                }

            }
        });
    }
}
