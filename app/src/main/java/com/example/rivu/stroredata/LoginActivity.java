package com.example.rivu.stroredata;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText edit1;
    private EditText edit2;
    private Button button1;
    private String name;
    DataUtil obj ;
    Cursor login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent intent = getIntent();
        if( null != intent){
            name = getIntent().getExtras().getString(MainActivity.NAME);
        }
        edit1 = (EditText)findViewById(R.id.editText1);
        edit2= (EditText)findViewById(R.id.editText2);
        button1 =(Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               obj = new DataUtil(getApplicationContext());
               login =  obj.getPerson(edit1.getText().toString(),edit2.getText().toString());
                if(login.moveToNext()) {
                    Toast.makeText(getApplicationContext(), "Successful Login In", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),WelComeActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString(MainActivity.NAME,name);
                    intent.putExtras(bundle);
                    startActivity(intent);

                }
                else
                    Toast.makeText(getApplicationContext(),"Wrong email or Password",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
