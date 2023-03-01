package com.example.room_mvvm.dao;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class DataBaseManager {

    private DataBaseHelper db;
    private static DataBaseManager instance;

    private DataBaseManager(Context context){
        db = Room.databaseBuilder(context,
                DataBaseHelper.class,
                DataBaseHelper.DATABASE_NAME)
                .addCallback(new RoomDatabase.Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                            @Override
                            public void run() {
                                initData(context);
                            }
                        });
                    }
                })
                .build();
    }

    public static DataBaseManager getInstance(Context context){
        if (instance == null){
            instance = new DataBaseManager(context.getApplicationContext());
        }
        return instance;
    }

    public DaoInt getDaoInt() {
        return db.daoInt();
    }

    private void initData(Context context) {
        List<UserEntity> users = new ArrayList<>();
        UserEntity user = new UserEntity();

        user.name = "User1";
        user.pswrd = "123";
        users.add(user);

        user = new UserEntity();
        user.name = "User2";
        user.pswrd = "456";
        users.add(user);

        user = new UserEntity();
        user.name = "User3";
        user.pswrd = "789";
        users.add(user);

        DataBaseManager.getInstance(context).getDaoInt().insertUser(users);
    }

}
