package com.durga.balaji66.signupusingretrofitpostrequest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEmailId, mPassword;
    private Button mSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        initializeViews();
        initializeListeners();
    }
    public void initializeViews()
    {
        mEmailId =(EditText)findViewById(R.id.editTextEmail);
        mPassword =(EditText)findViewById(R.id.editTextPassword);
        mSignIn =(Button)findViewById(R.id.buttonSignIn);
    }
    public void initializeListeners()
    {
        mSignIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.buttonSignIn:
                checkValidation();
                break;
        }
    }
    public void checkValidation()
    {
        String email =mEmailId.getText().toString().trim();
        String password =mPassword.getText().toString().trim();
        if(email.equals(""))
        {
            Toast.makeText(getApplicationContext(),"Email field must not be empty",Toast.LENGTH_LONG).show();
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            Toast.makeText(getApplicationContext(),"Enter valid email Id",Toast.LENGTH_LONG).show();
        }
        else  if(password.equals(""))
        {
            Toast.makeText(getApplicationContext(),"Password field must not be empty",Toast.LENGTH_LONG).show();
        }
    }
}
