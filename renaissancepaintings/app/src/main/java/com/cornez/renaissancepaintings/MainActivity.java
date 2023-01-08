package com.cornez.renaissancepaintings;

import android.app.Activity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import android.os.Bundle;

public class MainActivity extends Activity {
    private LinearLayout mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLinearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        fillPaintingGallery();
    }

    private void fillPaintingGallery(){
        ImageButton buttonItem;

        for(int i = 0; i <RenaissanceDatabase.description.length; i++){
            buttonItem = new ImageButton(this);

            Painting painting = new Painting(RenaissanceDatabase.description[i],RenaissanceDatabase.id[i] );

            buttonItem.setContentDescription(painting.getDescription());

            buttonItem.setImageDrawable(getResources().getDrawable(painting.getId()));

            buttonItem.setOnClickListener(displayPaintingInformation);

            mLinearLayout.addView(buttonItem);
        }
    }
    private View.OnClickListener displayPaintingInformation =
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String paintingDescription = (String) view.getContentDescription();
                    displayToast(paintingDescription);

                }
            };
    private void displayToast(String paintingDescription){
        Toast.makeText(this, paintingDescription,Toast.LENGTH_SHORT).show();
    }
}