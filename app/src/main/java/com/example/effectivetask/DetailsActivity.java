package com.example.effectivetask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    static AppCompatButton addToCartDetails;
    static RatingBar ratingBarDetails;
    static TextView productTitleDetails;
    static AppCompatButton color1Details;
    static AppCompatButton color2Details;
    static ImageView imageProduct0Details;
    static ImageView imageProduct1Details;
    Button backToMain;
    Button toCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        backToMain = findViewById(R.id.backToMain);
        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        toCard = findViewById(R.id.toCard);
        toCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailsActivity.this, CardActivity.class);
                startActivity(intent);
            }
        });

        addToCartDetails = findViewById(R.id.addToCartDetails);
        ratingBarDetails = findViewById(R.id.ratingBarDetails);
        productTitleDetails = findViewById(R.id.productTitleDetails);
        color1Details = findViewById(R.id.color1Details);
        color2Details = findViewById(R.id.color2Details);
        imageProduct0Details = findViewById(R.id.imageProduct0Details);
        imageProduct1Details = findViewById(R.id.imageProduct1Details);

        String url = "https://run.mocky.io/v3/6c14c560-15c6-4248-b9d2-b4508df7d4f5";
        new GetUrlDataDetails().execute(url);



    }
}