package edu.delta.jordanschreier.ultimate;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;


public class BillMainActivity extends Activity {
    double totalbill;
    double sharedBill;
    String groupChoice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_main);

        final EditText inBill=(EditText)findViewById(R.id.txtBill);
        final EditText inParty=(EditText)findViewById(R.id.txtParty);
        final Spinner group = (Spinner)findViewById(R.id.txtGroup);
        Button cost = (Button)findViewById(R.id.btnCalculate);
        final TextView result = ((TextView)findViewById(R.id.txtTip));
        cost.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try {
                    totalbill = Double.parseDouble(inBill.getText().toString()) * 1.18;
                    sharedBill = totalbill / Integer.parseInt(inParty.getText().toString());
                }catch(Exception e){}

                DecimalFormat dec = new DecimalFormat("$###,###.00");
                groupChoice = group.getSelectedItem().toString();
                result.setText("Each person has to pay " + dec.format(sharedBill) + " for the "  + groupChoice +  " service performed tonight.");
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
        getMenuInflater().inflate(R.menu.menu_bill_main, menu);
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
