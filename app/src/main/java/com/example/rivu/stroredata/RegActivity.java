package com.example.rivu.stroredata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegActivity extends AppCompatActivity {

    private TextView text1,text2;
    private Button mSave;
    private String name;
    private String email;
    private EditText password;
    DataUtil dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        text1 = (TextView)findViewById(R.id.textView2);
        text2 = (TextView)findViewById(R.id.textView3);
        mSave = (Button)findViewById(R.id.register);
        password =(EditText)findViewById(R.id.editText3);
        Intent intent =  getIntent();
        if(null != intent){
            name = getIntent().getExtras().getString(MainActivity.NAME);
            //  Toast.makeText(getApplicationContext(),name,Toast.LENGTH_SHORT).show();
            email = getIntent().getExtras().getString(MainActivity.EMAIL);
            text1.setText(name);
            text2.setText(email);
        }
        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dao = new DataUtil(getApplicationContext());
                if(password.getText().toString().equals("") || name.isEmpty() || email.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Empty Field", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(dao.insertInfo(name,email,password.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Done Saving", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(getApplicationContext(),LoginActivity.class);
                        Bundle b = new Bundle();
                        b.putString(MainActivity.NAME, name);
                        intent1.putExtras(b);
                        startActivity(intent1);
                    }
                }
            }
        });
    }
}
