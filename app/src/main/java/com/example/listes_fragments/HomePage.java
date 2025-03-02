package com.example.listes_fragments;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.card.MaterialCardView;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        MaterialCardView cardActivityVersion = findViewById(R.id.cardActivityVersion);
        MaterialCardView cardFragmentVersion = findViewById(R.id.cardFragmentVersion);

        // Bouton pour lancer la version avec Activités
        cardActivityVersion.setOnClickListener(v -> {
            Intent intent = new Intent(HomePage.this, MainActivity.class);
            startActivity(intent);
        });

        // Bouton pour lancer la version avec Fragments
        cardFragmentVersion.setOnClickListener(v -> {
            Intent intent = new Intent(HomePage.this, FragmentMainActivity.class);
            startActivity(intent);
        });
    }
}