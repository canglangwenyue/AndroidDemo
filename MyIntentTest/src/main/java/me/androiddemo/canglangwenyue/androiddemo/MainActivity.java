package me.androiddemo.canglangwenyue.androiddemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    String[] intentArgs = {"ds","ds"};

    ListView listView ;

    List<String> list = new ArrayList<String>();

    static final int PICK_CONTACT_REQUEST = 1;  // The request code

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i=0;i<intentArgs.length;i++) {
            list.add(intentArgs[i]);
        }

        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list));

//        socialShareIntent();

        pickContact();
    }

    private void pickContact() {

        Uri uri = Uri.parse("content://contacts");
        Intent pickContactIntent = new Intent(Intent.ACTION_PICK, uri);
        pickContactIntent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE); // Show user only contacts w/ phone numbers
        startActivityForResult(pickContactIntent, PICK_CONTACT_REQUEST);
    }


    public void callIntent() {
        Uri number = Uri.parse("tel:18700896480");
        Intent callIntent = new Intent(Intent.ACTION_CALL,number);

        startActivity(callIntent);
    }

    public void socialShareIntent() {
        Intent intent = new Intent(Intent.ACTION_SEND);

// Always use string resources for UI text. This says something like "Share this photo with"
        String title = "Title";
// Create and start the chooser
        Intent chooser = Intent.createChooser(intent, title);
        startActivity(chooser);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == PICK_CONTACT_REQUEST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                String[] projection = {ContactsContract.CommonDataKinds.Phone.NUMBER};
                Toast.makeText(MainActivity.this,projection[0],Toast.LENGTH_LONG).show();
            }
        }

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
