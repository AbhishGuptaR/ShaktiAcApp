package com.example.android.shaktiautocomponents;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ForgetPasswordPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password_page);
    }
    public void forgetPassword(View view){

        EditText foemail = (EditText) findViewById(R.id.forgetemail);

        MyDb myDb = new MyDb(this);
        SQLiteDatabase sqLiteDatabase = myDb.getReadableDatabase();

        String[] coloumns = {"email"};
        String[] cvalues = {foemail.getText().toString()};

        Cursor cursor = sqLiteDatabase.query("signup",coloumns,"email=?",cvalues,null,null,null);
        if(cursor!=null){
            if(cursor.moveToFirst()){
                Intent i = new Intent(this,ResetPasswordPage.class);
                i.putExtra("Email",foemail.getText().toString());
                startActivity(i);
            }
            else{
                Toast.makeText(this,"Email Doesn't Exists!",Toast.LENGTH_LONG).show();
            }
        }

    }
}
