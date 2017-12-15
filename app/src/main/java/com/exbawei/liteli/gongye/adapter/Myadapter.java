package com.exbawei.liteli.gongye.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.exbawei.liteli.gongye.R;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

/**
 * Created by li te li on 2017/12/14.
 */

public class Myadapter extends BaseAdapter {
    int [] arr = new int[]{R.drawable.xiaoxi,R.drawable.huati,R.drawable.jianwen,R.drawable.xihuan,R.drawable.fenxiang};
     String [] str={"我的消息","全部话题","我的见闻","我的关注","分享App"};

    Context context;

    public Myadapter(Context context) {

        this.context = context;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=View.inflate(context,R.layout.geitem,null);
        ImageView iv= (ImageView) view.findViewById(R.id.iv);
        TextView tv= (TextView) view.findViewById(R.id.tv);
        iv.setImageResource(arr[position]);
         tv.setText(str[position]);
        return view;
    }
}
