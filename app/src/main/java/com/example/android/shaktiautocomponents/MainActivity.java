package com.example.android.shaktiautocomponents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void menuSignUp(View view){
        Intent i = new Intent(MainActivity.this,SignUpPage.class);
        startActivity(i);
        MainActivity.this.finish();
    }

    public void menuSignIn(View view){
        Intent i = new Intent(MainActivity.this,SignInPage.class);
        startActivity(i);
        MainActivity.this.finish();
    }
}
