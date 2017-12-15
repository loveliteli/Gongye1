package com.exbawei.liteli.gongye.contrect;

import com.exbawei.liteli.gongye.bean.MyBean;
import com.exbawei.liteli.gongye.model.Model;

import java.util.List;

/**
 * Created by li te li on 2017/12/14.
 */

public class Contract {
    public  interface IModel{
        List<MyBean.DataBean.ArticleBean> getData(Model.BeanData beanData);

    }
    public  interface IView{
        void setData(List<MyBean.DataBean.ArticleBean> list);

    }

    public  interface IPresenter{
        void showData();

    }
}
