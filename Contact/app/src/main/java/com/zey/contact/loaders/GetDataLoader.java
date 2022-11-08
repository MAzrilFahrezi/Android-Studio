package com.zey.contact.loaders;

import android.content.Context;
import android.service.autofill.UserData;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import com.zey.contact.databases.UserDatabase;
import com.zey.contact.entities.User;

import java.util.List;

public class GetDataLoader extends AsyncTaskLoader<List<User>> {
    private UserDatabase db;
    public GetDataLoader(@NonNull Context context) {
        super(context);
        db = UserDatabase.getInstance(context);
    }

    @Nullable
    @Override
    public List<User> loadInBackground() {
        return db.userDao().getAllUsers();
    }
}
