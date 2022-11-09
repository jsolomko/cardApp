package com.example.mycardsapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.mycardsapp.R;

public class FirstCardActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_card);
        imageView = findViewById(R.id.imgListCards);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FirstCardActivity.this, MainActivity.class));
            }
        });
    }

    public void add_newCard(View view) {
        startActivity(new Intent(FirstCardActivity.this, CardDetailActivity.class));
    }
}