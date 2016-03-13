package com.example.dhanu.storyteller;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StartUp extends AppCompatActivity {
    Button b,Test,start,button11;
    DatabaseHelper mydb;
    EditText editText1,editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=(Button)findViewById(R.id.button);
        Test=(Button)findViewById(R.id.button10);
        mydb = new DatabaseHelper(this);
        button11= (Button) findViewById(R.id.button11);

        editText1= (EditText) findViewById(R.id.editText);
        editText2= (EditText) findViewById(R.id.editText2);
        start = (Button) findViewById(R.id.button);
        AddData();
        searchall();

        Test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),StoryDetails.class);
                startActivity(i);
            }
        });
    }
    public void searchall(){
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor cs= mydb.getAlldata();
                if(cs.getCount()==0){
                    ShowMessage("Error","Nothing Found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (cs.moveToNext()){
                    buffer.append("NAME : "+cs.getString(1)) ;
                }
                ShowMessage("Data",buffer.toString());
            }
        });
    }

    public void ShowMessage(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void AddData(){
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted= mydb.insertdata(editText1.getText().toString(),editText2.getText().toString());

                if(isInserted==true){
                    Toast.makeText(StartUp.this,"Data Inserted",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(StartUp.this,"Data not inserted",Toast.LENGTH_LONG).show();
                    return;
                }
                Intent i=new Intent(getApplicationContext(),Home.class);
                startActivity(i);
            }
        });
    }


}
