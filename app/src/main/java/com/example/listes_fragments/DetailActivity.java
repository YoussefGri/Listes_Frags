package com.example.listes_fragments;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DetailActivity extends AppCompatActivity {

    private ImageView countryFlagImageView;
    private TextView countryNameTextView, capitalTextView, populationTextView, regionTextView;
    private FloatingActionButton shareButton;
    private Country country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        countryFlagImageView = findViewById(R.id.countryFlagImageView);
        countryNameTextView = findViewById(R.id.countryNameTextView);
        capitalTextView = findViewById(R.id.capitalTextView);
        populationTextView = findViewById(R.id.populationTextView);
        regionTextView = findViewById(R.id.regionTextView);
        shareButton = findViewById(R.id.shareButton);

        // Récupérer l'objet Country envoyé par intent
        country = (Country) getIntent().getSerializableExtra("country");

        if (country != null) {
            countryFlagImageView.setImageResource(country.getFlagResource());
            countryNameTextView.setText(country.getName());
            capitalTextView.setText(country.getCapital());
            populationTextView.setText(country.getPopulation());
            regionTextView.setText(country.getRegion());

            // partage
            shareButton.setOnClickListener(v -> shareCountryInfo());
        }
    }

    private void shareCountryInfo() {
        String shareText = " 🌏 " + getString(R.string.discover) + country.getName() + " !\n\n"
                + "🏛 " + getString(R.string.capital)+ " : " + country.getCapital() + "\n"
                + "👥 " + getString(R.string.population) + " : " + country.getPopulation() + "\n"
                + "📍 " + getString(R.string.region)+ " : "+ country.getRegion() + "\n\n"
                + "📲 " + getString(R.string.shared_via);

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);
        startActivity(Intent.createChooser(shareIntent, getString(R.string.share_via)));
    }
}
