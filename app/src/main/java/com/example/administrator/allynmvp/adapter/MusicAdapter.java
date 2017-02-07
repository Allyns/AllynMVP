package com.example.administrator.allynmvp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.administrator.allynmvp.R;
import com.example.administrator.allynmvp.bean.MusicItem;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/2/6.
 */

public class MusicAdapter extends ArrayAdapter<MusicItem> {

    Context context;
    ArrayList<MusicItem> list;
    int resourceId;

    public MusicAdapter(Context context, int resource, ArrayList<MusicItem> list) {
        super(context, resource);
        this.context = context;
        this.list = list;
        this.resourceId=resource;
    }

    @NonNull
    @Override
    public Context getContext() {
        return context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    public ArrayList<MusicItem> getList() {
        return list;
    }

    @Nullable
    @Override
    public MusicItem getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MusicItem item = list.get(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(resourceId, null);
            viewHolder.name = (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.singer = (TextView) convertView.findViewById(R.id.tv_singer);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.name.setText(item.getName());
        viewHolder.singer.setText(item.getSinger());
        return convertView;
    }

    public class ViewHolder {
        TextView name;
        TextView singer;
    }
}
