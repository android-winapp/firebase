package net.simplifiedcoding.firebasepushnotification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Winapp on 19-Jun-17.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {
    Context mContext;
    @Override
    public void onReceive(Context context, Intent intent) {

        this.mContext = context;
//        Toast.makeText(context,"Firebase Application Restarted",Toast.LENGTH_LONG).show();
//        Intent startServiceIntent = new Intent(mContext, MainActivity.class);
//        mContext.startService(startServiceIntent);

        if(isRegistered()){
            context.startService(new Intent(context, NotificationListener.class));
        }
    }

    private boolean isRegistered() {
        //Getting shared preferences
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(Constants.SHARED_PREF, MODE_PRIVATE);

        //Getting the value from shared preferences
        //The second parameter is the default value
        //if there is no value in sharedprference then it will return false
        //that means the device is not registered
        return sharedPreferences.getBoolean(Constants.REGISTERED, false);
    }
}
