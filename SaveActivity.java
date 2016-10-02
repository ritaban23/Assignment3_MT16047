package com.example.rivu.stroredata;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SaveActivity extends AppCompatActivity {

    private Button mSave;
    private Button mRetrieve;
    private TextView mName;
    private TextView mEmail;
    private String name;
    private String email;
    SharedPreferences.Editor editor;
    public static final String SHARE = "SHAREDATA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        mSave = (Button)findViewById(R.id.button1);
        mRetrieve = (Button)findViewById(R.id.button2);
        mName = (TextView)findViewById(R.id.textView4);
        mEmail =(TextView)findViewById(R.id.textView5);
        Intent intent = getIntent();
        if(null != intent){
            name = getIntent().getExtras().getString(MainActivity.NAME);
          //  Toast.makeText(getApplicationContext(),name,Toast.LENGTH_SHORT).show();
            email = getIntent().getExtras().getString(MainActivity.EMAIL);
            mName.setText(name);
            mEmail.setText(email);
        }
        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor = getSharedPreferences(SHARE , MODE_PRIVATE).edit();
                editor.putString(MainActivity.NAME, name);
                editor.putString(MainActivity.EMAIL , email);
                editor.commit();
                Toast.makeText(getApplicationContext(),"Temporarily Saved",Toast.LENGTH_SHORT).show();
            }
        });
        mRetrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              SharedPreferences getData = getSharedPreferences(SHARE , MODE_PRIVATE);
               String text = getData.getString(MainActivity.NAME,null);
                if(text != null){
                    String getName = getData.getString(MainActivity.NAME,"Nothing");
                    Toast.makeText(getApplicationContext(),"NAME",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"HEHE",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
