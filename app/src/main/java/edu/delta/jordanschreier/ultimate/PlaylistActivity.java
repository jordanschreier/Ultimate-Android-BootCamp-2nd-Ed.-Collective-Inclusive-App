package edu.delta.jordanschreier.ultimate;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class PlaylistActivity extends Activity {

    ImageView ff5, flame, lecrae, tfk, triplee;
    MediaPlayer mff5, mflame, mlecrae, mtfk, mtriplee, mcur;
    int playing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actual);

        ff5 = (ImageView) findViewById(R.id.imageView);
        flame = (ImageView) findViewById(R.id.imageView2);
        lecrae = (ImageView) findViewById(R.id.imageView3);
        tfk = (ImageView) findViewById(R.id.imageView4);
        triplee = (ImageView) findViewById(R.id.imageView5);

        ff5.setOnClickListener(zff5);
        flame.setOnClickListener(zflame);
        lecrae.setOnClickListener(zlecrae);
        tfk.setOnClickListener(ztfk);
        triplee.setOnClickListener(ztriplee);


        mff5 = new MediaPlayer();
        mff5 = MediaPlayer.create(this, R.raw.bzrk);
        mflame = new MediaPlayer();
        mflame = MediaPlayer.create(this, R.raw.startover);
        mlecrae = new MediaPlayer();
        mlecrae = MediaPlayer.create(this, R.raw.allineedisyou);
        mtfk = new MediaPlayer();
        mtfk = MediaPlayer.create(this, R.raw.warofchange);
        mtriplee = new MediaPlayer();
        mtriplee = MediaPlayer.create(this, R.raw.sweetvictory);

        playing = 0;
    }

    Button.OnClickListener zff5 = new Button.OnClickListener(){
        @Override
        public void onClick(View v){
            clickedd(mff5,ff5);
        }
    };


    Button.OnClickListener zflame = new Button.OnClickListener(){
        @Override
        public void onClick(View v){
            clickedd(mflame,flame);
        }
    };

    Button.OnClickListener zlecrae = new Button.OnClickListener(){
        @Override
        public void onClick(View v){
            clickedd(mlecrae,lecrae);
        }
    };

    Button.OnClickListener ztfk = new Button.OnClickListener(){
        @Override
        public void onClick(View v){
            clickedd(mtfk,tfk);
        }
    };

    Button.OnClickListener ztriplee = new Button.OnClickListener(){
        @Override
        public void onClick(View v){
            clickedd(mtriplee,triplee);
        }
    };

    public void hideAll (){
        ff5.setVisibility(View.INVISIBLE);
        flame.setVisibility(View.INVISIBLE);
        lecrae.setVisibility(View.INVISIBLE);
        tfk.setVisibility(View.INVISIBLE);
        triplee.setVisibility(View.INVISIBLE);

    }

    public void showAll(){
        ff5.setVisibility(View.VISIBLE);
        flame.setVisibility(View.VISIBLE);
        lecrae.setVisibility(View.VISIBLE);
        tfk.setVisibility(View.VISIBLE);
        triplee.setVisibility(View.VISIBLE);

    }

    public void clickedd (MediaPlayer m, ImageView iv ) {
        switch (playing) {
            case 0:
                m.start();
                mcur = m;
                playing = 1;
                hideAll();
                iv.setVisibility(View.VISIBLE);
                break;
            case 1:
                m.pause();
                mcur = null;
                playing = 0;
                iv.setVisibility(View.INVISIBLE);
                showAll();
                break;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_actual, menu);
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

    @Override
    public void onPause(){
        super.onPause();
        if(mcur != null) mcur.pause();

    }

    @Override
    public void onResume(){
        super.onResume();
        if(mcur != null){
            mcur.start();

        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        if(mcur != null) mcur.stop();
        finish();
    }

}

