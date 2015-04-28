package edu.delta.jordanschreier.ultimate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class UPMainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upmain);
    }
    public void onClickLoad(View view){
        Intent i = new Intent(this, AppPreferenceActivity.class);
        startActivity(i);
    }

    public void onClickModify(View view){
        SharedPreferences appPrefs = getSharedPreferences("UsingPreferences_preferences", MODE_PRIVATE);

        SharedPreferences.Editor prefsEditor = appPrefs.edit();
        prefsEditor.putString("editTextPref", ((EditText) findViewById(R.id.txtString)).getText().toString());
        prefsEditor.commit();
    }

    public void onClickDisplay(View view){
        SharedPreferences appPrefs = getSharedPreferences("UsingPreferences_preferences", MODE_PRIVATE);

        DisplayText(appPrefs.getString("editTextPref", ""));

    }

    private void DisplayText(String str){
        Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_upmain, menu);
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
