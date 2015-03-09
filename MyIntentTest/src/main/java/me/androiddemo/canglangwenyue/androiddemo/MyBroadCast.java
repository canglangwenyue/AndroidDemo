package me.androiddemo.canglangwenyue.androiddemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by canglangwenyue on 15-3-5.
 */
public class MyBroadCast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,intent.getExtras().getString("StringTest"),Toast.LENGTH_LONG).show();
    }
}
