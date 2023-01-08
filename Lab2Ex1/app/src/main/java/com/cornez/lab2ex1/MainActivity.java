package com.cornez.lab2ex1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
    private TextView hungryView;
    private ImageView image;
    private Button button1;
    private CookieMonster cookie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);


        cookie = new CookieMonster();
        initialize();
        setOnclickListeners();

    }
    private final View.OnClickListener toggle = new View.OnClickListener() {
        @Override
        public void onClick(View btn) {
            if(cookie.getStatus() == true){
                cookie.getFull();
                button1.setText(R.string.full_btn);
                hungryView.setText(R.string.fullTxt);
                image.setImageResource(R.mipmap.full);
            }else{
                cookie.getHungry();
                button1.setText(R.string.hungry_btn);
                hungryView.setText(R.string.hungryTxt);
                image.setImageResource(R.mipmap.hungry);
            }

        }
    };

    private void initialize(){
        hungryView = (TextView) findViewById(R.id.textView1);
        image = (ImageView) findViewById(R.id.imageView1);
        button1 = (Button) findViewById(R.id.button1);
    }

    private void setOnclickListeners(){
        button1.setOnClickListener(toggle);
    }
}