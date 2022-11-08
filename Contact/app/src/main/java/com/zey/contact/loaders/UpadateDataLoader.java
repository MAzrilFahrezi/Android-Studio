package com.zey.contact.loaders;

import android.content.Context;
import android.service.autofill.UserData;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import com.zey.contact.databases.UserDatabase;
import com.zey.contact.entities.User;

public class UpadateDataLoader extends AsyncTaskLoader<Integer> {
    private UserDatabase db;
    private User user;

    public UpadateDataLoader(@NonNull Context context, User user) {
        super(context);
        this.user = user;
        db = UserDatabase.getInstance(context);
    }

    @Nullable
    @Override
    public Integer loadInBackground() {
        return db.userDao().updateUser(user);
    }
}
