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

import javax.xml.transform.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{

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
        mName =(EditText)findViewById(R.id.editTextName);
        mPhone =(EditText)findViewById(R.id.editTextPhone);
        mEmail =(EditText)findViewById(R.id.editTextEmail);
        mPassword =(EditText)findViewById(R.id.editTextPassword);
        mSignUp =(Button)findViewById(R.id.buttonSignUp);
    }
    public void initializeListeners()
    {
        mSignUp.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.buttonSignUp:

                validation();
                if(validation())
                {
                    retrofitSignUpCode();
                }
                break;
        }
    }
    public void retrofitSignUpCode()
    {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Signing Up...");
        progressDialog.show();

        String name =mName.getText().toString().trim();
        String email =mEmail.getText().toString().trim();
        String phone =mPhone.getText().toString().trim();
        String password =mPassword.getText().toString().trim();
        int fine =10;
        //building retrofit object
        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl(APIUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //Defining retrofit api service
        ApiService service = retrofit.create(ApiService.class);

        //Defining the user object as we need to pass it with the call
        User user = new User(name, email, phone, password, fine);

        Call<Result> call =service.createUser(user.getName(),user.getEmail(),user.getPhone(),user.getPassword(), user.getFine());

        //calling the api
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                //hiding progress dialog
                progressDialog.dismiss();

                //displaying the message from the response as toast
                Toast.makeText(getApplicationContext(), response.message(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }
    public boolean validation() {
        String name =mName.getText().toString().trim();
        CharSequence phone =mPhone.getText().toString().trim();
        String email =mEmail.getText().toString().trim();
        String password =mPassword.getText().toString().trim();
        if(name.equals(""))
        {
            Toast.makeText(getApplicationContext(),"Name must not be empty",Toast.LENGTH_LONG).show();
        }
        else if(phone.equals(""))
        {
            Toast.makeText(getApplicationContext(),"phone must not be empty",Toast.LENGTH_LONG).show();
        }
        else if(phone.length() > 10 || phone.length() < 10)
        {
            Toast.makeText(getApplicationContext(),"Enter 10 digit mobile number",Toast.LENGTH_LONG).show();
        }
        else if(email.equals(""))
        {
            Toast.makeText(getApplicationContext(),"Email must not be empty",Toast.LENGTH_LONG).show();
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            Toast.makeText(getApplicationContext(),"Enter Valid Email Id",Toast.LENGTH_LONG).show();
        }
        else if(password.equals(""))
        {
            Toast.makeText(getApplicationContext(),"Password must not be empty",Toast.LENGTH_LONG).show();
        }

        return true;
    }
}





