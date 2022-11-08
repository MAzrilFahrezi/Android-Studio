package com.zey.contact.loaders;

import android.content.Context;
import android.service.autofill.UserData;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import com.zey.contact.databases.UserDatabase;
import com.zey.contact.entities.User;

public class InsertLoader extends AsyncTaskLoader<Boolean> {
    private UserDatabase db;
    private User user;
    public InsertLoader(@NonNull Context context, User user) {
        super(context);
        this.user = user;
        db = UserDatabase.getInstance(context);

    }

    @Nullable
    @Override
    public Boolean loadInBackground() {
        db.userDao().insertUser(user);
        return true ;
    }
}
