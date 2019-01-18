package com.example.android.shaktiautocomponents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

public class MenuPage extends AppCompatActivity {

    GridLayout gridLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_page);

        gridLayout = (GridLayout) findViewById(R.id.gridlayout);
        setSingleEvent(gridLayout);
    }

    public void setSingleEvent(GridLayout gridLayout){
        for(int i=0;i<gridLayout.getChildCount();i++){
            CardView cardview = (CardView)gridLayout.getChildAt(i);
            cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MenuPage.this,"This Feature will be implemented in future versions!",Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
