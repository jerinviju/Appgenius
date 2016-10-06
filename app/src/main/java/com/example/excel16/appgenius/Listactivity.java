package com.example.excel16.appgenius;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Listactivity extends AppCompatActivity {
 TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listactivity);
        text=(TextView) findViewById(R.id.input_layout_name1);
        SharedPreferences prefs = getSharedPreferences("regiteration", MODE_PRIVATE);
              text.setText(prefs.getString("name", null));

    }
}
