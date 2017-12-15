package com.exbawei.liteli.gongye.presenter;

import com.exbawei.liteli.gongye.bean.MyBean;
import com.exbawei.liteli.gongye.contrect.Contract;
import com.exbawei.liteli.gongye.model.Model;

import java.util.List;

/**
 * Created by li te li on 2017/12/14.
 */

public class Presenter implements Contract.IPresenter {
    Contract.IView iView;
    Model model;

    public Presenter(Contract.IView iView) {
        this.iView = iView;
        model=new Model();
    }

    @Override
    public void showData() {
    model.getData(new Model.BeanData() {
        @Override
        public void Data(List<MyBean.DataBean.ArticleBean> list) {
            iView.setData(list);
        }
    });
    }
}
