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


public class MathMainActivity extends ActionBarActivity {
    int first;
    int second;
    double answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setDisplayUseLogoEnabled(true);
        //getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setIcon(R.drawable.math);

        final EditText num1 = (EditText) findViewById(R.id.num1);
        final EditText num2 = (EditText) findViewById(R.id.num2);
        final RadioButton add = (RadioButton) findViewById(R.id.radAdd);
        final RadioButton subtract = (RadioButton) findViewById(R.id.radSubtract);
        final RadioButton multiply = (RadioButton) findViewById(R.id.radMultiply);
        final RadioButton divide = (RadioButton) findViewById(R.id.radDivide);
        final TextView result = (TextView) findViewById(R.id.textView2);
        final Button calculate = (Button) findViewById(R.id.btnFlash);
        calculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if (!((num1.getText().toString().equals("")) || (num2.getText().toString().equals("")))) {
                    first = Integer.parseInt(num1.getText().toString());
                    second = Integer.parseInt(num2.getText().toString());
                    DecimalFormat ans = new DecimalFormat("###.####");

                    if(first <=20 && second <= 20) {

                        if (add.isChecked()) {
                            answer = first + second;
                            result.setText(first + " + " + second + " = " + ans.format(answer));
                        }
                        if (subtract.isChecked()) {
                            answer = first - second;
                            result.setText(first + " - " + second + " = " + ans.format(answer));
                        }
                        if (multiply.isChecked()) {
                            answer = first * second;
                            result.setText(first + " * " + second + " = " + ans.format(answer));
                        }
                        if (divide.isChecked() && second != 0) {
                            answer = first / Double.parseDouble(num2.getText().toString());
                            result.setText(first + " / " + second + " = " + ans.format(answer));

                        }
                        if (divide.isChecked() && second == 0) {
                            Toast.makeText(MathMainActivity.this, "Cannot divide by 0", Toast.LENGTH_LONG).show();
                        }

                        hideKeyboard();

                    }else Toast.makeText(MathMainActivity.this, "No number can exceed 20", Toast.LENGTH_LONG).show();

                }else Toast.makeText(MathMainActivity.this, "Both fields must be filled", Toast.LENGTH_LONG).show();

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
        getMenuInflater().inflate(R.menu.menu_math_main, menu);
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
