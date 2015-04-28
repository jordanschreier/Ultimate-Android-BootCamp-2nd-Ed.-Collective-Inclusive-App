package edu.delta.jordanschreier.ultimate;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;


public class OtherResourcesActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_resources);

        final Button dannyCode = (Button) findViewById(R.id.button);
        final Button appCode = (Button) findViewById(R.id.button10);
        final CheckBox splash = (CheckBox) findViewById(R.id.checkBox);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        if((sharedPref.getString("splashy", "").equals("false"))){
            splash.setChecked(false);
        }

        dannyCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/dandelano/Android-Boot-Camp-2nd-Ed")));
            }
        });
        appCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/jordanschreier/Ultimate-Android-BootCamp-2nd-Ed.-Collective-Inclusive-App")));
            }
        });

        splash.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("splashy", "true");
                    editor.commit();
                    Toast.makeText(OtherResourcesActivity.this, "The big android splash screen WILL show on startup", Toast.LENGTH_LONG).show();

                }else{
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("splashy", "false");
                    editor.commit();
                    Toast.makeText(OtherResourcesActivity.this, "The big android splash screen will NOT show on startup", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_other_resources, menu);
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
