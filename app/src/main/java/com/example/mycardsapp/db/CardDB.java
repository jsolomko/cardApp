package com.example.mycardsapp.db;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.mycardsapp.data.Card;
import com.example.mycardsapp.utils.ImageBitmapString;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Card.class}, version = 1, exportSchema = false)
@TypeConverters({ImageBitmapString.class})
public abstract class CardDB extends RoomDatabase {
    public abstract CardDao cardDao();

    private static volatile CardDB INSTANCE;
    private static final String DB_NAME = "card_db";
    private static final int THREADS = 4;
    public final static ExecutorService executor = Executors.newFixedThreadPool(THREADS);

    public static CardDB getINSTANCE(Application application) {
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
