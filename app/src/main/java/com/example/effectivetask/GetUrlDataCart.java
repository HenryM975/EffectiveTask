package com.example.effectivetask;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Target;
import com.squareup.picasso.Transformation;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetUrlDataCart extends AsyncTask<String, String, String>{

    @Override
    protected String doInBackground(String... strings) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(strings[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            InputStream stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));

            StringBuffer buffer = new StringBuffer();
            String line = "";

            while ((line = reader.readLine()) != null) {
                buffer.append(line).append("\n");
            }
            return buffer.toString();
        } catch (MalformedURLException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (connection != null)
                connection.disconnect();

            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        try {
            JSONObject obj = new JSONObject(result);
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
        }


    }

}