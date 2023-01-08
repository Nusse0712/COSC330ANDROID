package com.cornez.shippingcalculator;


import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
private ShipItem shipItem;

private EditText weightET;
private TextView baseCostTV;
private TextView addedCostTV;
private TextView totalCostTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_layout);
        shipItem = new ShipItem();

        weightET = (EditText) findViewById(R.id.editText1);
        baseCostTV = (TextView) findViewById(R.id.textView4);
        addedCostTV = (TextView) findViewById(R.id.textView6);
        totalCostTV = (TextView) findViewById(R.id.textView8);

        weightET.addTextChangedListener(weightTextWatcher);

    }
    private TextWatcher weightTextWatcher = new TextWatcher() {

        public void onTextChanged(CharSequence s, int start, int before, int count){
            try {
                shipItem.setWeight((int) Double.parseDouble(s.toString()));

            }catch (NumberFormatException e){
                shipItem.setWeight(0);
            }
            displayShipping();
        }
        public void afterTextChanged(Editable s){}
        public void beforeTextChanged(CharSequence s, int start, int count, int after){}
    };

    public void displayShipping(){
        baseCostTV.setText("$"+String.format("%.02f",shipItem.getmBaseCost()));
        addedCostTV.setText("$"+String.format("%.02f",shipItem.getAddedCost()));
        totalCostTV.setText("$"+String.format("%.02f",shipItem.getTotalCost()));
    }
}