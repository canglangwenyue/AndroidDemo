package me.androiddemo.canglangwenyue.androiddemo;

import android.app.NotificationManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by canglangwenyue on 14-12-9.
 */
public class BaseActivity extends ActionBarActivity {

    public NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * 获取system service以实例化NotificationManager
         */
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

    }

    /**
     * 通过notification的ID来清除它
     * @param notyficationId
     */
    public void clearOneNotificationById(int notyficationId) {
        notificationManager.cancel(notyficationId);
    }


    public void clearAllNotification() {
        notificationManager.cancelAll();
    }

}
