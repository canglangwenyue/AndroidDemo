package me.androiddemo.canglangwenyue.androiddemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

/**
 * Created by canglangwenyue on 15-3-9.
 */
public class LoadListView extends ListView implements AbsListView.OnScrollListener{

    View footer;//底部布局
    int totalItemCOunt;//总数量
    int lastVisibleItem;//最后一个可见item
    boolean isLoading;//正在加载

    LoadListListener listener;

    public LoadListView(Context context) {
        super(context);
        initView(context);
    }

    public LoadListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public LoadListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    /**
     * 添加底部加载提示布局到ListView
     * @param context
     */

    private void initView(Context context) {

        LayoutInflater inflater = LayoutInflater.from(context);
        footer = inflater.inflate(R.layout.footer_layout,null);

        footer.findViewById(R.id.load_layout).setVisibility(View.GONE);
        this.addFooterView(footer);
        this.setOnScrollListener(this);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (totalItemCOunt == lastVisibleItem&&scrollState ==SCROLL_STATE_IDLE){
            if (!isLoading)
                isLoading=true;
            footer.findViewById(R.id.load_layout).setVisibility(View.VISIBLE);
            //加载更多数据
            listener.onLoad();

        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

        this.lastVisibleItem = firstVisibleItem+visibleItemCount;
        this.totalItemCOunt = totalItemCount;

    }

    /**
     * 加载完毕
     */
    public void loadComplete(){

        isLoading = false;
        footer.findViewById(R.id.load_layout).setVisibility(View.GONE);

    }

    public void setInterface(LoadListListener listener) {
        this.listener = listener;
    }

    //加载更多数据的回调借口
    public interface LoadListListener{

        public void onLoad();

    }



}
