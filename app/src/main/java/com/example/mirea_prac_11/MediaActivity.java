package com.example.mirea_prac_11;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;

public class MediaActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        Button playButton = findViewById(R.id.playButton);
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource("https://file-cdn.online/mobile-rington/_ld/30/3063_call-sound.ru__.mp3");
                    mediaPlayer.prepare(); // Можно использовать prepareAsync() для сетевых потоков
        } catch (IOException e) {
            e.printStackTrace();
        }


        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mediaPlayer.isPlaying() ) {
                    mediaPlayer.start();
                } else {
                    mediaPlayer.pause();
                }

            }
        });


    }


    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    public void stopMedia(View view) {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }


}