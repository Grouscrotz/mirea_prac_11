package com.example.mirea_prac_11;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RotationActivity extends AppCompatActivity {
    private  ImageView imageView;
    private ObjectAnimator rotateAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotation);

        imageView = findViewById(R.id.imageView);
        rotateAnim = ObjectAnimator.ofFloat(imageView,"rotation",0f,360f);

    }

    public void reverse(View view) {

        rotateAnim.setDuration(2000);
        rotateAnim.setRepeatCount(ObjectAnimator.INFINITE);
        rotateAnim.setRepeatMode(ObjectAnimator.REVERSE);
        rotateAnim.start();
    }
    public void stopReverse(View view) {
        rotateAnim.end();
    }






}