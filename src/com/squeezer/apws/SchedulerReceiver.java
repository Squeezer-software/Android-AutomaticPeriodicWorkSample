package com.squeezer.apws;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Receiver to launch service
 * 
 * @author Slim BENHAMMOUDA
 * 
 */
public class SchedulerReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context ctx, final Intent intent) {

        Intent alertServiceIntent = new Intent(ctx, AlertService.class);
        // start the alert service
        ctx.startService(alertServiceIntent);
    }

}
