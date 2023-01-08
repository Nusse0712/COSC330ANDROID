package com.cornez.redlandsapp;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.os.Bundle;

public class MainActivity extends Activity {
private Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(findRedland);
    }

    private View.OnClickListener findRedland = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Uri location = Uri.parse("geo:34.0564,-117.2059?z=13");
            Intent map = new Intent(Intent.ACTION_VIEW, location);
            startActivity(map);
        }
    };
}