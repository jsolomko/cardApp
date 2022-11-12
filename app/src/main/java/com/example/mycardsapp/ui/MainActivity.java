package com.example.mycardsapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.example.mycardsapp.R;
import com.example.mycardsapp.adapters.CardAdapter;
import com.example.mycardsapp.data.Card;
import com.google.android.material.appbar.AppBarLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    CardViewModel cardViewModel;
    AppBarLayout appBarLayout;

    @SuppressLint("UseSupportActionBar")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appBarLayout = findViewById(R.id.cutomAppBar);
        Toolbar toolbar = findViewById(R.id.custom_tollbar);
        setActionBar(toolbar);

        recyclerView = findViewById(R.id.rv_cards);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        cardViewModel = new ViewModelProvider(this).get(CardViewModel.class);
        CardAdapter cardAdapter = new CardAdapter(new CardAdapter.CardDiff());
        recyclerView.setAdapter(cardAdapter);
        cardViewModel.getListRepo().observe(this, new Observer<List<Card>>() {
            @Override
            public void onChanged(List<Card> cards) {
                cardAdapter.submitList(cards);
            }
        });

    }
}