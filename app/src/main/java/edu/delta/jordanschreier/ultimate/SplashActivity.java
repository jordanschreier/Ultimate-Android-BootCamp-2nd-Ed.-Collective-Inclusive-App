package edu.delta.jordanschreier.ultimate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;


public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TextView txt = (TextView) findViewById(R.id.splash);
        TimerTask task = new TimerTask(){

            @Override
            public void run(){
                finish();
                startActivity(new Intent(SplashActivity.this, PlaylistActivity.class));
            }
        };

        final Timer opening = new Timer();
        opening.schedule(task, 6000);

        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opening.cancel();
                finish();
                startActivity(new Intent(SplashActivity.this, PlaylistActivity.class));
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_playlist, menu);
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
