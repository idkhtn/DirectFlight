package com.example.attestationproject1.Adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.attestationproject1.Model.Airport;
import com.example.attestationproject1.R;

import java.util.List;

class SearchViewHolder extends RecyclerView.ViewHolder{

    public TextView name, city, country, latitude, longitude;
    public SearchViewHolder(@NonNull View itemView) {
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.name);
        city = (TextView) itemView.findViewById(R.id.city);
        country = (TextView) itemView.findViewById(R.id.country);
        latitude = (TextView) itemView.findViewById(R.id.latitude);
        longitude = (TextView) itemView.findViewById(R.id.longitude);


    }
}
public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder> {

    private Context context;
    private List<Airport> airports;

    public SearchAdapter(Context context, List<Airport> airports) {
        this.context = context;
        this.airports = airports;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.layout_item,parent,false);
        return new SearchViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        holder.name.setText(airports.get(position).getName());
        holder.city.setText(airports.get(position).getCity());
        holder.country.setText(airports.get(position).getCountry());
        holder.latitude.setText(String.valueOf(airports.get(position).getLatitude()));
        holder.latitude.setText(String.valueOf(airports.get(position).getLongitude()));

    }

    @Override
    public int getItemCount() {
        return airports.size();
    }
}
