package com.squeezer.apws;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Service responsible for firing alerts
 * 
 * @author Slim BENHAMMOUDA
 * 
 */
public class AlertService extends Service {

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public int onStartCommand(final Intent intent, final int flags,
            final int startId) {
        Log.v("apws", "AlertService fired");

        // //////////////////////////////////////
        // ADD HERE WHAT YOU WANT TO DO
        // //////////////////////////////////////

        return Service.START_NOT_STICKY;
    }
}
