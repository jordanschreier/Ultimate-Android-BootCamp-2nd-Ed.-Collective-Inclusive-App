package edu.delta.jordanschreier.ultimate;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class Status extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.status);
        TextView result = (TextView)findViewById(R.id.txtResults);
        ImageView image = (ImageView)findViewById(R.id.imgStatus);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String strFlier = sharedPref.getString("ch11key1", "");
        int intMileage = sharedPref.getInt("ch11key2", 0);

        if(intMileage >=75000){
            image.setImageResource(R.drawable.gold);
            result.setText(strFlier + " has reached Gold status");
        }else if(intMileage >=50000){
            image.setImageResource(R.drawable.silver);
            result.setText(strFlier + " has reached Silver status");
        } else if(intMileage >=25000){
            image.setImageResource(R.drawable.bronze);
            result.setText(strFlier + " has reached Bronze status");
        }else {
            result.setText("You have not reached an award");
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_jet_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
