package com.example.androidroomforeign;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = { Repo.class, User.class },
        version = 1)
public abstract class RepoDatabase extends RoomDatabase {
    private static RepoDatabase db;

    public abstract RepoDao getRepoDao();
    public abstract UserDao getUserDao();
    public static synchronized RepoDatabase getInstance(Context context){
        if (db == null){
            db = Room.databaseBuilder(context,RepoDatabase.class,"DB_NAME.db")
                    .allowMainThreadQueries()
                    //thêm nếu thêm cột
//                  .addMigrations(migration_1_to_2)
                    .build();
        }
        return db;
    }

}
