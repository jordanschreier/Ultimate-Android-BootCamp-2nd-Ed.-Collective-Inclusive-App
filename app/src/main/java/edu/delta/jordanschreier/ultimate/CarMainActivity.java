package edu.delta.jordanschreier.ultimate;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class CarMainActivity extends ActionBarActivity {
    double compactRate = 59.99;
    double midsizedRate = 65.99;
    double luxuryRate = 89.99;
    int daysEntered;
    double calculatedCost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.car);

        final EditText days = (EditText) findViewById(R.id.editText);
        final RadioButton compact = (RadioButton) findViewById(R.id.radCompact);
        final RadioButton midsize = (RadioButton) findViewById(R.id.radMidSize);
        final RadioButton luxury = (RadioButton) findViewById(R.id.radLuxury);
        final TextView result = (TextView) findViewById(R.id.textView2);
        days.setOnKeyListener((new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (!(days.getText().toString().equals(""))) {
                    daysEntered = Integer.parseInt(days.getText().toString());
                    DecimalFormat tenth = new DecimalFormat("$#,###.00");
                    if (compact.isChecked()) {
                        if (daysEntered <= 10) {
                            calculatedCost = daysEntered * compactRate;
                            result.setText("Your rental bill is: " + tenth.format(calculatedCost) + " for " + daysEntered + " days");
                        } else {
                            Toast.makeText(CarMainActivity.this, "Days cannot exceed 10", Toast.LENGTH_LONG).show();
                        }
                    }
                    if (midsize.isChecked()) {
                        if (daysEntered <= 10) {
                            calculatedCost = daysEntered * midsizedRate;
                            result.setText("Your rental bill is: " + tenth.format(calculatedCost) + " for " + daysEntered + " days");
                        } else {
                            Toast.makeText(CarMainActivity.this, "Days cannot exceed 10", Toast.LENGTH_LONG).show();

                        }
                    }
                    if (luxury.isChecked()) {
                        if (daysEntered <= 10) {
                            calculatedCost = daysEntered * luxuryRate;
                            result.setText("Your rental bill is: " + tenth.format(calculatedCost) + " for " + daysEntered + " days");
                        } else {
                            Toast.makeText(CarMainActivity.this, "Days cannot exceed 10", Toast.LENGTH_LONG).show();

                        }
                    }
                    //hideKeyboard();

                }
                return false;
            }
        }));
    }

    private void hideKeyboard() {
        // Check if no view has focus:
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager inputManager = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_car_main, menu);
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
