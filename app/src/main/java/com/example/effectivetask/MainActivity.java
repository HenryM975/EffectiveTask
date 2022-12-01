package com.example.effectivetask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity{

    //filter
    AppCompatButton filter;
    Dialog dialog;

    //best seller
    ImageButton phone4;
    AppCompatButton phone4LikeButton;
    //Category
    AppCompatButton Category0button;
    AppCompatButton Category1button;
    AppCompatButton Category2button;
    AppCompatButton Category3button;
    AppCompatButton Category4button;
    //apitest
    //static TextView apitest;
    //hot sales
    static TextView hotsalesname0;
    static TextView hotsalessubtitle0;
    static AppCompatButton hotsalesnew0;
    static AppCompatButton hotsalesbuy0;
    static TextView hotsalesname1;
    static TextView hotsalessubtitle1;
    static AppCompatButton hotsalesnew1;
    static AppCompatButton hotsalesbuy1;
    static TextView hotsalesname2;
    static TextView hotsalessubtitle2;
    static AppCompatButton hotsalesnew2;
    static AppCompatButton hotsalesbuy2;
    //filter
    AppCompatButton filerBackToMain;
    //Spinner brandspinner;
    //best seller
    //static TextView bestSeller0title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        filter = findViewById(R.id.filter_button);
        dialog = new Dialog(MainActivity.this);
        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFilterDialog();
            }
        });

        phone4 = findViewById(R.id.bestSeller0imgbn);
        phone4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                startActivity(intent);
            }
        });

        Category0button = findViewById(R.id.Category0button);
        Category1button = findViewById(R.id.Category1button);
        Category2button = findViewById(R.id.Category2button);
        Category3button = findViewById(R.id.Category3button);
        Category4button = findViewById(R.id.Category4button);
        //1
        Category0button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Category0button.setBackgroundResource(R.drawable.bncategoryon);
                Category1button.setBackgroundResource(R.drawable.bncategoryoff);
                Category2button.setBackgroundResource(R.drawable.bncategoryoff);
                Category3button.setBackgroundResource(R.drawable.bncategoryoff);
                Category4button.setBackgroundResource(R.drawable.bncategoryoff);
            }
        });
        Category1button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Category0button.setBackgroundResource(R.drawable.bncategoryoff);
                Category1button.setBackgroundResource(R.drawable.bncategoryon);
                Category2button.setBackgroundResource(R.drawable.bncategoryoff);
                Category3button.setBackgroundResource(R.drawable.bncategoryoff);
                Category4button.setBackgroundResource(R.drawable.bncategoryoff);
            }
        });
        Category2button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Category0button.setBackgroundResource(R.drawable.bncategoryoff);
                Category1button.setBackgroundResource(R.drawable.bncategoryoff);
                Category2button.setBackgroundResource(R.drawable.bncategoryon);
                Category3button.setBackgroundResource(R.drawable.bncategoryoff);
                Category4button.setBackgroundResource(R.drawable.bncategoryoff);
            }
        });
        Category3button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Category0button.setBackgroundResource(R.drawable.bncategoryoff);
                Category1button.setBackgroundResource(R.drawable.bncategoryoff);
                Category2button.setBackgroundResource(R.drawable.bncategoryoff);
                Category3button.setBackgroundResource(R.drawable.bncategoryon);
                Category4button.setBackgroundResource(R.drawable.bncategoryoff);
            }
        });
        Category4button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Category0button.setBackgroundResource(R.drawable.bncategoryoff);
                Category1button.setBackgroundResource(R.drawable.bncategoryoff);
                Category2button.setBackgroundResource(R.drawable.bncategoryoff);
                Category3button.setBackgroundResource(R.drawable.bncategoryoff);
                Category4button.setBackgroundResource(R.drawable.bncategoryon);
            }
        });

        phone4LikeButton = findViewById(R.id.bestSeller0LikeButton);
        phone4LikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //phone4LikeButton.setCompoundDrawables(R.drawable.likeoff);
            }
        });


        //apitest
        //apitest = findViewById(R.id.apitest);


        //hotsales
        String url = "https://run.mocky.io/v3/654bd15e-b121-49ba-a588-960956b15175";
        new GetUrlData().execute(url);
        //0
        hotsalesname0 = findViewById(R.id.hotsalesname0);
        hotsalessubtitle0 = findViewById(R.id.hotsalessubtitle0);
        hotsalesnew0 = findViewById(R.id.hotsalesnew0);
        hotsalesbuy0 = findViewById(R.id.hotsalesbuy0);
        //1
        hotsalesname1 = findViewById(R.id.hotsalesname1);
        hotsalessubtitle1 = findViewById(R.id.hotsalessubtitle1);
        hotsalesnew1 = findViewById(R.id.hotsalesnew1);
        hotsalesbuy1 = findViewById(R.id.hotsalesbuy1);
        //2
        hotsalesname2 = findViewById(R.id.hotsalesname2);
        hotsalessubtitle2 = findViewById(R.id.hotsalessubtitle2);
        hotsalesnew2 = findViewById(R.id.hotsalesnew2);
        hotsalesbuy2 = findViewById(R.id.hotsalesbuy2);



        //filter
        filerBackToMain = findViewById(R.id.filterbackToMain);
        //brand???



        //best seller
        //bestSeller0title = findViewById(R.id.bestSeller0title);



        //filerSpinners




    }


    private void showFilterDialog() {
        dialog.setContentView(R.layout.filter_options);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(true);
        dialog.show();
        //dialog.dismiss();
    }

}