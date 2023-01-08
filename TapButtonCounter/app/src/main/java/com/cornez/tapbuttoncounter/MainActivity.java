package com.cornez.tapbuttoncounter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.util.Log;



public class MainActivity extends Activity {

    private Counter count;
    private TextView countView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        count = new Counter();

        countView = (TextView) findViewById(R.id.textView);

    }

    public void countTap(View view){
        count.addCount();
        countView.setText(count.getCount().toString());
        final String TAG = "MyActivity";
        Log.i(TAG,"Cole Nussear: "+ count.getCount().toString());
    }


}