package com.example.listes_fragments;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private TextView countryNameTextView, capitalTextView;
    private ImageView countryFlagImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        countryNameTextView = findViewById(R.id.countryNameTextView);
        capitalTextView = findViewById(R.id.capitalTextView);
        countryFlagImageView = findViewById(R.id.countryFlagImageView);

        // Récupérer l'objet `Country` depuis l'intent
        Country country = (Country) getIntent().getSerializableExtra("country");

        if (country != null) {
            countryNameTextView.setText(country.getName());
            capitalTextView.setText("Capitale : " + country.getCapital());
            countryFlagImageView.setImageResource(country.getFlagResource());
        }
    }
}
