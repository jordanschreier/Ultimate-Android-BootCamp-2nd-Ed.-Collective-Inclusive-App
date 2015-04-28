package edu.delta.jordanschreier.ultimate;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;


public class PaintMainActivity extends ActionBarActivity {
    double totalGal;
    int sqft;
    String groupChoice;

    String red = "red";
    String green= "green";
    String blue ="blue";
    String yellow ="yellow";
    String purple= "purple";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        final EditText heightI=(EditText)findViewById(R.id.txtH);
        final EditText widthI=(EditText)findViewById(R.id.txtW);
        final FrameLayout frame=(FrameLayout)findViewById(R.id.framelayout);
        final Spinner group = (Spinner)findViewById(R.id.txtGroup);
        Button cost = (Button)findViewById(R.id.btnGal);
        cost.setOnClickListener(new View.OnClickListener(){
            final TextView result = ((TextView)findViewById(R.id.txtResult));

            @Override
            public void onClick(View v){
                try {
                    sqft = Integer.parseInt(heightI.getText().toString()) * Integer.parseInt(widthI.getText().toString());
                    totalGal = sqft / 250.0;
                }catch (Exception e){}
                DecimalFormat dec = new DecimalFormat("###.00");
                groupChoice = group.getSelectedItem().toString();
                result.setText("Total number of gallons of " + groupChoice + " colored paint is " + dec.format(totalGal));
                frame.setBackgroundColor(Color.parseColor(findCol(groupChoice)));
                hideKeyboard();
            }
        });
    }
    private void hideKeyboard() {
        // Check if no view has focus:
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager inputManager = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    private String findCol(String choice){
        if(choice.equals("Rosy Red")) return red;
        else if (choice.equals("Grody Green")) return green;
        else if (choice.equals("Beautiful Blue")) return blue;
        else if (choice.equals("Yucky Yellow")) return yellow;
        else return purple;

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_paint_main, menu);
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
