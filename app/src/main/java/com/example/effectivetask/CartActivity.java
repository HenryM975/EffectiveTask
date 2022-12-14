package com.example.effectivetask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CartActivity extends AppCompatActivity {

    Button backToDetails;
    static TextView cardTotal1;
    static TextView cardDelivery1;
    static ImageView element0ImgCart;
    static TextView element0TitleCart;
    static TextView element0PriceCart;
    static ImageView element1ImgCart;
    static TextView element1TitleCart;
    static TextView element1PriceCart;

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
        element0ImgCart = findViewById(R.id.element0ImgCart);
        element0TitleCart = findViewById(R.id.element0TitleCart);
        element0PriceCart = findViewById(R.id.element0PriceCart);
        element1ImgCart = findViewById(R.id.element1ImgCart);
        element1TitleCart = findViewById(R.id.element1TitleCart);
        element1PriceCart = findViewById(R.id.element1PriceCart);



        String url = "https://run.mocky.io/v3/53539a72-3c5f-4f30-bbb1-6ca10d42c149";
        new GetUrlDataCart().execute(url);
        //?
        /*GetUrlDataCart GUDC = new GetUrlDataCart();
        GUDC.execute(url);
        try {
            JSONObject obj = new JSONObject(GUDC.get());
            CartActivity.cardDelivery1.setText((String) obj.get("delivery"));
            CartActivity.cardTotal1.setText((obj.get("total")).toString());
            JSONArray elementList = (JSONArray) obj.get("basket");
            CartActivity.element0PriceCart.setText("nujnhujbhkbghk");
            //0
            JSONObject element0 = (JSONObject) elementList.get(0);
            Picasso.get()
                    .load((String) element0.get("images"))
                    .into(CartActivity.element0ImgCart);
            CartActivity.element0TitleCart.setText((String) element0.get("title"));
            CartActivity.element0PriceCart.setText((element0.get("price")).toString());
            //1
            JSONObject element1 = elementList.getJSONObject(1);
            Picasso.get()
                    .load((String) element1.get("images"))
                    .into(CartActivity.element1ImgCart);
            CartActivity.element1TitleCart.setText((String) element1.get("title"));
            CartActivity.element1PriceCart.setText((element1.get("price")).toString());

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
}