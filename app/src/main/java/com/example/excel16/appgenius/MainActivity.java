package com.example.excel16.appgenius;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText nameEditText, passwordEditText;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameEditText = (EditText) findViewById(R.id.Name1);
        passwordEditText = (EditText) findViewById(R.id.password);
        submitButton = (Button) findViewById(R.id.button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nameEditText.getText().equals("") || passwordEditText.getText().equals("")) {
                    Toast.makeText(MainActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("name", nameEditText.getText().toString());
                    params.put("password", passwordEditText.getText().toString());

                    Serverrequest request = new Serverrequest(MainActivity.this);
                    request.storeuserdatainbackground(params, new Userinterface() {
                        @Override
                        public void done(String str) {
                            SharedPreferences.Editor editor = getSharedPreferences("registeration", MODE_PRIVATE).edit();
                            editor.putString("name", nameEditText.getText().toString());


                            Log.e("hello","");
                            Intent intent=new Intent(MainActivity.this, Listactivity.class);
                            startActivity(intent);
                        }
                    });


                }
            }
        });
        setContentView(R.layout.activity_main);
    }
}
