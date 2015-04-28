package edu.delta.jordanschreier.ultimate;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by Jordan on 4/2/2015.
 */
public class Tween extends ActionBarActivity {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tween);
        ImageView imgRotate = (ImageView) findViewById(R.id.imgTween);
        imgRotate.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotation));

    }

}
