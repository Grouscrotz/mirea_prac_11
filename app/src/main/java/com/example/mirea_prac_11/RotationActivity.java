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
    private ObjectAnimator moveAnim;
    private ObjectAnimator scaleX;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotation);

        imageView = findViewById(R.id.imageView);
        // Объект для вращения
        rotateAnim = ObjectAnimator.ofFloat(imageView,"rotation",0f,360f);
        // Объект для перемещения по x
        moveAnim = ObjectAnimator.ofFloat(imageView,"translationX",0f,300f);
        // Объект для изменения размера
        scaleX = ObjectAnimator.ofFloat(imageView,"scaleX",1f,2f);


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

    public void movement(View view) {
        moveAnim.setDuration(2000);

        moveAnim.setRepeatCount(ObjectAnimator.INFINITE);
        moveAnim.setRepeatMode(ObjectAnimator.REVERSE);

        moveAnim.start();
    }

    // *? Как вернуть в исходное положение
    public void stopMovement(View view) {
        moveAnim.end();

    }

    public void inflate(View view) {
        scaleX.setDuration(1000);
        scaleX.start();
    }

    // *? Как вернуть в исходное положение
    public void narrowGuse(View view) {
        scaleX.end();

    }




}