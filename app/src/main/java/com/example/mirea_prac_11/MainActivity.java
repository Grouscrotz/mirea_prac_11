package com.example.mirea_prac_11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void toWebView(View view) {
        Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
        startActivity(intent);

    }

    public void toMediaPlayer(View view) {
        Intent intent = new Intent(MainActivity.this, MediaActivity.class);
        startActivity(intent);

    }

    public void toRotationActivity(View view) {
        Intent intent = new Intent(MainActivity.this, RotationActivity.class);
        startActivity(intent);

    }






}