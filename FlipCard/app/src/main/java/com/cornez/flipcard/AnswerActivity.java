package com.cornez.flipcard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AnswerActivity extends Activity {

    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_answer);

        Button questionBtn = (Button)findViewById(R.id.button);
        questionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showQuestion = new Intent(AnswerActivity.this,MainActivity.class);
                startActivity(showQuestion);
            }
        });
    }
    @Override
    protected void onStart(){
        super.onStart();
        overridePendingTransition(R.anim.answer_in,R.anim.question_out);

    }
}
