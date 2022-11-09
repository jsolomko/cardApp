package com.example.mycardsapp.data;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.mycardsapp.R;

@Entity(tableName = "card_table")
public class Card {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String cardTitle;
    private int cardNumber;
    private Bitmap card_front;
    private int card_back;

    public Card( String cardTitle, Bitmap card_front) {
        this.cardTitle = cardTitle;
        this.card_front = card_front;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardTitle() {
        return cardTitle;
    }

    public void setCardTitle(String cardTitle) {
        this.cardTitle = cardTitle;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Bitmap getCard_front() {
        return card_front;
    }

    public void setCard_front(Bitmap card_front) {
        this.card_front = card_front;
    }

    public int getCard_back() {
        return card_back;
    }

    public void setCard_back(int card_back) {
        this.card_back = card_back;
    }
}
