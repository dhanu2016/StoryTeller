package com.example.dhanu.storyteller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Contributing extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contributing);

        btn = (Button)findViewById(R.id.button5);
        contribute();
    }

    public void contribute(){
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gotoStoryDetails();
                    }
                }
        );
    }

    public void gotoStoryDetails(){
        Intent myIntent = new Intent(this, StoryDetails.class);
        this.startActivity(myIntent);
    }
}
