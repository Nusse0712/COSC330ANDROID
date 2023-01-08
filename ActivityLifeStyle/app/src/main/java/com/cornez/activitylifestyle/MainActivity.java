package com.cornez.activitylifestyle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;



public class MainActivity extends Activity {

    private String createMessage;
    private String startMessage;
    private String resumeMessage;
    private String pauseMessage;
    private String stopMessage;
    private String restartMessage;
    private String msg = "Activity:";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        initializeMessages();
        Toast.makeText(this,createMessage, Toast.LENGTH_LONG).show();
        Log.d(msg, createMessage);
    }

    private void initializeMessages(){
        createMessage = (String)
                getResources().getText(R.string.create_message);
        startMessage = (String)
                getResources().getText(R.string.start_message);
        resumeMessage = (String)
                getResources().getText(R.string.resume_message);
        pauseMessage = (String)
                getResources().getText(R.string.pause_message);
        stopMessage = (String)
                getResources().getText(R.string.stop_message);
        restartMessage = (String)
                getResources().getText(R.string.restart_message);

    }

    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(this, startMessage, Toast.LENGTH_LONG).show();
        Log.d(msg, startMessage);
    }

    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(this, resumeMessage, Toast.LENGTH_LONG).show();
        Log.d(msg, resumeMessage);
    }
    @Override
    protected void onPause(){
        super.onPause();
        Toast.makeText(this, pauseMessage, Toast.LENGTH_LONG).show();
        Log.d(msg, pauseMessage);
    }


    @Override
    protected void onRestart(){
        super.onRestart();
        Toast.makeText(this, restartMessage, Toast.LENGTH_LONG).show();
        Log.d(msg, restartMessage);
    }

    @Override
    protected void onStop(){
        super.onStop();
        Toast.makeText(this, stopMessage, Toast.LENGTH_LONG).show();
        Log.d(msg, stopMessage);
    }



}