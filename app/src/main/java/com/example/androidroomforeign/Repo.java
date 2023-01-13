package com.example.androidroomforeign;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;


@Entity(foreignKeys = @ForeignKey(entity = User.class,
        parentColumns = "id",
        childColumns = "userId",
        onDelete = 1))
public class Repo {
    @PrimaryKey
    public final int id;
    public final String name;
    public final String url;
    public final int userId;

    public Repo(final int id, String name, String url,
                final int userId) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.userId = userId;
    }
}