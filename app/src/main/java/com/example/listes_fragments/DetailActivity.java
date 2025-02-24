package com.example.listes_fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

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
        FloatingActionButton shareButton = findViewById(R.id.shareButton);

        Country country = (Country) getIntent().getSerializableExtra("country");

        if (country != null) {
            countryFlagImageView.setImageResource(country.getFlagResource());
            countryNameTextView.setText(country.getName());
            capitalTextView.setText("Capitale : " + country.getCapital());
            populationTextView.setText("Population : " + country.getPopulation());
            regionTextView.setText("Région : " + country.getRegion());

            // Gérer le clic sur le bouton de partage
            shareButton.setOnClickListener(v -> shareCountryInfo(country));
        }
    }

    // Méthode pour partager les informations du pays
    private void shareCountryInfo(Country country) {
        String shareText = "Découvrez ce pays incroyable :\n\n"
                + "Nom : " + country.getName() + "\n"
                + "Capitale : " + country.getCapital() + "\n"
                + "Population : " + country.getPopulation() + "\n"
                + "Région : " + country.getRegion() + "\n\n"
                + "Partagé via l'application Pays du Monde.";

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);
        startActivity(Intent.createChooser(shareIntent, "Partager via"));
    }
}