package com.example.powerstation.traceparsingxml;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Create the text view

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setTextSize(30);
        textView.setText(message);

        // Set the text view as the activity layout

        //setContentView(textView);

    }


    public void buyBtnAction(View view) {
        Toast.makeText(this, "Ok" ,
                       Toast.LENGTH_SHORT).show();
        Intent buyBtnAction = new Intent(this, MainActivity.class);
        startActivity(buyBtnAction);

    }
}


