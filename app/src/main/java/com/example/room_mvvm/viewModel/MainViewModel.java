package com.example.room_mvvm.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.room_mvvm.dao.UserEntity;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private Repository repository;


    public MainViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    public LiveData<List<UserEntity>> getAllUsers(){
        return repository.getAllUsers();
    }

    public void insertUser(List<UserEntity> data){
        repository.insertUser(data);
    }
}
