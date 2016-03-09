package com.example.dhanu.storyteller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ReadStory extends AppCompatActivity {

    ImageView back;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_story);

        back = (ImageView)findViewById(R.id.go_back);
        goBack();

        btn = (Button)findViewById(R.id.button6);
        addContributions();
    }

    public void goBack(){
        back.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gotoBack();
                    }
                }
        );
    }

    public void addContributions(){
        btn.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        gotoAddContribution();
                    }
                }
        );
    }

    public void gotoAddContribution(){
        Intent myIntent = new Intent(this, Contributing.class);
        this.startActivity(myIntent);
    }

    public void gotoBack(){
        Intent myIntent = new Intent(this, StoryDetails.class);
        this.startActivity(myIntent);
    }
}
