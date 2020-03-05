package com.example.library.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.library.R;
import com.example.library.displayData;
import com.example.library.thirdActivity;

public class secondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void second(View view) {


    }

    public void third(View view) {
        Intent i1 = new Intent(secondActivity.this, displayData.class);
        startActivity(i1);
    }

    public void fourth(View view) {
        Intent i = new Intent(secondActivity.this, thirdActivity.class);
        startActivity(i);
    }

    public void fifth(View view) {
    }

    public void sixth(View view) {

    }
}
