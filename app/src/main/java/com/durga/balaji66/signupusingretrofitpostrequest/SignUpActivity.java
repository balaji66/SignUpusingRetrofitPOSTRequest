package com.durga.balaji66.signupusingretrofitpostrequest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText mName, mPhone, mEmail, mPassword;
    private Button mSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                break;
        }
    }
    public void validation() {
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

    }
}





