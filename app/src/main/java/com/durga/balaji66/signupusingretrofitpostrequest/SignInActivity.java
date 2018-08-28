package com.durga.balaji66.signupusingretrofitpostrequest;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.durga.balaji66.signupusingretrofitpostrequest.Models.DefaultResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

                if(checkValidation())
                {
                    signIn();
                }
                break;
        }
    }
    public boolean checkValidation()
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
        else
        {
            return true;
        }
        return false;
    }

    public void signIn()
    {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Signing Up...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        String email = mEmailId.getText().toString().trim();
        String password = mPassword.getText().toString().trim();

        Call<DefaultResponse> call = APIUrl.getmInstance().getApi().customerLogin(email, password);

        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                if(response.code() == 201)
                {
                    progressDialog.dismiss();
                    Intent homeActivityIntent =new Intent(SignInActivity.this,HomeActivity.class);
                    startActivity(homeActivityIntent);
                    //DefaultResponse dr =response.body();
                    //Toast.makeText(getApplicationContext(),dr.getMessage(),Toast.LENGTH_LONG).show();
                }
                else
                {
                    progressDialog.dismiss();
                    Toast.makeText(getApplicationContext(),"Invalid email or password",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                    Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
