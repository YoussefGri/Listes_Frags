package com.example.listes_fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textfield.TextInputEditText;
import java.util.ArrayList;
import java.util.List;

public class CountryListFragment extends Fragment {

    private RecyclerView recyclerView;
    private CountryAdapter adapter;
    private List<Country> countryList;
    private TextInputLayout searchLayout;
    private TextInputEditText searchEditText;
    private OnCountrySelectedListener listener;

    public interface OnCountrySelectedListener {
        void onCountrySelected(Country country);
    }

    public void setOnCountrySelectedListener(OnCountrySelectedListener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_country_list, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        searchLayout = view.findViewById(R.id.searchLayout);
        searchEditText = view.findViewById(R.id.searchEditText);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // ✅ Remplir la liste des pays
        countryList = new ArrayList<>();
        countryList.add(new Country("France", "Paris", R.drawable.france_flag, "67 000 000", "Europe"));
        countryList.add(new Country("USA", "Washington D.C.", R.drawable.usa_flag, "331 000 000", "Amérique du Nord"));
        countryList.add(new Country("Japon", "Tokyo", R.drawable.japan_flag, "126 000 000", "Asie"));
        countryList.add(new Country("Maroc", "Rabat", R.drawable.morocco_flag, "37 000 000", "Afrique"));

        // ✅ Passer le `listener` correctement
        adapter = new CountryAdapter(getContext(), countryList, listener);
        recyclerView.setAdapter(adapter);

        // ✅ Gérer la recherche
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        return view;
    }
}
