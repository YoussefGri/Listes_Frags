package com.example.listes_fragments;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> implements Filterable {

    private Context context;
    private List<Country> countryList;
    private List<Country> countryListFull;
    private CountryListFragment.OnCountrySelectedListener listener; // Peut être null pour la version activités

    // Constructeur pour les fragments (avec listener)
    public CountryAdapter(Context context, List<Country> countryList, CountryListFragment.OnCountrySelectedListener listener) {
        this.context = context;
        this.countryList = countryList;
        this.countryListFull = new ArrayList<>(countryList);
        this.listener = listener;
    }

    // ✅ Constructeur pour les activités (sans listener)
    public CountryAdapter(Context context, List<Country> countryList) {
        this(context, countryList, null); // Appelle le premier constructeur avec `listener = null`
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_country, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        Country country = countryList.get(position);
        holder.countryName.setText(country.getName());
        holder.countryFlag.setImageResource(country.getFlagResource());

        // Vérifie si un listener est défini (Fragments) ou sinon ouvre l'Activity
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onCountrySelected(country);
            } else {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("country", country);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    @Override
    public Filter getFilter() {
        return countryFilter;
    }

    private Filter countryFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Country> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(countryListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Country country : countryListFull) {
                    if (country.getName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(country);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;
            results.count = filteredList.size();
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            countryList.clear();
            countryList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    public static class CountryViewHolder extends RecyclerView.ViewHolder {
        TextView countryName;
        ImageView countryFlag;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            countryName = itemView.findViewById(R.id.countryName);
            countryFlag = itemView.findViewById(R.id.countryFlag);
        }
    }
}
