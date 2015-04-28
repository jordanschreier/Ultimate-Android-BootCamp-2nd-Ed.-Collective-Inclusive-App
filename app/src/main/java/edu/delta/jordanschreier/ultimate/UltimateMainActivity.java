package edu.delta.jordanschreier.ultimate;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class UltimateMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String key = "";
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        try {
            key = sharedPref.getString("splashy", "");
        }catch (Exception e){ }

        if (key.equals("false")){
            touch();
        }else{
            setContentView(R.layout.activity_ultimate_main);
            TextView touchText = (TextView) findViewById(R.id.utouchText);
            ImageView touchImage = (ImageView) findViewById(R.id.utouchImage);

            touchText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    touch();
                }
            });

            touchImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    touch();
                }
            });
        }


    }

    private void touch() {
        startActivity(new Intent(this, UltimateList.class));
        finish();
    }
}