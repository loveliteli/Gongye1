package com.exbawei.liteli.gongye.model;

import com.exbawei.liteli.gongye.bean.MyBean;
import com.exbawei.liteli.gongye.contrect.Contract;
import com.exbawei.liteli.gongye.utils.GsonObjectCallback;
import com.exbawei.liteli.gongye.utils.OkHttp3Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * Created by li te li on 2017/12/14.
 */

public class Model implements Contract.IModel {
    String url="http://m2.itmayi.net.cn/api/articles?user=surfer&flag=index2&fromUid=141&page=1";
    List<MyBean.DataBean.ArticleBean> list = new ArrayList<>();
    @Override
    public List<MyBean.DataBean.ArticleBean> getData(final BeanData beanData) {
        OkHttp3Utils.doGet(url, new GsonObjectCallback<MyBean>() {
            @Override
            public void onUi(MyBean myBean) {
                List<MyBean.DataBean.ArticleBean> article = myBean.getData().getArticle();
             beanData.Data(article);
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
        return list;
    }

    public interface BeanData{
        void Data(List<MyBean.DataBean.ArticleBean> list);
    }
}
