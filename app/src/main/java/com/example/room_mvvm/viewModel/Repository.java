package com.example.room_mvvm.viewModel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.room_mvvm.dao.DaoInt;
import com.example.room_mvvm.dao.DataBaseManager;
import com.example.room_mvvm.dao.UserEntity;

import java.util.List;

public class Repository {
    private DataBaseManager dataBaseManager;
    private DaoInt dao;

    public Repository(Context context) {
        dataBaseManager = DataBaseManager.getInstance(context);
        dao = dataBaseManager.getDaoInt();
    }

    public LiveData<List<UserEntity>> getAllUsers(){
        return dao.getAllUsers();
    }

    public void insertUser(List<UserEntity> data){
        dao.insertUser(data);
    }
}
