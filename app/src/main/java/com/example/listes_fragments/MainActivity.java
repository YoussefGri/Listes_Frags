package com.example.listes_fragments;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CountryAdapter adapter;
    private List<Country> countryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Remplir la liste des pays
        countryList = new ArrayList<>();
        countryList.add(new Country("France", "Paris", R.drawable.france_flag));
        countryList.add(new Country("USA", "Washington D.C.", R.drawable.usa_flag));
        countryList.add(new Country("Japon", "Tokyo", R.drawable.japan_flag));
        countryList.add(new Country("Maroc", "Rabat", R.drawable.morocco_flag));

        adapter = new CountryAdapter(this, countryList);
        recyclerView.setAdapter(adapter);
    }
}
