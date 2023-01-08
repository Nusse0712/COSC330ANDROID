package com.cornez.paintscene;

import android.app.Activity;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;


public class MainActivity extends Activity {
    ViewGroup paintingContainer;
    Transition transition;

    Scene activeScene;
    Scene passiveScene;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        paintingContainer = (ViewGroup) findViewById(R.id.painting_container);
        transition = TransitionInflater.from(this).inflateTransition(R.transition.transition);
        activeScene = Scene.getSceneForLayout(paintingContainer,R.layout.scene01,this);
        passiveScene = Scene.getSceneForLayout(paintingContainer,R.layout.scene2,this);
        activeScene.enter();
    }
    public void changeScenes(View view){
        Scene temp = passiveScene;
        passiveScene = activeScene;
        activeScene = temp;
        TransitionManager.go(activeScene, transition);
    }


}