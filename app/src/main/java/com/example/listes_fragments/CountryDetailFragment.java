package com.example.listes_fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CountryDetailFragment extends Fragment {

    private ImageView countryFlagImageView;
    private TextView countryNameTextView, capitalTextView, populationTextView, regionTextView;
    private FloatingActionButton shareButton;
    private Country country;

    public static CountryDetailFragment newInstance(Country country) {
        CountryDetailFragment fragment = new CountryDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable("country", country);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_country_detail, container, false);

        countryFlagImageView = view.findViewById(R.id.countryFlagImageView);
        countryNameTextView = view.findViewById(R.id.countryNameTextView);
        capitalTextView = view.findViewById(R.id.capitalTextView);
        populationTextView = view.findViewById(R.id.populationTextView);
        regionTextView = view.findViewById(R.id.regionTextView);
        shareButton = view.findViewById(R.id.shareButton);

        if (getArguments() != null) {
            country = (Country) getArguments().getSerializable("country");

            if (country != null) {
                countryFlagImageView.setImageResource(country.getFlagResource());
                countryNameTextView.setText(country.getName());
                capitalTextView.setText(country.getCapital());
                populationTextView.setText(country.getPopulation());
                regionTextView.setText(country.getRegion());

                // Associer la fonction de partage au bouton
                shareButton.setOnClickListener(v -> shareCountryInfo());
            }
        }

        return view;
    }

    //Partage les informations du pays sélectionné via différentes applications.

    private void shareCountryInfo() {
        if (country == null) return; // Vérifier si le pays est bien chargé

        String shareText = " 🌏 " + getString(R.string.discover) + country.getName() + " !\n\n"
                + "🏛 " + getString(R.string.capital) + country.getCapital() + "\n"
                + "👥 " + getString(R.string.population) + country.getPopulation() + "\n"
                + "📍 " + getString(R.string.region) + country.getRegion() + "\n\n"
                + "📲 " + getString(R.string.shared_via);

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);

        // Ouvre le menu de partage natif
        startActivity(Intent.createChooser(shareIntent, getString(R.string.share_via)));
    }
}
