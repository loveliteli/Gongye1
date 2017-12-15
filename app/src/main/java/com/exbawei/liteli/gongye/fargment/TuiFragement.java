package com.exbawei.liteli.gongye.fargment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.exbawei.liteli.gongye.R;
import com.exbawei.liteli.gongye.adapter.MyRecycleViewAdapter;
import com.exbawei.liteli.gongye.bean.MyBean;
import com.exbawei.liteli.gongye.contrect.Contract;
import com.exbawei.liteli.gongye.presenter.Presenter;
import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;

import java.util.List;



/**
 * Created by li te li on 2017/12/13.
 */

public class TuiFragement extends Fragment implements Contract.IView{

    private RecyclerView rv;
    Presenter presenter = new Presenter(this);
    private MyRecycleViewAdapter recycleViewAdapter;
    private SpringView springView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getActivity(),R.layout.tui,null);
        rv = (RecyclerView) view.findViewById(R.id.rv);
        springView = (SpringView) view.findViewById(R.id.springview);
        springView.setType(SpringView.Type.FOLLOW);
        springView.setHeader(new DefaultHeader(getActivity()));
        springView.setFooter(new DefaultFooter(getActivity()));
        springView.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getContext(),"下拉刷新中",Toast.LENGTH_SHORT).show();

                finishFreshAndLoad();
            }

            @Override
            public void onLoadmore() {
                Toast.makeText(getContext(),"玩命加载中...",Toast.LENGTH_SHORT).show();
                finishFreshAndLoad();

            }
        });
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rv.setLayoutManager(layoutManager);

        presenter.showData();
        return view;

    }

    @Override
    public void setData(List<MyBean.DataBean.ArticleBean> list) {
        recycleViewAdapter = new MyRecycleViewAdapter(list,getContext());
        rv.setAdapter(recycleViewAdapter);
    }
    private void finishFreshAndLoad() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                springView.onFinishFreshAndLoad();

            }
        }, 1000);
    }
}
