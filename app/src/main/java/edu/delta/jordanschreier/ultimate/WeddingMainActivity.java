package edu.delta.jordanschreier.ultimate;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;


public class WeddingMainActivity extends ActionBarActivity {

    Integer[] Animals = {
            R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five,
            R.drawable.six,
            R.drawable.seven,
            R.drawable.eight,
            R.drawable.nine,
            R.drawable.ten
    };
    ImageView pic;
    Display display;
    Point size = new Point();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wedding_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        display = getWindowManager().getDefaultDisplay();
        display.getSize(size);
        GridView gr = (GridView)findViewById(R.id.gridView1);
        final ImageView pic = (ImageView) findViewById(R.id.imgLarge);
        pic.setMaxHeight(size.y/5*3);
        gr.setAdapter(new ImageAdapter(this));
        gr.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), "Anthology Wedding Photo " + (position + 1), Toast.LENGTH_SHORT).show();
                pic.setImageResource(Animals[position]);
            }
        });
    }
    public class ImageAdapter extends BaseAdapter {
        private Context context;
        public ImageAdapter(Context c){
            context = c;
        }

        @Override
        public int getCount(){
            return Animals.length;
        }

        @Override
        public Object getItem(int arg0){ return null; }

        @Override
        public long getItemId(int arg0){
            return 0;
        }

        @Override
        public View getView(int arg0, View arg1, ViewGroup arg2){
            pic = new ImageView(context);
            pic.setImageResource(Animals[arg0]);
            pic.setScaleType(ImageView.ScaleType.FIT_CENTER);
            pic.setLayoutParams(new GridView.LayoutParams(size.x/2, size.y/3));
            return pic;
        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_wedding_main, menu);
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
