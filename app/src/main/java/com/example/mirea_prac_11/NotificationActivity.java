package com.example.mirea_prac_11;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NotificationActivity extends AppCompatActivity {
    private static final String CHANNEL_ID = "example_channel";
    public static final String CHANNEL_ID_2 = "delayed_channel";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);


    }

    public void notification(View view) {

        createNotificationChannel();

        NotificationCompat.Builder builder = new NotificationCompat.Builder
                (NotificationActivity.this, CHANNEL_ID)
                .setSmallIcon(R.drawable.utka).
                setContentTitle("Example Notification").
                setContentText("This is a text notification").
                setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.notify(1,builder.build());


    }



    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            CharSequence name = "Example Channel";
            String description = "Channel for example notifications";

            int importance = NotificationManager.IMPORTANCE_DEFAULT;


            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,name,importance);
            channel.setDescription(description);


            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);


        }
    }


    public void createDelayNotification(View view) {
        createNotificationChannel_2();
        scheduleNotification(1000);


    }

    private void createNotificationChannel_2() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Delayed Notifications";
            String description = "Channel for delayed example notifications";

            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID_2,name,importance);
            channel.setDescription(description);


            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }



    private void scheduleNotification(long delay) {
        Intent notificationIntent = new Intent(NotificationActivity.this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast
                (this,0,notificationIntent,PendingIntent
                        .FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        long futureMillis = System.currentTimeMillis() + delay;
        alarmManager.setExact(AlarmManager.RTC_WAKEUP,futureMillis,pendingIntent);
    }



}