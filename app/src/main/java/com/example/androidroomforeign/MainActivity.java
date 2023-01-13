package com.example.androidroomforeign;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RepoDao repoDao = RepoDatabase.getInstance(this).getRepoDao();

        UserDao userDao = RepoDatabase
                .getInstance(this)
                .getUserDao();

        int userID = new Random().nextInt();
        userDao.insert(new User(userID,
                "Jake Wharton",
                "https://avatars0.githubusercontent.com/u/66577"));

        repoDao.insert(new Repo(new Random().nextInt(),
                "square/retrofit",
                "https://github.com/square/retrofit",
                userID));

        List<Repo> repositoriesForUser = repoDao.
                findRepositoriesForUser(userID);
        for (int i = 0; i < repositoriesForUser.size(); i++) {
            Log.e("AAA", repositoriesForUser.get(i).userId + "");
        }
    }
}