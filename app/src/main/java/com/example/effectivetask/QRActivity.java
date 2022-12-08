package com.example.effectivetask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class QRActivity extends AppCompatActivity {

    AppCompatButton qradd;
    List<View> allEds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qractivity);

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


    }
}