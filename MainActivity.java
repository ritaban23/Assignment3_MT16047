package com.example.rivu.stroredata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button mShared;
    private Button mDatabase;
    private Button mInternal;
    private Button mExternal;
    private EditText mName;
    private EditText mEmail;
    public static final String NAME = "NAME";
    public static final String EMAIL = "EMAIL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShared = (Button)findViewById(R.id.button1);
        mDatabase = (Button)findViewById(R.id.button2);
        mInternal = (Button)findViewById(R.id.button3);
        mExternal =(Button)findViewById(R.id.button4);
        mName = (EditText)findViewById(R.id.editText);
        mEmail = (EditText)findViewById(R.id.editText2);

        mShared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle ();
                Intent intent =  new Intent(getApplicationContext(), SaveActivity.class);
                bundle.putString(NAME , mName.getText().toString());
                bundle.putString(EMAIL , mEmail.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        mDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle ();
                Intent intent =  new Intent(getApplicationContext(), RegActivity.class);
                bundle.putString(NAME , mName.getText().toString());
                bundle.putString(EMAIL , mEmail.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        mInternal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle ();
                Intent intent =  new Intent(getApplicationContext(), SaveActivity2.class);
                bundle.putString(NAME , mName.getText().toString());
                bundle.putString(EMAIL , mEmail.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        mExternal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle ();
                Intent intent =  new Intent(getApplicationContext(), SaveActivity2.class);
                bundle.putString(NAME , mName.getText().toString());
                bundle.putString(EMAIL , mEmail.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }
}
