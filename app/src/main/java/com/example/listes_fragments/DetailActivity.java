package com.example.listes_fragments;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView countryFlagImageView = findViewById(R.id.countryFlagImageView);
        TextView countryNameTextView = findViewById(R.id.countryNameTextView);
        TextView capitalTextView = findViewById(R.id.capitalTextView);
        TextView populationTextView = findViewById(R.id.populationTextView);
        TextView regionTextView = findViewById(R.id.regionTextView);

        Country country = (Country) getIntent().getSerializableExtra("country");

        if (country != null) {
            countryFlagImageView.setImageResource(country.getFlagResource());
            countryNameTextView.setText(country.getName());
            capitalTextView.setText("Capitale : " + country.getCapital());
            populationTextView.setText(country.getPopulation());
            regionTextView.setText(country.getRegion());
        }
    }
}