package com.example.listes_fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CountryAdapter adapter;
    private List<Country> countryList;
    private CircularProgressIndicator progressIndicator;
    private TextInputLayout searchLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        progressIndicator = findViewById(R.id.progressIndicator);
        searchLayout = findViewById(R.id.searchLayout);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Remplir la liste des pays
        countryList = new ArrayList<>();
        countryList.add(new Country("France", "Paris", R.drawable.france_flag, "67 000 000", "Europe"));
        countryList.add(new Country("USA", "Washington D.C.", R.drawable.usa_flag, "331 000 000", "Amérique du Nord"));
        countryList.add(new Country("Japon", "Tokyo", R.drawable.japan_flag, "126 000 000", "Asie"));
        countryList.add(new Country("Maroc", "Rabat", R.drawable.morocco_flag, "37 000 000", "Afrique"));

        adapter = new CountryAdapter(this, countryList);
        recyclerView.setAdapter(adapter);

        // Masquer la barre de progression une fois les données chargées
        progressIndicator.setVisibility(View.GONE);

        // Gérer la recherche
        searchLayout.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }
}