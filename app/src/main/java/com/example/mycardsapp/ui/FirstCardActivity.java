package com.example.mycardsapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mycardsapp.R;

public class FirstCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_card);
    }

    public void add_newCard(View view) {
        startActivity(new Intent(FirstCardActivity.this,CardDetailActivity.class));
    }
}