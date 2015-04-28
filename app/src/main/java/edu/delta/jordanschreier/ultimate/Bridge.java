package edu.delta.jordanschreier.ultimate;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by Jordan on 2/12/2015.
 */
public class Bridge extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bridge);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher_sf);
    }
}
