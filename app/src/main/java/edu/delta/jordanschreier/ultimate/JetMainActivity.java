package edu.delta.jordanschreier.ultimate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class JetMainActivity extends ActionBarActivity {
    String strName;
    int intMiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jet_main);
        final EditText name = (EditText) findViewById(R.id.txtName);
        final EditText miles = (EditText) findViewById(R.id.txtMiles);
        Button btStatus = (Button) findViewById(R.id.btnStatus);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        try {
            name.setText(sharedPref.getString("ch11key1", ""));
            int poop = (sharedPref.getInt("ch11key2", 0));
            if (poop != 0) {
                miles.setText(String.valueOf(poop));
            }
        }catch (Exception e){

        }
        btStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strName = name.getText().toString();
                if (miles.getText().toString().equals("")){
                    intMiles = 0;
                }else{
                    intMiles = Integer.parseInt(miles.getText().toString());
                }
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("ch11key1", strName);
                editor.putInt("ch11key2", intMiles);
                editor.commit();
                startActivity(new Intent(JetMainActivity.this, Status.class));
            }
        });
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
