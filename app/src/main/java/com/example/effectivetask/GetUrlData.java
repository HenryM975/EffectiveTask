//apitest
package com.example.effectivetask;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;

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
            if((Boolean) objhotsales0.get("is_new")){
                //MainActivity.hotsalesnew0.setBackground(Drawable.createFromPath("@drawable/bncategoryon"));
                MainActivity.hotsalesnew0.setText("New");
            }
            //if((Boolean) objhotsales0.get("is_buy")){
            //    MainActivity.hotsalesbuy0.getResources().getDrawable(R.color.white1);//setBackground(Drawable.createFromPath("@color/white1"));//(Drawable.createFromPath("#f8f8f8"));
            //}
            //1
            JSONObject objhotsales1 = (JSONObject)val.get(1);
            MainActivity.hotsalesname1.setText((String) objhotsales1.get("title"));
            MainActivity.hotsalessubtitle1.setText((String) objhotsales1.get("subtitle"));
            if((Boolean) objhotsales1.get("is_new")){
                //MainActivity.hotsalesnew1.setBackground(Drawable.createFromPath("@drawable/bncategoryon"));
                MainActivity.hotsalesnew1.setText("New");
            }
            //if((Boolean) objhotsales1.get("is_buy")){
            //    MainActivity.hotsalesbuy1.getResources().getDrawable(R.color.white1);
            //}
            //2
            JSONObject objhotsales2 = (JSONObject)val.get(2);
            MainActivity.hotsalesname2.setText((String) objhotsales2.get("title"));
            MainActivity.hotsalessubtitle2.setText((String) objhotsales2.get("subtitle"));
            if((Boolean) objhotsales2.get("is_new")){
                //MainActivity.hotsalesnew2.setBackground(Drawable.createFromPath("@drawable/bncategoryon"));
                MainActivity.hotsalesnew2.setText("New");
            }
            //if((Boolean) objhotsales2.get("is_buy")){
            //    MainActivity.hotsalesbuy2.getResources().getDrawable(R.color.white1);
            //}


            //best seller:
            //JSONArray val1 = (JSONArray) obj.get("best_seller");
            //0
            //JSONObject objbestseller0 = (JSONObject)val.get(0);
            //MainActivity.bestSeller0title.setText((String) objbestseller0.get("title"));



        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
