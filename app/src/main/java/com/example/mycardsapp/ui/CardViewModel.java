package com.example.mycardsapp.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mycardsapp.data.Card;
import com.example.mycardsapp.data.CardRepository;

import java.util.List;

public class CardViewModel extends AndroidViewModel {
    CardRepository cardRepository;
    LiveData<List<Card>> listRepo;

    public CardViewModel(@NonNull Application application) {
        super(application);
        cardRepository = new CardRepository(application);
        listRepo = cardRepository.getListLiveData();
    }


    public LiveData<List<Card>> getListRepo() {
        return listRepo;
    }

    public void addCard(Card card) {
        cardRepository.addCard(card);
    }
}
