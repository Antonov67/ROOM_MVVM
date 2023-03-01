package com.example.room_mvvm.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.room_mvvm.R;
import com.example.room_mvvm.dao.UserEntity;
import com.example.room_mvvm.viewModel.MainViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    MainViewModel mainViewModel;

    TextView resultText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultText = findViewById(R.id.result_text);
        button = findViewById(R.id.button);

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainViewModel.getAllUsers().observe(MainActivity.this, new Observer<List<UserEntity>>() {
                    @Override
                    public void onChanged(List<UserEntity> users) {
                        StringBuilder stringBuilder = new StringBuilder();
                        for (UserEntity user: users) {
                            stringBuilder
                                    .append(user.getId())
                                    .append(" ")
                                    .append(user.name)
                                    .append(" ")
                                    .append(user.pswrd)
                                    .append("\n");
                        }
                        Log.d("777", stringBuilder.toString());
                        resultText.setText(stringBuilder);
                    }
                });
            }
        });


    }
}