package com.exbawei.liteli.gongye.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.exbawei.liteli.gongye.R;
import com.exbawei.liteli.gongye.bean.MyBean;

import java.util.ArrayList;
import java.util.List;

import static com.exbawei.liteli.gongye.R.id.iv;

/**
 * Created by li te li on 2017/12/14.
 */

public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.ViewHolder> {
    List<MyBean.DataBean.ArticleBean> list =new ArrayList<>();
    Context context;

    public MyRecycleViewAdapter(List<MyBean.DataBean.ArticleBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =View.inflate(context,R.layout.recycleviewitem,null);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv.setText(list.get(position).getSummary());
        Glide.with(context).load(list.get(position).getFace()).into(holder.iv);
          holder.tv1.setText(list.get(position).getUpvote());
        holder.tv2.setText(list.get(position).getComment_count());
        holder.tv3.setText("时间："+list.get(position).getCreate_time());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        TextView tv1;
        TextView tv2;
        TextView tv3;
        ImageView iv;
        public ViewHolder(View itemView) {
            super(itemView);
             tv= (TextView) itemView.findViewById(R.id.textView);
             iv= (ImageView) itemView.findViewById(R.id.ivrv);
             tv1= (TextView) itemView.findViewById(R.id.item1_tv1);
             tv2= (TextView) itemView.findViewById(R.id.item1_tv2);
             tv3= (TextView) itemView.findViewById(R.id.item1_tv3);
        }
    }
}
