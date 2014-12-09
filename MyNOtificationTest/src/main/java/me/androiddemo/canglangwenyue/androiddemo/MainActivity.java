package me.androiddemo.canglangwenyue.androiddemo;

import android.app.NotificationManager;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {


    private Button simpleNotyButton;

    private NotificationManager manager;

    NotificationCompat.Builder notifyBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        simpleNotyButton = (Button) findViewById(R.id.simpleNotification);
        simpleNotyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"hihi",Toast.LENGTH_LONG).show();
                simNotification(v);
            }
        });

    }



    public void simNotification(View v) {


        Toast.makeText(this,"hha",Toast.LENGTH_LONG).show();

        notifyBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle("通知")
                .setContentText("Hello world");
        manager.notify(100, notifyBuilder.build());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
