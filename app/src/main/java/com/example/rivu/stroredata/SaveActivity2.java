package com.example.rivu.stroredata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SaveActivity2 extends AppCompatActivity {


    private Button mButton2;
    private TextView mtext1;
    private TextView mtext2;
    private String name;
    private String email;
    private Button b1;
 //   private EditText mEditText4;
    private String pickFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save2);
        b1       = (Button) findViewById(R.id.button);
        mButton2 = (Button) findViewById(R.id.button2);
        mtext1 = (TextView) findViewById(R.id.textView8);
        mtext2 = (TextView) findViewById(R.id.textView10);
        //mEditText4 = (EditText) findViewById(R.id.editText4);
        Intent intent = getIntent();
        if (null != intent) {
            name = getIntent().getExtras().getString(MainActivity.NAME);
            email = getIntent().getExtras().getString(MainActivity.EMAIL);
            mtext1.setText(name);
            mtext2.setText(email);
        }   // end of intent

    //    });*/

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    FileOutputStream fileout=openFileOutput("ritaban.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
                    outputWriter.write(name);


                    //display file saved message
                    outputWriter.close();
                    Toast.makeText(getApplicationContext(), "File saved successfully!",Toast.LENGTH_SHORT).show();


                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    FileInputStream fileIn=openFileInput("ritaban.txt");
                    InputStreamReader InputRead= new InputStreamReader(fileIn);

                    char[] inputBuffer= new char[100];
                    String s="";
                    int charRead;

                    while ((charRead=InputRead.read(inputBuffer))>0) {
                        // char to string conversion
                        String readstring=String.copyValueOf(inputBuffer,0,charRead);
                        s +=readstring;
                    }
                    InputRead.close();
                    Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();



                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });


    }

}

