package com.example.android.shaktiautocomponents;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ResetPasswordPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password_page);
    }
    public void resetPassword(View view){
        String email = getIntent().getStringExtra("Email").toString();
        EditText pass = (EditText) findViewById(R.id.resetpassword);
        EditText repass = (EditText) findViewById(R.id.resetrepassword);

        MyDb myDb = new MyDb(this);
        SQLiteDatabase sqLiteDatabase = myDb.getWritableDatabase();

        Log.e("pass",pass.getText().toString());
        Log.e("repass",repass.getText().toString());

        ContentValues values = new ContentValues();
        values.put("pass",pass.getText().toString());

        if((pass.getText().toString()).equals(repass.getText().toString())){
            sqLiteDatabase.update("signup",values, "email='"+email+"'",null);
            Intent i = new Intent(this,SignInPage.class);
            startActivity(i);
            ResetPasswordPage.this.finish();
        }
        else{
            Toast.makeText(this,"Passwords Dont Match!",Toast.LENGTH_LONG).show();
        }


    }
}
