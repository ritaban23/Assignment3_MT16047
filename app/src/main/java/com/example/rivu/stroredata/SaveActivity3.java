package com.example.rivu.stroredata;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class SaveActivity3 extends AppCompatActivity {

    private Button mSave;
    private Button mRetrieve;
    private TextView mtext1;
    private TextView mtext2;
    private String name;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save3);

        mSave = (Button)findViewById(R.id.button);      // setting the ID
        mRetrieve = (Button)findViewById(R.id.button1);
        mtext1 = (TextView) findViewById(R.id.textView8);
        mtext2 = (TextView) findViewById(R.id.textView10);

        Intent intent = getIntent();
        if (null != intent) {
            name = getIntent().getExtras().getString(MainActivity.NAME);      // fetching name
            email = getIntent().getExtras().getString(MainActivity.EMAIL);    //fetching email
            mtext1.setText(name);
            mtext2.setText(email);
        }   // end of intent

        //save in the external card
        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file;
                FileOutputStream outputStream;
                try {
                    file = new File(Environment.getExternalStorageDirectory(), "MyFile.txt");
                    outputStream = new FileOutputStream(file);
                    outputStream.write(name.getBytes());
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        // Retrieve the data from the external
        mRetrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = new File(Environment.getExternalStorageDirectory(),"MyFile.txt");
                StringBuffer buffer = new StringBuffer();
                try {
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String append="";
                    while( br.readLine() !=null){
                        append = buffer.append(br.readLine()).toString();
                    }
                    br.close();
                    Toast.makeText(getApplicationContext(),append , Toast.LENGTH_SHORT).show();
                }catch(Exception e){
                    e.getMessage();
                }

            }
        });



    }
}
