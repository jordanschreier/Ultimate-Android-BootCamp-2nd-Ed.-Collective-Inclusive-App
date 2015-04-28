package edu.delta.jordanschreier.ultimate;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
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


public class SpeciesMainActivity extends Activity {
    Integer[] Animals = {R.drawable.eagle, R.drawable.elephant, R.drawable.gorilla,
            R.drawable.panda, R.drawable.panther, R.drawable.polar};
    ImageView pic;
    Display display;
    Point size = new Point();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_species_main);

        display = getWindowManager().getDefaultDisplay();
        display.getSize(size);

        GridView gr = (GridView)findViewById(R.id.gridView1);
        final ImageView pic = (ImageView) findViewById(R.id.imgLarge);
        pic.setMaxHeight(size.y/5*3);
        gr.setAdapter(new ImageAdapter(this));
        gr.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), "Selected Species" + (position + 1), Toast.LENGTH_SHORT).show();
                pic.setImageResource(Animals[position]);
            }
        });
    }
    public class ImageAdapter extends BaseAdapter{
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
            pic.setScaleType(ImageView.ScaleType.CENTER_CROP);
            pic.setLayoutParams(new GridView.LayoutParams(size.x/3,size.y/5));
            return pic;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_species_main, menu);
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
