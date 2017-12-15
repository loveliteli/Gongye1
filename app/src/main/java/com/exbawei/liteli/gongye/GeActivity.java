package com.exbawei.liteli.gongye;


import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.exbawei.liteli.gongye.adapter.Myadapter;
import com.facebook.drawee.backends.pipeline.Fresco;


public class GeActivity extends AppCompatActivity {

    private TextView tvwang;
    private ListView lv;
    private ImageView cuo;
    private ImageView ivtu;
    String url = "http://img0.bdstatic.com/img/image/shouye/xiaoxiao/%E5%B0%8F%E6%B8%85%E6%96%B0614.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_ge);

        initView();
    }

    private void initView() {
//        ivtu = (ImageView) findViewById(R.id.ivtu);
        tvwang = (TextView) findViewById(R.id.tvwang);
        lv = (ListView) findViewById(R.id.lv);
        cuo = (ImageView) findViewById(R.id.cuo);
cuo.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        finish();
    }
});
        Myadapter adapter = new Myadapter(GeActivity.this);
        lv.setAdapter(adapter);
    }

}
