package com.printhub.printhub.WebServices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.printhub.printhub.R;

public class MainActivityWeb extends AppCompatActivity {
    private Button zomato,dominos,ola,redbus,udemy,twitter;
    private String link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_web2);
        zomato=findViewById(R.id.zomato);
        dominos=findViewById(R.id.dominos);
        ola=findViewById(R.id.ola);
        redbus=findViewById(R.id.redbus);
        udemy=findViewById(R.id.udemy);
        twitter=findViewById(R.id.twitter);

        zomato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                link = "https://www.zomato.com/india";
                Intent i = new Intent(getApplicationContext(), WebViewActivity.class);
                i.putExtra("Link", link);
                startActivity(i);
            }
        });

        dominos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                link = "https://www.dominos.co.in/";
                Intent i = new Intent(getApplicationContext(), WebViewActivity.class);
                i.putExtra("Link", link);
                startActivity(i);


            }
        });

        ola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                link = "https://www.olacabs.com/";
                Intent i = new Intent(getApplicationContext(), WebViewActivity.class);
                i.putExtra("Link", link);
                startActivity(i);

            }
        });

        redbus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                link = "https://www.redbus.in/";
                Intent i = new Intent(getApplicationContext(), WebViewActivity.class);
                i.putExtra("Link", link);
                startActivity(i);

            }
        });

        udemy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                link = "https://www.udemy.com/";
                Intent i = new Intent(getApplicationContext(), WebViewActivity.class);
                i.putExtra("Link", link);
                startActivity(i);

            }
        });

        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                link = "https://twitter.com/?lang=en";
                Intent i = new Intent(getApplicationContext(), WebViewActivity.class);
                i.putExtra("Link", link);
                startActivity(i);

            }
        });

    }
}