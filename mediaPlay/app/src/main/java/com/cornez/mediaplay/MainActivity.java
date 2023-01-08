package com.cornez.mediaplay;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends Activity {

    private Button playButton;
    private Button pauseButton;
    private MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        init();
        setListener();
    }

    private void init(){
        playButton = (Button) findViewById(R.id.playButton);
        pauseButton = (Button) findViewById(R.id.pauseButton);
        player = MediaPlayer.create(this, R.raw.cantinaband);
    }
    private void setListener(){
        playButton.setOnClickListener(playListener);
        pauseButton.setOnClickListener(pauseListener);
    }

    private View.OnClickListener playListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          player.start();
        }
    };
    private View.OnClickListener pauseListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            player.pause();
        }
    };
}