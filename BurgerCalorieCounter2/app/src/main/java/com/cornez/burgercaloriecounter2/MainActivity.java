package com.cornez.burgercaloriecounter2;

import android.app.Activity;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.CheckBox;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;



public class MainActivity extends Activity {

    private RadioGroup pattyRG;
    private CheckBox prosciuttoCBX;
    private RadioGroup cheeseRG;
    private SeekBar sauceSBR;
    private TextView caloriesTV;

    private Burger burger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        burger = new Burger();
        initialize();

        registerChangeListener();
    }

    private void initialize(){
        pattyRG = (RadioGroup) findViewById(R.id.radioGroup1);
        prosciuttoCBX = (CheckBox) findViewById(R.id.checkbox1);
        cheeseRG = (RadioGroup) findViewById(R.id.radioGroup2);
        sauceSBR = (SeekBar) findViewById(R.id.seekBar1);
        caloriesTV = (TextView)findViewById(R.id.textView2);
    }
    private void registerChangeListener(){
        pattyRG.setOnCheckedChangeListener(foodListener);
        prosciuttoCBX.setOnClickListener(baconListener);
        cheeseRG.setOnCheckedChangeListener(foodListener);
        sauceSBR.setOnSeekBarChangeListener(sauceListener);
    }

    private OnCheckedChangeListener foodListener = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup rbGroup, int radioId) {
            switch(radioId){
                case (int) R.id.radio0:
                    burger.setPattyCalories(Burger.BEEF);
                    break;
                case (int) R.id.radio1:
                    burger.setPattyCalories(Burger.LAMB);
                    break;
                case (int) R.id.radio2:
                    burger.setPattyCalories(Burger.ASIAGO);
                    break;
                case (int)R.id.radio3:
                    burger.setCheeseCalories(Burger.ASIAGO);
                    break;
                case (int)R.id.radio4:
                    burger.setCheeseCalories(Burger.CREME_FRAICHE);
            }
            displayCalories();
        }
    };

    private OnClickListener baconListener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            if(((CheckBox) view).isChecked()){
                burger.setProsciuttoCalories(Burger.PROSCIUTTO);
            }else{
                burger.clearProsciuttoCalories();
            }
            displayCalories();
        }
    };

    private OnSeekBarChangeListener sauceListener = new OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            burger.setSauceCalories(seekBar.getProgress());
            displayCalories();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
    private void displayCalories(){
        String calorieText = "Calories: "+burger.getTotalCalories();
        caloriesTV.setText(calorieText);
    }
}