package com.upwork.radio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Setting extends AppCompatActivity {

    static  int ThemeID=0;
    static  int Language=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        Button theme1= (Button)findViewById(R.id.theme1);
        theme1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThemeID=1;
            }
        });


        Button theme2= (Button)findViewById(R.id.theme2);
        theme2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThemeID=2;
            }
        });

        Button arabic= (Button)findViewById(R.id.Arabic);
        arabic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Language=2;
            }
        });


        Button english= (Button)findViewById(R.id.English);
        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Language=1;
            }
        });



        Button Ok= (Button)findViewById(R.id.Okey);
        Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Setting.this , First.class);
                startActivity(i);
            }
        });


    }
}
