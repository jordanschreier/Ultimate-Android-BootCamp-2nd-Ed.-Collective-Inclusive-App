package edu.delta.jordanschreier.ultimate;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

/**
 * Created by Jordan on 4/16/2015.
 */
public class AppPreferenceActivity extends PreferenceActivity {
    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        PreferenceManager prefMgr = getPreferenceManager();
        prefMgr.setSharedPreferencesName("appPreferences");

        //Load pref from an xml file
        addPreferencesFromResource(R.xml.mypreferences);
    }
}
