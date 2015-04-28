package edu.delta.jordanschreier.ultimate;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class NotSplashing extends ActionBarActivity {

    Button btMarimba, btMerengue;
    MediaPlayer mpMarimba, mpMerengue;
    int playing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_splashing);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        btMarimba = (Button) findViewById(R.id.btnMarimba);
        btMerengue = (Button) findViewById(R.id.btnMerengue);

        btMarimba.setOnClickListener(bMarimba);
        btMerengue.setOnClickListener(bMerengue);
        mpMarimba = new MediaPlayer();
        mpMarimba = MediaPlayer.create(this, R.raw.marimba);
        mpMerengue = new MediaPlayer();
        mpMerengue = MediaPlayer.create(this, R.raw.merengue);
        playing = 0;
    }

    Button.OnClickListener bMarimba = new Button.OnClickListener(){

        @Override
        public void onClick(View v){

            switch(playing){
                case 0:
                    mpMarimba.start();
                    playing = 1;
                    btMarimba.setText("Pause Marimba Song");
                    btMerengue.setVisibility(View.INVISIBLE);
                break;
                case 1:
                    mpMarimba.pause();
                    playing = 0;
                    btMarimba.setText("Play Marimba Song");
                    btMerengue.setVisibility(View.VISIBLE);
                break;
            }
        }
    };


    Button.OnClickListener bMerengue = new Button.OnClickListener(){

        @Override
        public void onClick(View v){
            switch(playing){
                case 0:
                    mpMerengue.start();
                    playing = 1;
                    btMerengue.setText("Pause Merengue Song");
                    btMarimba.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mpMerengue.pause();
                    playing = 0;
                    btMerengue.setText("Play Merengue Song");
                    btMarimba.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_not_splashing, menu);
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
