package com.zey.contact.loaders;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import com.zey.contact.databases.UserDatabase;
import com.zey.contact.entities.User;

public class DeleteLoader extends AsyncTaskLoader<Integer> {
    private UserDatabase db;
    private int userId;

    public DeleteLoader(@NonNull Context context, int userId) {
        super(context);
        this.userId = userId;
        db = UserDatabase.getInstance(context);
    }

    @Nullable
    @Override
    public Integer loadInBackground() {
        return db.userDao().deleteUsers(userId);
    }
}
