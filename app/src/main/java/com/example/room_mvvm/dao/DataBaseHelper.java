package com.example.room_mvvm.dao;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;


@Database(entities = {UserEntity.class},version = 1)
@TypeConverters({Converters.class})
public abstract class DataBaseHelper extends RoomDatabase {
    public static final String DATABASE_NAME = "db1";

    public abstract DaoInt daoInt();
}
