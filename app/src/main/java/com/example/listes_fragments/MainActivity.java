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
        setContentView(R.layout.activity_country_list);

        recyclerView = findViewById(R.id.recyclerView);
        progressIndicator = findViewById(R.id.progressIndicator);
        searchLayout = findViewById(R.id.searchLayout);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        countryList = new ArrayList<>();
        countryList.add(new Country(getString(R.string.france), "Paris", R.drawable.france_flag, "67 000 000", getString(R.string.europe)));
        countryList.add(new Country(getString(R.string.usa), "Washington D.C.", R.drawable.usa_flag, "331 000 000", getString(R.string.north_america)));
        countryList.add(new Country(getString(R.string.japan), "Tokyo", R.drawable.japan_flag, "126 000 000", getString(R.string.asia)));
        countryList.add(new Country(getString(R.string.moroco), "Rabat", R.drawable.morocco_flag, "37 000 000", getString(R.string.africa)));

        adapter = new CountryAdapter(this, countryList);
        recyclerView.setAdapter(adapter);

        progressIndicator.setVisibility(View.GONE);

        //textWatcher pour la recherche
        searchLayout.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s); // Appliquer le filtre
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }
}
