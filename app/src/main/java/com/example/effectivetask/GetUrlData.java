package com.example.effectivetask;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Target;

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

public class GetUrlData extends AsyncTask<String, String, String> {

    protected void onPreExecute() {
        super.onPreExecute();
    }
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
    protected void onPostExecute(String result){
        super.onPostExecute(result);
        try {
            JSONObject obj = new JSONObject(result); //сделать статик и распарсить из main мб поможет.
            //hot sales:
            JSONArray val = (JSONArray) obj.get("home_store");
            //for(int i=0; i<val.length(); i++)//for(Object part : val)MainActivity.apitest.setText(val.get(i).toString());//new StringBuilder().append(val).toString()
            //0
            JSONObject objhotsales0 = (JSONObject)val.get(0);
            MainActivity.hotsalesname0.setText((String) objhotsales0.get("title"));
            MainActivity.hotsalessubtitle0.setText((String) objhotsales0.get("subtitle"));
            try{objhotsales0.get("is_new");
                MainActivity.hotsalesnew0.setBackgroundResource(R.drawable.bncategoryon);
                MainActivity.hotsalesnew0.setText("New");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if((Boolean) objhotsales0.get("is_buy")){
                MainActivity.hotsalesbuy0.setBackgroundResource(R.drawable.whitebutton);
            }
            //1
            JSONObject objhotsales1 = (JSONObject)val.get(1);
            MainActivity.hotsalesname1.setText((String) objhotsales1.get("title"));
            MainActivity.hotsalessubtitle1.setText((String) objhotsales1.get("subtitle"));
            try{objhotsales1.get("is_new");
                MainActivity.hotsalesnew1.setBackgroundResource(R.drawable.bncategoryon);
                MainActivity.hotsalesnew1.setText("New");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if((Boolean) objhotsales0.get("is_buy")){
                MainActivity.hotsalesbuy1.setBackgroundResource(R.drawable.whitebutton);
            }
            //2
            JSONObject objhotsales2 = (JSONObject)val.get(2);
            MainActivity.hotsalesname2.setText((String) objhotsales2.get("title"));
            MainActivity.hotsalessubtitle2.setText((String) objhotsales2.get("subtitle"));
            try {
                objhotsales2.get("is_new");
                MainActivity.hotsalesnew2.setBackgroundResource(R.drawable.bncategoryon);
                MainActivity.hotsalesnew2.setText("New");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if((Boolean) objhotsales0.get("is_buy")){
                MainActivity.hotsalesbuy2.setBackgroundResource(R.drawable.whitebutton);
            }
            //+img
            try {
                RequestCreator image =null;
                URL url = new URL("https://img.ibxk.com.br/2020/09/23/23104013057475.jpg?w=1120&h=420&mode=crop&scale=both");
                //Picasso.get()
                        //.load("https://img.ibxk.com.br/2020/09/23/23104013057475.jpg?w=1120&h=420&mode=crop&scale=both")//!!!
                        //.fit()
                        //.into((Target) MainActivity.hotsaleslayout0);
                        //.into((Target) MainActivity.hotsaleslayout0);не робит
                        //.into(MainActivity.imageViewQrTest); //робит
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            //best seller:
            JSONArray val0 = (JSONArray) obj.get("best_seller");
            //0
            JSONObject objbestseller0 = (JSONObject)val0.get(0);
            MainActivity.bestSeller0title.setText((String) objbestseller0.get("title"));
            MainActivity.bestSeller0price.setText((objbestseller0.get("discount_price")).toString());
            MainActivity.bestSeller0oldprice.setText((objbestseller0.get("price_without_discount")).toString());
            //"is_favorites"?
            //1
            JSONObject objbestseller1 = (JSONObject)val0.get(1);
            MainActivity.bestSeller1title.setText((String) objbestseller1.get("title"));
            MainActivity.bestSeller1price.setText((objbestseller1.get("discount_price")).toString());
            MainActivity.bestSeller1oldprice.setText((objbestseller1.get("price_without_discount")).toString());
            //2
            JSONObject objbestseller2 = (JSONObject)val0.get(2);
            MainActivity.bestSeller2title.setText((String) objbestseller2.get("title"));
            MainActivity.bestSeller2price.setText((objbestseller2.get("discount_price")).toString());
            MainActivity.bestSeller2oldprice.setText((objbestseller2.get("price_without_discount")).toString());
            //3
            JSONObject objbestseller3 = (JSONObject)val0.get(3);
            MainActivity.bestSeller3title.setText((String) objbestseller3.get("title"));
            MainActivity.bestSeller3price.setText((objbestseller3.get("discount_price")).toString());
            MainActivity.bestSeller3oldprice.setText((objbestseller3.get("price_without_discount")).toString());
            //+img+- change size

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
