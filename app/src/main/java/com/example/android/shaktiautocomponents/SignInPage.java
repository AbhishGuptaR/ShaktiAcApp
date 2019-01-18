package com.example.android.shaktiautocomponents;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignInPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_page);
    }
    public void onForget(View view){
        Intent i = new Intent(this,ForgetPasswordPage.class);
        startActivity(i);
    }

    public void signIn(View view){

        EditText siemail = (EditText) findViewById(R.id.signinemail);
        EditText sipass = (EditText) findViewById(R.id.signinpassword);

        MyDb myDb = new MyDb(this);
        SQLiteDatabase sqLiteDatabase = myDb.getReadableDatabase();

        String[] coloumns = {"email","pass"};
        String[] siValues = {siemail.getText().toString(),sipass.getText().toString()};

        Cursor cursor = sqLiteDatabase.query("signup",coloumns,"email = ? AND pass = ?",siValues,null,null,null);
        if(cursor!=null){
            if(cursor.moveToFirst()){
                Intent i = new Intent(this,MenuPage.class);
                startActivity(i);
                SignInPage.this.finish();
            }
            else{
                Toast.makeText(this,"Invalid Account Credentials!",Toast.LENGTH_LONG).show();
            }
        }

    }
}
