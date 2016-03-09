package com.example.dhanu.storyteller;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class StoryDetails extends AppCompatActivity {

    Button btn, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn = (Button)findViewById(R.id.button3);
        btn2 = (Button)findViewById(R.id.button2);

        viewContributors();
        readTheWholeStory();
    }

    public void viewContributors(){
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogPopUp();
                    }
                }
        );
    }

    public void readTheWholeStory(){
        btn2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        readStory();
                    }
                }
        );
    }

    public void readStory(){
        Intent myIntent = new Intent(this, ReadStory.class);
        this.startActivity(myIntent);
    }

    public void dialogPopUp(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        LayoutInflater inflater = this.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.iii, null));
        builder.show();
    }
}
