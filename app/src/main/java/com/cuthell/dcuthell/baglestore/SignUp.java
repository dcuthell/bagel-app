package com.cuthell.dcuthell.baglestore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cuthell.dcuthell.baglestore.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SignUp extends AppCompatActivity {

    @Bind(R.id.createAccountButton) Button mCreateAccountButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ButterKnife.bind(this);

        mCreateAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, Welcome.class);
                startActivity(intent);
            }
        });
    }
}
