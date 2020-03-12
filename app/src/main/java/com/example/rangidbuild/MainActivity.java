package com.example.rangidbuild;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
//Variable to store brightness value
private int brightness;
//Content resolver used as a handle to the system's settings
private ContentResolver cResolver;
//Window object, that will store a reference to the current window
private Window window;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button ModusButton = (Button)findViewById(R.id.ModusButton);

        ModusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ButtonClicked.class);
                startActivity(intent);
                finish();
            }
        });
    }
    protected void onStart() {
        super.onStart();


    }
}
