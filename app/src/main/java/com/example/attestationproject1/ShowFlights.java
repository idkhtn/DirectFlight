package com.example.attestationproject1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ShowFlights extends AppCompatActivity {

    //show airports from this country then show flights from this airport
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_flights);
    }
}