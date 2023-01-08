 package com.cornez.bullseye;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends Activity {
    private TextView levelText;
    private Integer level;
    private RelativeLayout relativeLayout;
    private FractalView fractal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        fractal = new FractalView(this);
        relativeLayout.addView(fractal, 0);
        level = 1;
        levelText = (TextView) findViewById(R.id.textView1);
    }
    public void drawFractal(View view){
        fractal.level = level;
        fractal.invalidate();
    }
    public void stepUp(View view){
        if (level < 14) {
            level++;
            levelText.setText(level.toString());
        }
    }
    public void stepDown(View view){
        if(level > 1){
            level--;
            levelText.setText(level.toString());
        }
    }
}