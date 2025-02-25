package com.example.listes_fragments;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FragmentMainActivity extends AppCompatActivity implements CountryListFragment.OnCountrySelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_main);

        if (savedInstanceState == null) {
            CountryListFragment listFragment = new CountryListFragment();
            listFragment.setOnCountrySelectedListener(this);

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.fragment_container, listFragment);
            transaction.commit();
        }
    }

    @Override
    public void onCountrySelected(Country country) {
        CountryDetailFragment detailFragment = CountryDetailFragment.newInstance(country);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, detailFragment)
                .addToBackStack(null)
                .commit();
    }
}
