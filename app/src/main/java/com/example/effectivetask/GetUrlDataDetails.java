package com.example.effectivetask;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
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

public class GetUrlDataDetails extends AsyncTask<String, String, String>{

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
            DetailsActivity.addToCartDetails.setText((obj.get("price")).toString());
            DetailsActivity.ratingBarDetails.setRating(((Double) obj.get("rating")).floatValue());
            DetailsActivity.productTitleDetails.setText((String) obj.get("title"));
            JSONArray colorList = (JSONArray) obj.get("color");
            DetailsActivity.color1Details.setBackgroundColor(Color.parseColor((String) colorList.get(0)));
            DetailsActivity.color2Details.setBackgroundColor(Color.parseColor((String) colorList.get(1)));
            JSONArray imageList = (JSONArray) obj.get("images");
            Picasso.get()
                    .load((String)imageList.get(0))
                    .into(DetailsActivity.imageProduct0Details);
            Picasso.get()
                    .load("https://img.ibxk.com.br/2020/09/23/23104013057475.jpg?w=1120&h=420&mode=crop&scale=both")
                    .into(DetailsActivity.imageProduct0Details);

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

}


