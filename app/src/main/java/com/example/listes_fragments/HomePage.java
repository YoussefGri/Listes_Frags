package com.example.listes_fragments;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        MaterialButton btnActivityVersion = findViewById(R.id.btnActivityVersion);
        MaterialButton btnFragmentVersion = findViewById(R.id.btnFragmentVersion);

        // Bouton pour lancer la version avec Activités
        btnActivityVersion.setOnClickListener(v -> {
            Intent intent = new Intent(HomePage.this, MainActivity.class);
            startActivity(intent);
        });

        // Bouton pour lancer la version avec Fragments
        btnFragmentVersion.setOnClickListener(v -> {
            Intent intent = new Intent(HomePage.this, FragmentMainActivity.class);
            startActivity(intent);
        });
    }
}
