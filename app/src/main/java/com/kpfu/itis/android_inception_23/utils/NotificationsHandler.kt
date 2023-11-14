package com.kpfu.itis.android_inception_23.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.kpfu.itis.android_inception_23.MainActivity
import com.kpfu.itis.android_inception_23.R

class NotificationsHandler {

    fun createNotification(ctx: Context, id: Int) {
        (ctx.getSystemService(Context.NOTIFICATION_SERVICE) as? NotificationManager)?.let { manager ->
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channel = NotificationChannel(
                    "first_notification_channel",
                    "Канал уведомлений",
                    NotificationManager.IMPORTANCE_DEFAULT
                )
                manager.createNotificationChannel(channel)
            }

            val intent = Intent(ctx, MainActivity::class.java)

            val pendingIntent = PendingIntent.getActivity(
                ctx,
                101,
                intent,
                PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE
            )

            val notification = NotificationCompat.Builder(ctx, "first_notification_channel")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Notification title")
                .setContentText("Message")
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)

            manager.notify(id, notification.build())
        }
    }
}