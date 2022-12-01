package com.example.effectivetask;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.Toast;

public class FilterActivity extends AppCompatActivity {
    Spinner filterBrandSpinner;
    Spinner filterPriceSpinner;
    Spinner filterSizeSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter_options);

        filterBrandSpinner = findViewById(R.id.filterBrandSpinner);
        String selected = filterBrandSpinner.getSelectedItem().toString();
        Toast.makeText(getApplicationContext(), selected, Toast.LENGTH_SHORT).show();

        filterPriceSpinner = findViewById(R.id.filterPriceSpinner);
        String selected1 = filterBrandSpinner.getSelectedItem().toString();
        Toast.makeText(getApplicationContext(), selected1, Toast.LENGTH_SHORT).show();

        filterSizeSpinner = findViewById(R.id.filterSizeSpinner);
        String selected2 = filterBrandSpinner.getSelectedItem().toString();
        Toast.makeText(getApplicationContext(), selected2, Toast.LENGTH_SHORT).show();
    }


}