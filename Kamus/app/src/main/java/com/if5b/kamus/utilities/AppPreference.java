package com.if5b.kamus.utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.if5b.kamus.R;

public class AppPreference {
        private Context context;
        private SharedPreferences prefs;

        public AppPreference(Context context){
            prefs = PreferenceManager.getDefaultSharedPreferences(context);
            this.context = context;
        }

        public void setFirstRUn(boolean input){
            SharedPreferences.Editor editor = prefs.edit();
            String key = context.getString(R.string.app_first_run);
            editor.putBoolean(key, input);
            editor.commit();
        }

        public boolean getFirstRun(){
            String key = context.getString(R.string.app_first_run);
            return prefs.getBoolean(key, true);
        }
}
