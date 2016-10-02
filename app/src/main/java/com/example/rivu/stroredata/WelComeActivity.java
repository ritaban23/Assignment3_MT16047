package com.example.rivu.stroredata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WelComeActivity extends AppCompatActivity {

    private TextView text ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wel_come);

        text = (TextView)findViewById(R.id.textView13);
        Intent intent = getIntent();
        if(null != intent){
            String name = intent.getExtras().getString(MainActivity.NAME);
            text.setText(name);
        }
    }
}
