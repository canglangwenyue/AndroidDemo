package me.androiddemo.canglangwenyue.androiddemo;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {


    static final int PICK_CONTACT_REQUEST = 1;  // The request code
    static final int REQUEST_CODE = 100;

    IntentFilter filter = new IntentFilter();
    private MyBroadCast broadCast = new MyBroadCast();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filter.addAction("MyBroadCast");
        registerReceiver(broadCast, filter);

    }

    public void ButtonClick1(View view) {

        Intent intent = new Intent();
        intent.setClass(MainActivity.this, Activity2.class);
        startActivityForResult(intent, REQUEST_CODE);

    }


    public void ButtonClick2(View view) {

        Intent intent_BroaadCast = new Intent("Intent_1112");
        intent_BroaadCast.putExtra("StringTest", "LA_LA_LA");
        MainActivity.this.sendBroadcast(intent_BroaadCast);
    }

    public void ButtonClick3(View view) {

        Intent intent_ActiveBroaadCast = new Intent();
        intent_ActiveBroaadCast.putExtra("StringTest", "阿哈");
        intent_ActiveBroaadCast.setAction("MyBroadCast");
        MainActivity.this.sendBroadcast(intent_ActiveBroaadCast);
    }

    public void ButtonClick4(View view) {

        /**
         * 注意：
         * 此处因为有动态声明的BroadCastReceiver，所以运行改方法后程序会奔溃，但是此处因为时范例，便于对比，所以我并没有新建project
         */

        Intent intent_ActiveBroaadCast = new Intent("myTest111");
        intent_ActiveBroaadCast.putExtra("StringTest", "德玛西亚");
        MainActivity.this.startActivity(intent_ActiveBroaadCast);
    }

    public void ButtonClick5(View view) {

        Uri uri = Uri.parse("content://contacts");
        Intent pickContactIntent = new Intent(Intent.ACTION_PICK, uri);
        pickContactIntent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE); // Show user only contacts w/ phone numbers
        startActivityForResult(pickContactIntent, PICK_CONTACT_REQUEST);
    }


    public void ButtonClick7(View view) {
        Uri number = Uri.parse("tel:18700896480");
        Intent callIntent = new Intent(Intent.ACTION_CALL, number);

        startActivity(callIntent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                Toast.makeText(MainActivity.this, data.getExtras().getString("String222"), Toast.LENGTH_LONG).show();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);

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

    @Override
    protected void onStop() {
        unregisterReceiver(broadCast);
        super.onStop();
    }

}
