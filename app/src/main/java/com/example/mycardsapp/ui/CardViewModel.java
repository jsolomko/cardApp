package com.example.mycardsapp.ui;

import androidx.lifecycle.LiveData;

import com.example.mycardsapp.data.Card;
import com.example.mycardsapp.data.CardRepository;

import java.util.List;

public class CardViewModel {
    CardRepository cardRepository;
    LiveData<List<Card>> listRepo;

    public CardViewModel(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
        this.listRepo = cardRepository.getListLiveData();
    }

    public LiveData<List<Card>> getListRepo() {
        return listRepo;
    }

    public void addCard(Card card) {
        cardRepository.addCard(card);
    }
}
