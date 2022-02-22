package com.example.android.justjava;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Hesham on 03-Oct-18.
 */
public class Order_View extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
    }
    public void Order(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
            Toast.makeText(this, "WelCome ;)", Toast.LENGTH_LONG).show();
        }
}