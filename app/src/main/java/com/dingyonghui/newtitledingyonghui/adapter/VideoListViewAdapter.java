package com.dingyonghui.newtitledingyonghui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dingyonghui.newtitledingyonghui.R;
import com.dingyonghui.newtitledingyonghui.bean.VideoBean;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;

import java.util.ArrayList;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;



/**
 * Created by lx on 2017/2/23.
 */

public class VideoListViewAdapter extends BaseAdapter{
    private Context context;
    private DisplayImageOptions options;
    private ArrayList<VideoBean> list=new ArrayList<>();


    public VideoListViewAdapter(Context context) {
        this.context=context;
        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher)
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .showImageOnFail(R.mipmap.ic_launcher)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .displayer(new CircleBitmapDisplayer(Color.WHITE, 5))
                .build();



    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            convertView=View.inflate(context,R.layout.video_title_item,null);
        viewHolder = new ViewHolder();
        viewHolder.iv_video = (ImageView) convertView.findViewById(R.id.iv_video);
        viewHolder.jiecao= (JCVideoPlayer) convertView.findViewById(R.id.jiecao);
        viewHolder.source_video= (TextView) convertView.findViewById(R.id.source_video);
        viewHolder.comcount_video= (TextView) convertView.findViewById(R.id.comcount_video);
//        viewHolder.iv_comment = (ImageView) convertView.findViewById(R.id.iv_comment);
//        viewHolder.iv_more= (ImageView) convertView.findViewById(R.id.iv_more);
        viewHolder.count_video= (TextView) convertView.findViewById(R.id.count_video);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.jiecao.setUp(list.get(position).getMp4_url(), list.get(position).getTitle());
        ImageLoader.getInstance().displayImage(list.get(position).getCover(),viewHolder.jiecao.ivThumb);
//        viewHolder.jiecao.ivThumb.setImageURI(list.get(position).getCover());

        ImageLoader.getInstance().displayImage(list.get(position).getTopicImg(),viewHolder.iv_video,options);
        viewHolder.source_video.setText(list.get(position).getVideosource());
//        viewHolder.comcount_video.setText(list.get(position).getLength());
        viewHolder.count_video.setText(list.get(position).getLength()+"万次播放");
        return convertView;
    }



    class ViewHolder{
        JCVideoPlayer jiecao;
        ImageView iv_video;
        TextView source_video;
        TextView count_video;
        ImageView iv_comment;
        TextView comcount_video;
        ImageView iv_more;
    }

    public void AddData(ArrayList<VideoBean> datas,boolean isNeedClear){
        if (datas!=null){
            if (isNeedClear){
                list.clear();
            }
         list.addAll(datas);

        }
    }
}
