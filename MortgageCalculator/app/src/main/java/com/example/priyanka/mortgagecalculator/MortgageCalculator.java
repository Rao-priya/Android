package com.example.priyanka.mortgagecalculator;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MortgageCalculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitylinearlayout);//Linear Layout


        //on click of calculate button
        Button button = (Button) findViewById(R.id.calculate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                boolean flag = true;//boolean value to keep track of correct value
                try {
                    CharSequence text = "Welcome to mortgage calculator application!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast= Toast.makeText(context,text,duration);
                    int loanTerm;
                    double tax , Payment;

                    //get principal amount entered
                    Float amountBurrowed = Float.parseFloat(((EditText) findViewById(R.id.amount)).getText().toString());
                    if (amountBurrowed <= 0.0 ||Float.isInfinite(amountBurrowed) ) {
                        toast.makeText(context, "Please enter correct amount", Toast.LENGTH_SHORT).show();
                        amountBurrowed = 0.0f;
                        flag = false;
                        EditText amount=(EditText) findViewById(R.id.amount); amount.setText("");
                    }

                    //get interest rate
                    Double interestRate = Double.parseDouble(((EditText) findViewById(R.id.interestRate)).getText().toString());
                    if (interestRate < 0.0 || interestRate > 20.0) { //interest rate out of range
                        toast.makeText(context, "Interest rate value can be  from 0 to 20 %", duration).show();
                        flag = false;
                        EditText interst=(EditText) findViewById(R.id.interestRate);
                        interst.setText("7");
                    } else {
                        interestRate = interestRate / 1200;
                    }

                  //  get loan term value
                    RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
                    int selcted = radioGroup.getCheckedRadioButtonId();
                    RadioButton radioButton = (RadioButton) findViewById(selcted);
                    loanTerm = Integer.parseInt(radioButton.getText().toString());
                    loanTerm = loanTerm * 12;

                   //get tax & insurance value
                    CheckBox check = (CheckBox) findViewById(R.id.checkTax);
                    if (check.isChecked()) {
                        tax = 0.001;
                    } else {
                        tax = 0;
                    }

                    if (flag) {
                        if (interestRate == 0.0) {
                            Payment = (amountBurrowed / loanTerm)+(tax*amountBurrowed);
                        } else {
                            Payment = (amountBurrowed * (interestRate / (1 - (Math.pow((1 + interestRate), -loanTerm)))))+(tax*amountBurrowed);
                        }
                        TextView monthlyPayment = (TextView) findViewById(R.id.monthlyPayment);
                        monthlyPayment.setText("Your Monthly Payment is  " + Double.toString(Payment));

                    } else {
                        TextView monthlyPayment = (TextView) findViewById(R.id.monthlyPayment);
                        monthlyPayment.setText("");
                        toast.makeText(context, "Please enter correct values to calculate Monthly Payment", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e){
                    clearValues();
                  e.toString();
                }

            }
        });

    }
    void clearValues(){
        Context context = getApplicationContext();
        CharSequence text = "Please enter correct values to calculate Monthly payment";
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        EditText amount=(EditText) findViewById(R.id.amount); amount.setText("");
        EditText interst=(EditText) findViewById(R.id.interestRate);
        interst.setText("7");
        TextView monthlyPayment = (TextView) findViewById(R.id.monthlyPayment);
        monthlyPayment.setText("");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mortgage_calculator, menu);
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
