package me.androiddemo.canglangwenyue.androiddemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by canglangwenyue on 15-3-9.
 */
public class LoadListViewAdapter extends BaseAdapter {

    private List<TextTitle> items;
    private LayoutInflater inflater;

    public LoadListViewAdapter(Context context, List<TextTitle> items) {
        this.items = items;
        inflater = LayoutInflater.from(context);
    }


    public void onDataChange(ArrayList<TextTitle> titles) {
        this.items = titles;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (getCount() == 0) {
            return null;
        }

        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.taskitem, null);

            holder = new ViewHolder();
            holder.textView = (TextView) convertView.findViewById(R.id.title_text);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textView.setText(items.get(position).getName());


        return convertView;
    }

    public class ViewHolder {
        TextView textView;

        public TextView getTextView() {
            return textView;
        }

        public void setTextView(TextView textView) {
            this.textView = textView;
        }
    }

}
