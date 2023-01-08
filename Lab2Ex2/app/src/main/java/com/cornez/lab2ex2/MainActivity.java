package com.cornez.lab2ex2;

import androidx.appcompat.app.AppCompatActivity;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends Activity {
private Button addBtn;
private Button subtractBtn;
private Button orderButton;

private TextView quantityView;
private TextView summaryView;

private CheckBox creamBox;
private CheckBox chocBox;

private Coffee coffee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        coffee = new Coffee();
        initialize();
        registerChangeListener();
    }

    private void initialize(){

        creamBox = (CheckBox) findViewById(R.id.creamBox);
        chocBox = (CheckBox) findViewById(R.id.chocolateBox);

        addBtn = (Button) findViewById(R.id.addBtn);
        subtractBtn = (Button) findViewById(R.id.subtractBtn);
        quantityView = (TextView) findViewById(R.id.quantityNum);

        orderButton = (Button) findViewById(R.id.orderBtn);
        summaryView = (TextView) findViewById(R.id.summary);
    }
    private void registerChangeListener(){
        creamBox.setOnClickListener(creamListener);
        chocBox.setOnClickListener(chocListener);

    }

    public void addCoffee(View view){
        coffee.addCoffee();
        quantityView.setText(coffee.getCoffeeCount().toString());
    }
    public void subractCoffee(View view){
        coffee.removeCoffee();
        quantityView.setText(coffee.getCoffeeCount().toString());
    }

    private View.OnClickListener creamListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(((CheckBox) view).isChecked()){
                coffee.addCream();
            }else{
                coffee.removeCream();
            }
        }
    };

    private View.OnClickListener chocListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(((CheckBox) view).isChecked()){
                coffee.addChoc();
            }else{
                coffee.removeChoc();
            }
        }
    };
    public void orderCoffee(View view){
        summaryView.setText(coffee.getSummary());
    }





}



