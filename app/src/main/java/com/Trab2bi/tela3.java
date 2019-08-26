package com.Trab2bi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class tela3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);
        Intent intent2 = getIntent();
        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                notificacao();
            }
        });
    }

    private void notificacao() {
        EditText text = (EditText)findViewById(R.id.editText);
        String value = text.getText().toString();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("my_channel_id", "my_channel", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            nm.createNotificationChannel(channel);
        }
        NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(this,"my_channel_id");
        nBuilder.setSmallIcon(R.drawable.icone);
        nBuilder.setContentTitle("Pedido a caminho");
        nBuilder.setContentText("O seu pedido esta sendo preparado " + value);
        nBuilder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(666, nBuilder.build());
    }
}
