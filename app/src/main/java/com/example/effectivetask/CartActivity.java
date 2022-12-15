package com.example.effectivetask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CartActivity extends AppCompatActivity {

    Button backToDetails;
    static TextView cardTotal1;
    static TextView cardDelivery1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);


        backToDetails = findViewById(R.id.backToDetails);
        backToDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CartActivity.this, DetailsActivity.class);
                startActivity(intent);
            }
        });

        cardTotal1 = findViewById(R.id.cardTotal1);
        cardDelivery1 = findViewById(R.id.cardDelivery1);

        //String url = "https://run.mocky.io/v3/6c14c560-15c6-4248-b9d2-b4508df7d4f5";
        //new GetUrlDataCart.execute(url);
    }
}