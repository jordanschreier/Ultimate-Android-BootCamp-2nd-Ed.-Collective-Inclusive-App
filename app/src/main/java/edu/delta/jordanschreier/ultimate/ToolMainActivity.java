package edu.delta.jordanschreier.ultimate;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class ToolMainActivity extends ActionBarActivity {
    double washerRate = 55.99;
    double tillerRate = 68.99;
    int daysEntered;
    double calculatedCost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher_tools);

        final EditText days = (EditText) findViewById(R.id.editText);
        final RadioButton washer = (RadioButton) findViewById(R.id.radWasher);
        final RadioButton tiller = (RadioButton) findViewById(R.id.radTiller);
        final TextView result = (TextView) findViewById(R.id.textView2);
        final Button convert = (Button) findViewById(R.id.btnCost);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                daysEntered = Integer.parseInt(days.getText().toString());
                DecimalFormat tenth = new DecimalFormat("$#,###.##");
                if(washer.isChecked()){
                    if(daysEntered <= 7){
                        calculatedCost = daysEntered * washerRate;
                        result.setText("Your rental bill is: " + tenth.format(calculatedCost) + " for " + daysEntered + " days");
                    }else{
                        Toast.makeText(ToolMainActivity.this, "Days cannot exceed 7", Toast.LENGTH_LONG).show();
                    }
                }
                if(tiller.isChecked()){
                    if(daysEntered <= 7){
                        calculatedCost = daysEntered * tillerRate;
                        result.setText("Your rental bill is: " + tenth.format(calculatedCost) + " for " + daysEntered + " days");
                    }else{
                        Toast.makeText(ToolMainActivity.this,"Days cannot exceed 7", Toast.LENGTH_LONG).show();

                    }
                }
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tool_main, menu);
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
