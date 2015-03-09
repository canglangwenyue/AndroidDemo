package me.androiddemo.canglangwenyue.androiddemo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements LoadListView.LoadListListener {

    LoadListView loadListView;
    LoadListViewAdapter adapter;
    private ArrayList<TextTitle> titles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadListView = (LoadListView) findViewById(R.id.myLoadListView);
        getData();
        loadListView.setAdapter(adapter);

    }

    private void getData() {
        for (int i = 0; i < 20; i++) {
            TextTitle title = new TextTitle();
            title.setName(String.valueOf(i + 1) + "Load Data");
            titles.add(title);

        }

        showLIstView(titles);
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

    LoadListView listView;

    private void showLIstView(ArrayList<TextTitle> titles) {

        if (adapter == null) {
            listView = (LoadListView) findViewById(R.id.myLoadListView);
            listView.setInterface(this);
            adapter = new LoadListViewAdapter(this, titles);
            listView.setAdapter(adapter);
        } else {
            adapter.onDataChange(titles);
        }

    }

    private void getMoreData() {
        for (int i = 0; i < 5; i++) {
            TextTitle title = new TextTitle();
            title.setName(String.valueOf(i + 1) + "Load More Data");
            titles.add(title);
        }
    }

    @Override
    public void onLoad() {

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                /**
                 * 获取更多数据
                 * 更新ListView显示；
                 */
                getMoreData();
                //更新ListView
                showLIstView(titles);
                //加载完毕
                listView.loadComplete();
            }
        }, 2000);

    }
}
