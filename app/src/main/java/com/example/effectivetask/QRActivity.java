//TESTS

package com.example.effectivetask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class QRActivity extends AppCompatActivity {
    //0
    AppCompatButton qradd;
    List<View> allEds;

    //1
    ProgressBar progressbarQR1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qractivity);
        //0

        qradd = findViewById(R.id.qradd);
        allEds = new ArrayList<View>();

        final LinearLayout qrlinear = (LinearLayout) findViewById(R.id.qrlinear);

        qradd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View view = getLayoutInflater().inflate(R.layout.custom_layout0, null);//custom layout
                Button deleteField = (Button) view.findViewById(R.id.button2);
                EditText text = (EditText) view.findViewById(R.id.editText);
                text.setText("Some text");
                allEds.add(view);//add to list
                qrlinear.addView(view);//add to page
            }
        });
        //Delete
        /*Button deleteField = (Button) view.findViewById(R.id.button2);
        deleteField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //получаем родительский view и удаляем его
                    ((LinearLayout) view.getParent()).removeView(view);
                    //удаляем эту же запись из массива что бы не оставалось мертвых записей
                    allEds.remove(view);
                } catch(IndexOutOfBoundsException ex) {
                    ex.printStackTrace();
                }
            }
        });*/





        //1
        progressbarQR1 = findViewById(R.id.progressbarQR1);
        //QR1Background QR1 = new QR1Background();
        //QR1.execute();
        new QR1Background().execute();


    }
    //1
    class QR1Background extends AsyncTask<Void, Void, Void>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressbarQR1.setVisibility(View.VISIBLE);
        }
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            progressbarQR1.setVisibility(View.INVISIBLE);
        }
    }
}