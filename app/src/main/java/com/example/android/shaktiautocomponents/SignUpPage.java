package com.example.android.shaktiautocomponents;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
    }

    public void signUp(View view){


        EditText name = (EditText) findViewById(R.id.signupname);
        EditText email = (EditText) findViewById(R.id.signupemail);
        EditText pass = (EditText) findViewById(R.id.signuppassword);

        String suname = name.getText().toString();
        String suemail = email.getText().toString();
        String supass = pass.getText().toString();

        MyDb myDb = new MyDb(this);
        SQLiteDatabase sqLiteDatabase = myDb.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name",suname);
        values.put("email",suemail);
        values.put("pass",supass);

        sqLiteDatabase.insert("signup",null,values);
        Toast.makeText(this,"Account Created!",Toast.LENGTH_LONG).show();
        Intent i = new Intent(SignUpPage.this,SignInPage.class);
        startActivity(i);
        SignUpPage.this.finish();


    }

    public void onsignIn(View view){
        Intent i = new Intent(SignUpPage.this,SignInPage.class);
        startActivity(i);
        SignUpPage.this.finish();
    }
}
