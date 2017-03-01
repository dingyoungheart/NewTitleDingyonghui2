package com.dingyonghui.mylibrary;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by liqingyi on 2017/1/4.
 */

public class ChangeAdapter extends BaseAdapter {

    LayoutInflater inflater;
    Activity activity;
    ArrayList<String> list;

    boolean isNight = false;

    public ChangeAdapter(Activity activity) {
        this.activity = activity;
        this.inflater = LayoutInflater.from(activity);
        this.list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i + "");
        }
    }

    /**
     * 设置夜间模式
     * @param isNight
     */
    public void setNight(boolean isNight) {
        this.isNight = isNight;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public String getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_text, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        /**
         * 根据模式加载相应资源:资源在values colors.xml
         */
        if (isNight) {
            holder.layout.setBackgroundColor(activity.getResources().getColor(R.color.night_layout_bg));
            holder.textView.setTextColor(activity.getResources().getColor(R.color.white_tx_color));
        } else {
            holder.layout.setBackgroundColor(activity.getResources().getColor(R.color.day_layout_bg));
            holder.textView.setTextColor(activity.getResources().getColor(R.color.black_tx_color));
        }

        holder.textView.setText(getItem(position));
        return convertView;
    }

    class ViewHolder {
        LinearLayout layout;
        TextView textView;

        public ViewHolder(View convertView) {
            layout = (LinearLayout) convertView.findViewById(R.id.layout);
            textView = (TextView) convertView.findViewById(R.id.textView);
        }
    }
}
