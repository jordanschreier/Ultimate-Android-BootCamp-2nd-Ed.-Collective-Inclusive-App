package edu.delta.jordanschreier.ultimate;

import android.app.ActionBar;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class UltimateList extends ListActivity {
    ActionBar ab;
    String classs = "Class App: ";
    String hw = "HW: ";
    String extra = "Extra: ";
    String tablet = " (For Tablets)";



    String [] list;
    String [] begin = {"Chapter 1", "Chapter 2", "Chapter 3", "Chapter 4", "Chapter 5",
            "Chapter 6", "Chapter 7", "Chapter 8", "Chapter 9", "Chapter 10", "Chapter 11", "Settings & Other Resources"};

    String [] one = {classs + "Hello World", hw + "1-1 Joke of The Day"};
    String [] two = {classs + "Healthy Recipes", hw + "2-5 Address Book", hw + "2-6 Music News"};
    String [] three = {classs + "Concert Tickets", hw + "3-4 Paint Calculator", hw + "3-5 Split The Bill"};
    String [] four = {classs + "Medical Calculator", hw + "4-1 Tool Rental", hw + "4-2 Car Rental", hw + "4-4 Math Flashcards"};
    String [] five = {classs + "San Francisco City Guide", hw + "5-2 Sushi Menu"};
    String [] six = {classs + "Latin Music", hw + "6-6 Personal Playlist"};
    String [] seven = {classs + "Endangered Species", hw + "7-5 Anthology Wedding", extra + "Gallery"};
    String [] eight = {classs + "Sailing Adventures" + tablet, classs + "Sailing Adventures", hw + "8-1 Appalachian Trail"};
    String [] nine = {classs + "Bike and Barge" + tablet, classs + "Bike and Barge"};
    String [] ten = {classs + "Wave Animation"};
    String [] eleven = {classs + "Clear Jet", extra + "Flag Quiz", extra + "Using Preferences", extra + "Emails"};
    String [] twelve = {"DISCLAIMER, Code and Settings"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list = begin;
        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_ultimate_list, R.id.uchapters, list));
        ab = getActionBar();

    }

    protected void onListItemClick(ListView l, View v, int position, long id){

        if(base()) {
            ab.setTitle("Chapter " + (position + 1));

            switch (position) {
                case 0:
                    list = one;
                    break;
                case 1:
                    list = two;
                    break;
                case 2:
                    list = three;
                    break;
                case 3:
                    list = four;
                    break;
                case 4:
                    list = five;
                    break;
                case 5:
                    list = six;
                    break;
                case 6:
                    list = seven;
                    break;
                case 7:
                    list = eight;
                    break;
                case 8:
                    list = nine;
                    break;
                case 9:
                    list = ten;
                    break;
                case 10:
                    list = eleven;
                    break;
                case 11:
                    list = twelve;
                    ab.setTitle("Other Resources");
                    break;
            }
            update();

        }else if(list.equals(one)) {
            switch (position) {
                case 0:
                    startActivity(new Intent(this, MainActivityy.class));
                    break;
                case 1:
                    startActivity(new Intent(this, HelloWorldActivity.class));
                    break;
            }
        }else if(list.equals(two)) {
            switch (position) {
                case 0:
                    startActivity(new Intent(this, HRMainActivity.class));
                    break;
                case 1:
                    startActivity(new Intent(this, ContactActivity.class));
                    break;
                case 2:
                    startActivity(new Intent(this, MusicMain.class));
                    break;
            }

        }else if(list.equals(three)) {
            switch (position) {
                case 0:
                    startActivity(new Intent(this, ConcertMainActivity.class));
                    break;
                case 1:
                    startActivity(new Intent(this, PaintMainActivity.class));
                    break;
                case 2:
                    startActivity(new Intent(this, BillMainActivity.class));
                    break;
            }
        }else if(list.equals(four)) {
            switch (position) {
                case 0:
                    startActivity(new Intent(this, MedicalMainActivity.class));
                    break;
                case 1:
                    startActivity(new Intent(this, ToolMainActivity.class));
                    break;
                case 2:
                    startActivity(new Intent(this, CarMainActivity.class));
                    break;
                case 3:
                    startActivity(new Intent(this, MathMainActivity.class));
                    break;
            }
        }else if(list.equals(five)) {
            switch (position) {
                case 0:
                    startActivity(new Intent(this, CityGuide.class));
                    break;
                case 1:
                    startActivity(new Intent(this, MenuMainActivity.class));
                    break;
            }
        }else if(list.equals(six)) {
            switch (position) {
                case 0:
                    startActivity(new Intent(this, LatinMusicMainActivity.class));
                    break;
                case 1:
                    startActivity(new Intent(this, SplashActivity.class));
                    break;
            }
        }else if(list.equals(seven)) {
            switch (position) {
                case 0:
                    startActivity(new Intent(this, SpeciesMainActivity.class));
                    break;
                case 1:
                    startActivity(new Intent(this, WeddingMainActivity.class));
                    break;
                case 2:
                    startActivity(new Intent(this, GalleryMainActivity.class));
                    break;
            }
        }else if(list.equals(eight)) {
            switch (position) {
                case 0:
                    startActivity(new Intent(this, SailingMainActivity.class));
                    break;
                case 1:
                    startActivity(new Intent(this, SailingPhoneMainActivity.class));
                    break;
                case 2:
                    startActivity(new Intent(this, AppalachianMainActivity.class));
                    break;
            }
        }else if(list.equals(nine)) {
            switch (position) {
                case 0:
                    startActivity(new Intent(this, ItemListActivitybbtab.class));
                    break;
                case 1:
                    startActivity(new Intent(this, ItemListActivityPhone.class));
                    break;
            }
        }else if(list.equals(ten)) {
            switch (position) {
                case 0:
                    startActivity(new Intent(this, WaveMainActivity.class));
                    break;
            }
        }else if(list.equals(eleven)) {
            switch (position) {
                case 0:
                    startActivity(new Intent(this, JetMainActivity.class));
                    break;
                case 1:
                    startActivity(new Intent(this, MainActivity.class));
                    break;
                case 2:
                    startActivity(new Intent(this, UPMainActivity.class));
                    break;
                case 3:
                    startActivity(new Intent(this, EmailsActivity.class));
                    break;
            }
        }else if(list.equals(twelve)) {
            switch (position) {
                case 0:
                    startActivity(new Intent(this, OtherResourcesActivity.class));
                    break;
            }
        }
    }





    public void update(){
        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_ultimate_list, R.id.uchapters, list));
    }

    public boolean base(){
        if(list.equals(begin))
            return true;
        return false;
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if(list.equals(begin)){
                finish();
            }else{
                list = begin;
                update();
                ab.setTitle("List of Chapters");
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ultimate_list, menu);
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
