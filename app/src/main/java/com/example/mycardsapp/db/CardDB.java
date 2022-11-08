package com.example.mycardsapp.db;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mycardsapp.data.Card;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Card.class}, version = 0, exportSchema = false)
public abstract class CardDB extends RoomDatabase {
    public abstract CardDao cardDao();

    private static volatile CardDB INSTANCE;
    private final String DB_NAME = "card_db";
    private static final int THREADS = 4;
    public final static ExecutorService executor = Executors.newFixedThreadPool(THREADS);

    public CardDB getINSTANCE(Application application) {
        if (INSTANCE == null) {
            synchronized (CardDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room
                            .databaseBuilder(application.getApplicationContext(), CardDB.class, DB_NAME)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
