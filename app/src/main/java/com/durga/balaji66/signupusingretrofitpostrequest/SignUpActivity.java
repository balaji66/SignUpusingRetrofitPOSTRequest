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

import java.io.IOException;

import javax.xml.transform.Result;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mName, mPhone, mEmail, mPassword;
    private Button mSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initializeViews();
        initializeListeners();

        //https://pusuluribalaji66.000webhostapp.comCabManagement/public/customerregister
    }

    public void initializeViews() {
        mName = (EditText) findViewById(R.id.editTextName);
        mPhone = (EditText) findViewById(R.id.editTextPhone);
        mEmail = (EditText) findViewById(R.id.editTextEmail);
        mPassword = (EditText) findViewById(R.id.editTextPassword);
        mSignUp = (Button) findViewById(R.id.buttonSignUp);
    }

    public void initializeListeners() {
        mSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonSignUp:

                validation();
                if (validation()) {
                    retrofitSignUpCode();
                }
                break;
        }
    }

    public void retrofitSignUpCode() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Signing Up...");
        progressDialog.show();

        //getting editText values and storing in variables
        String name = mName.getText().toString().trim();
        String email = mEmail.getText().toString().trim();
        String phone = mPhone.getText().toString().trim();
        String password = mPassword.getText().toString().trim();
        int fine = 0;

        Call<ResponseBody> call = APIUrl.getmInstance().getApi().newCustomerRegistration(name, email, phone, password, fine);
        //calling the api
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                //hiding progress dialog
                progressDialog.dismiss();
                try {
                    String s = response.body().string();
                    //displaying the message from the response as toast
                    Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override

            public void onFailure(Call<ResponseBody> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public boolean validation() {
        String name = mName.getText().toString().trim();
        CharSequence phone = mPhone.getText().toString().trim();
        String email = mEmail.getText().toString().trim();
        String password = mPassword.getText().toString().trim();
        if (name.equals("")) {
            mName.setError("Name must not be empty");
            //Toast.makeText(getApplicationContext(),"Name must not be empty",Toast.LENGTH_LONG).show();
        } else if (phone.equals("")) {
            mPhone.setError("phone must not be empty");
            //Toast.makeText(getApplicationContext(),"phone must not be empty",Toast.LENGTH_LONG).show();
        } else if (phone.length() > 10 || phone.length() < 10) {
            mPhone.setError("Enter 10 digit mobile number");
            //Toast.makeText(getApplicationContext(),"Enter 10 digit mobile number",Toast.LENGTH_LONG).show();
        } else if (email.equals("")) {
            mEmail.setError("Email must not be empty");
            //Toast.makeText(getApplicationContext(),"Email must not be empty",Toast.LENGTH_LONG).show();
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEmail.setError("Enter Valid Email Id");
            //Toast.makeText(getApplicationContext(),"Enter Valid Email Id",Toast.LENGTH_LONG).show();
        } else if (password.equals("")) {
            mPassword.setError("Password must not be empty");
            //Toast.makeText(getApplicationContext(),"Password must not be empty",Toast.LENGTH_LONG).show();
        } else {
            return true;
        }

        return false;
    }
}





