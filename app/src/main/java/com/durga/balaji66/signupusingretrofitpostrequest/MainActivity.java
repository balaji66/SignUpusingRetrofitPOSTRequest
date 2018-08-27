package com.durga.balaji66.signupusingretrofitpostrequest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mSignIn, mSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        initializeListeners();
    }
    public void initializeViews()
    {
        mSignIn=(Button)findViewById(R.id.buttonSignIn);
        mSignUp=(Button)findViewById(R.id.buttonSignUp);
    }
    public void initializeListeners()
    {
        mSignUp.setOnClickListener(this);
        mSignIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.buttonSignUp:
                Intent singUpActivity =new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(singUpActivity);
                break;
            case R.id.buttonSignIn:
                Intent singInActivity =new Intent(MainActivity.this, SignInActivity.class);
                startActivity(singInActivity);
                break;
        }
    }
}
