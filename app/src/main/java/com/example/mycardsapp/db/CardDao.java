package com.example.mycardsapp.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mycardsapp.data.Card;

import java.util.List;

@Dao
public interface CardDao {

    @Query("SELECT * From card_table")
    LiveData<List<Card>> getAllCards();

    @Insert
    void addNewCard(Card card);
}
