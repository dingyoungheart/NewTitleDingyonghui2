package com.dingyonghui.newtitledingyonghui.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dingyonghui.newtitledingyonghui.R;
import com.dingyonghui.newtitledingyonghui.bean.NewsBean;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

/**
 * Created by lx on 2017/2/15.
 */

public class PullToRefreshAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<NewsBean> newsBeen = new ArrayList<>();
    private NewsBean bean;
    private DisplayImageOptions options;
    final int TYPE_1 = 0;
    final int TYPE_2 = 1;
    final int TYPE_3 = 2;
    final int TYPE_4 = 3;
    private SharedPreferences sp;
    private boolean isNight;


    public PullToRefreshAdapter(Context mContext) {
        this.mContext = mContext;
        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher)
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .showImageOnFail(R.mipmap.ic_launcher)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                //.displayer(new CircleBitmapDisplayer(Color.WHITE, 5))
                .build();
    }

    @Override
    public int getViewTypeCount() {
        return 4;
    }

    @Override
    public int getItemViewType(int position) {

        int type = 0;
        bean = newsBeen.get(position);
        if (newsBeen.get(position).getImgsrc() == null) {
            return TYPE_1;
        } else if (newsBeen.get(position).getTopic_background() == null && newsBeen.get(position).getSkipID() != null) {
            return TYPE_2;
        } else if (newsBeen.get(position).getSkipID() == null) {
            return TYPE_3;
        } else if (newsBeen.get(position).getImgextra() != null && newsBeen.get(position).getImgextra().size() > 0 && newsBeen.get(position).getTopic_background() != null) {
            return TYPE_4;
        }

        return type;
    }

    @Override
    public int getCount() {
        return newsBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return newsBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        ViewHolder viewHolder=null;
        ViewHolder2 viewHolder2=null;
        ViewHolder3 viewHolder3=null;
        ViewHolder4 viewHolder4=null;


        sp = mContext.getSharedPreferences("night", mContext.MODE_PRIVATE);
        boolean isNight = sp.getBoolean("isNight",false);



        if (convertView == null) {
            switch (type) {
                case 0:
                    convertView = View.inflate(mContext, R.layout.titlelistview_item1, null);
                    viewHolder = new ViewHolder();
                    viewHolder.tv_item1_title = (TextView) convertView.findViewById(R.id.tv_item1_title);
                    viewHolder.tv_item1_author = (TextView) convertView.findViewById(R.id.tv_item1_author);
                    viewHolder.tv_item1_pinglun = (TextView) convertView.findViewById(R.id.tv_item1_pinglun);
                    convertView.setTag(viewHolder);

                    break;
                case 3:
                    convertView = View.inflate(mContext, R.layout.titlelistview_item4, null);
                    viewHolder4 = new ViewHolder4();
                    viewHolder4.item4_iv1 = (ImageView) convertView.findViewById(R.id.item4_iv1);
                    viewHolder4.item4_iv2 = (ImageView) convertView.findViewById(R.id.item4_iv2);
                    viewHolder4.tv_item4_title = (TextView) convertView.findViewById(R.id.tv_item4_title);
                    viewHolder4.tv_item4_author = (TextView) convertView.findViewById(R.id.tv_item4_author);
                    viewHolder4.tv_item4_pinglun = (TextView) convertView.findViewById(R.id.tv_item4_pinglun);
                    viewHolder4.tv_item4_time = (TextView) convertView.findViewById(R.id.tv_item4_time);
                    convertView.setTag(viewHolder4);


                    break;
                case 2:
                    convertView = View.inflate(mContext, R.layout.titlelistview_item2, null);
                    viewHolder3 = new ViewHolder3();
                    viewHolder3.tv_item2_title = (TextView) convertView.findViewById(R.id.tv_item2_title);
                    viewHolder3.tv_item2_author = (TextView) convertView.findViewById(R.id.tv_item2_author);
                    viewHolder3.tv_item2_punglun = (TextView) convertView.findViewById(R.id.tv_item2_pinglun);
                    viewHolder3.tv_item2_time = (TextView) convertView.findViewById(R.id.tv_item2_time);
                    viewHolder3.item2_iv = (ImageView) convertView.findViewById(R.id.item2_iv);
                    convertView.setTag(viewHolder3);

                    break;

                case 1:
                    convertView = View.inflate(mContext, R.layout.titlelistview_item3, null);
                    viewHolder2 = new ViewHolder2();
                    viewHolder2.tv_item3_title = (TextView) convertView.findViewById(R.id.tv_item3_title);
                    viewHolder2.tv_item3_author = (TextView) convertView.findViewById(R.id.tv_item3_author);
                    viewHolder2.tv_item3_punglun = (TextView) convertView.findViewById(R.id.tv_item3_punglun);
                    viewHolder2.tv_item3_time = (TextView) convertView.findViewById(R.id.tv_item3_time);
                    viewHolder2.item3_iv = (ImageView) convertView.findViewById(R.id.item3_iv);
                    convertView.setTag(viewHolder2);

                    break;
            }
        }else {
            switch (type){
                case 0:
                    viewHolder=(ViewHolder) convertView.getTag();
                    break;
                case 1:
                    viewHolder2=(ViewHolder2) convertView.getTag();
                    break;
                case 2:
                    viewHolder3=(ViewHolder3) convertView.getTag();
                    break;
                case 3:
                    viewHolder4=(ViewHolder4) convertView.getTag();
                    break;
            }
        }
        switch (type){
            case 0:
                viewHolder.tv_item1_title.setText(bean.getTitle());
                viewHolder.tv_item1_author.setText(bean.getSource());
                viewHolder.tv_item1_pinglun.setText("评论数:" + bean.getReplyCount());
                if (!isNight) {
                    viewHolder.tv_item1_title.setTextColor(mContext.getResources().getColor(R.color.black_tx_color));
                    viewHolder.tv_item1_author.setTextColor(mContext.getResources().getColor(R.color.black_tx_color));
                    viewHolder.tv_item1_pinglun.setTextColor(mContext.getResources().getColor(R.color.black_tx_color));

                }else {
                    viewHolder.tv_item1_title.setTextColor(mContext.getResources().getColor(R.color.white_tx_color));
                    viewHolder.tv_item1_author.setTextColor(mContext.getResources().getColor(R.color.white_tx_color));
                    viewHolder.tv_item1_pinglun.setTextColor(mContext.getResources().getColor(R.color.white_tx_color));
                }
                break;
            case 1:
                viewHolder2.tv_item3_title.setText(bean.getTitle());
                viewHolder2.tv_item3_author.setText(bean.getSource());
                viewHolder2.tv_item3_punglun.setText("评论数:" + bean.getReplyCount());
                viewHolder2.tv_item3_time.setText(bean.getPtime());
                ImageLoader.getInstance().displayImage(bean.getImgsrc(), viewHolder2.item3_iv, options);
                if (!isNight) {
                    viewHolder2.tv_item3_title.setTextColor(mContext.getResources().getColor(R.color.black_tx_color));
                    viewHolder2.tv_item3_author.setTextColor(mContext.getResources().getColor(R.color.black_tx_color));
                    viewHolder2.tv_item3_punglun.setTextColor(mContext.getResources().getColor(R.color.black_tx_color));
                    viewHolder2.tv_item3_time.setTextColor(mContext.getResources().getColor(R.color.black_tx_color));

                }else {
                    viewHolder2.tv_item3_title.setTextColor(mContext.getResources().getColor(R.color.white_tx_color));
                    viewHolder2.tv_item3_author.setTextColor(mContext.getResources().getColor(R.color.white_tx_color));
                    viewHolder2.tv_item3_punglun.setTextColor(mContext.getResources().getColor(R.color.white_tx_color));
                    viewHolder2.tv_item3_time.setTextColor(mContext.getResources().getColor(R.color.white_tx_color));
                }
                break;
            case 2:
                viewHolder3.tv_item2_title.setText(bean.getTitle());
                viewHolder3.tv_item2_author.setText(bean.getSource());
                viewHolder3.tv_item2_punglun.setText("评论数:" + bean.getReplyCount());
                viewHolder3.tv_item2_time.setText(bean.getPtime());
                ImageLoader.getInstance().displayImage(newsBeen.get(position).getImgsrc(), viewHolder3.item2_iv, options);
                if (!isNight) {
                    viewHolder3.tv_item2_title.setTextColor(mContext.getResources().getColor(R.color.black_tx_color));
                    viewHolder3.tv_item2_author.setTextColor(mContext.getResources().getColor(R.color.black_tx_color));
                    viewHolder3.tv_item2_punglun.setTextColor(mContext.getResources().getColor(R.color.black_tx_color));
                    viewHolder3.tv_item2_time.setTextColor(mContext.getResources().getColor(R.color.black_tx_color));

                }else {
                    viewHolder3.tv_item2_title.setTextColor(mContext.getResources().getColor(R.color.white_tx_color));
                    viewHolder3.tv_item2_author.setTextColor(mContext.getResources().getColor(R.color.white_tx_color));
                    viewHolder3.tv_item2_punglun.setTextColor(mContext.getResources().getColor(R.color.white_tx_color));
                    viewHolder3.tv_item2_time.setTextColor(mContext.getResources().getColor(R.color.white_tx_color));
                }
                break;
            case 3:
                ImageLoader.getInstance().displayImage(newsBeen.get(0).getImgextra().get(0).getImgsrc(), viewHolder4.item4_iv1, options);
                ImageLoader.getInstance().displayImage(newsBeen.get(0).getImgextra().get(1).getImgsrc(), viewHolder4.item4_iv2, options);
//                ImageLoader.getInstance().displayImage(newsBeen.get(position).getImgextra().get((position+2)%bean.getImgextra().size()).getImgsrc(),viewHolder4.,options);
                viewHolder4.tv_item4_title.setText(bean.getTitle());
                viewHolder4.tv_item4_author.setText(bean.getSource());
                viewHolder4.tv_item4_pinglun.setText("评论数:" + bean.getReplyCount());
                viewHolder4.tv_item4_time.setText(bean.getPtime());
                if (!isNight) {
                    viewHolder4.tv_item4_title.setTextColor(mContext.getResources().getColor(R.color.black_tx_color));
                    viewHolder4.tv_item4_author.setTextColor(mContext.getResources().getColor(R.color.black_tx_color));
                    viewHolder4.tv_item4_pinglun.setTextColor(mContext.getResources().getColor(R.color.black_tx_color));
                    viewHolder4.tv_item4_time.setTextColor(mContext.getResources().getColor(R.color.black_tx_color));

                }else {
                    viewHolder4.tv_item4_title.setTextColor(mContext.getResources().getColor(R.color.white_tx_color));
                    viewHolder4.tv_item4_author.setTextColor(mContext.getResources().getColor(R.color.white_tx_color));
                    viewHolder4.tv_item4_pinglun.setTextColor(mContext.getResources().getColor(R.color.white_tx_color));
                    viewHolder4.tv_item4_time.setTextColor(mContext.getResources().getColor(R.color.white_tx_color));
                }
                break;
        }

        return convertView;

    }


    class ViewHolder {
        TextView tv_item1_title;
        TextView tv_item1_author;
        TextView tv_item1_pinglun;
    }

    class ViewHolder2 {
        TextView tv_item3_title;
        TextView tv_item3_author;
        TextView tv_item3_punglun;
        TextView tv_item3_time;
        ImageView item3_iv;
    }

    class ViewHolder3 {
        TextView tv_item2_title;
        TextView tv_item2_author;
        TextView tv_item2_punglun;
        TextView tv_item2_time;
        ImageView item2_iv;
    }

    class ViewHolder4 {
        ImageView item4_iv1;
        ImageView item4_iv2;
        TextView tv_item4_title;
        TextView tv_item4_author;
        TextView tv_item4_pinglun;
        TextView tv_item4_time;
    }


    public void addData(ArrayList<NewsBean> datas, boolean isNeedClear) {

        if (datas != null) {
            if (isNeedClear) {
                newsBeen.clear();
            }
            newsBeen.addAll(datas);
            Log.d("MyMessage", "newsbean size " + newsBeen.size());
        }

    }

}
