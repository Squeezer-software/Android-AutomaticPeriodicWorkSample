package com.squeezer.apws;

import java.util.Calendar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * a receiver to initialize the alert manager for periodic tasks
 * 
 * @author Slim BENHAMMOUDA
 * 
 */
public class InitReceiver extends BroadcastReceiver {

    // this value allows to periodically call the service each 1 minute (the
    // specified value is in milliseconds)
    private static final int EXEC_INTERVAL = 60000;

    @Override
    public void onReceive(Context ctx, Intent intent) {
        Log.v("apws", "init Receiver");
        AlarmManager alarmManager = (AlarmManager) ctx
                .getSystemService(Context.ALARM_SERVICE);
        // explicit intent
        Intent reminderSchedulerIntent = new Intent(ctx,
                SchedulerReceiver.class);

        PendingIntent intentExecuted = PendingIntent.getBroadcast(ctx, 0,
                reminderSchedulerIntent, PendingIntent.FLAG_CANCEL_CURRENT);

        Calendar now = Calendar.getInstance();
        // remove milliseconds and seconds for better accuracy
        now.set(Calendar.MILLISECOND, 0);
        now.set(Calendar.SECOND, 0);
        // add 1 minute, we will verify reminders each minute
        now.add(Calendar.MINUTE, 1);

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                now.getTimeInMillis(), EXEC_INTERVAL, intentExecuted);
    }
}
