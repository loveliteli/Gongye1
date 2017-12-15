package com.exbawei.liteli.gongye.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.exbawei.liteli.gongye.GeActivity;
import com.exbawei.liteli.gongye.Main2Activity;
import com.exbawei.liteli.gongye.R;
import com.exbawei.liteli.gongye.adapter.MyPaper;
import com.exbawei.liteli.gongye.fargment.GuanFragement;
import com.exbawei.liteli.gongye.fargment.TuiFragement;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements View.OnClickListener{

    private TextView tvTui;
    private View v1;
    private TextView tvGuan;
    private View v2;
    private ViewPager vp;
    private List<Fragment> list;
    private MyPaper paper;
    private ImageView geren;
    private ImageView xie;
//http://m2.itmayi.net.cn/api/articles?user=surfer&flag=index2&fromUid=141&page=1
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initView();
        String localdeviceId = getLocaldeviceId(MainActivity.this);
        Log.e("===============", localdeviceId);
        list = new ArrayList<>();
        tvTui.setSelected(true);
        tvGuan.setSelected(false);
        vp.setCurrentItem(0);

        tvTui.setTextColor(Color.BLACK);
        tvGuan.setTextColor(Color.GRAY);
        v1.setVisibility(View.VISIBLE);
        v2.setVisibility(View.GONE);
        list.add(new TuiFragement());
        list.add(new GuanFragement());
        paper = new MyPaper(getSupportFragmentManager(),list);
       vp.setAdapter(paper);

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case  0:
                         tvTui.setSelected(true);
                        tvTui.setTextColor(Color.BLACK);
                        tvGuan.setTextColor(Color.GRAY);
                        tvGuan.setSelected(false);
                        v1.setVisibility(View.VISIBLE);
                        v2.setVisibility(View.GONE);


                    break;
                    case  1:
                        tvTui.setTextColor(Color.GRAY);
                        tvGuan.setTextColor(Color.BLACK);
                        tvTui.setSelected(false);
                        tvGuan.setSelected(true);
                        v1.setVisibility(View.GONE);
                        v2.setVisibility(View.VISIBLE);

                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public String getLocaldeviceId(Context context) {
        TelephonyManager tm = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        String deviceId = tm.getDeviceId();
        if (deviceId == null
                || deviceId.trim().length() == 0) {
            WifiManager wifi = (WifiManager) context.getSystemService(
                    Context.WIFI_SERVICE);
            WifiInfo info = wifi.getConnectionInfo();
            deviceId = info.getMacAddress();
        }
        return deviceId;
    }

    private void initView() {
        tvTui = (TextView) findViewById(R.id.tvTui);
        v1 = (View) findViewById(R.id.v1);
        tvGuan = (TextView) findViewById(R.id.tvGuan);
        v2 = (View) findViewById(R.id.v2);
        vp = (ViewPager) findViewById(R.id.vp);
        geren = (ImageView) findViewById(R.id.geren);
        xie = (ImageView) findViewById(R.id.xie);
        tvTui.setOnClickListener(this);
        tvGuan.setOnClickListener(this);
        xie.setOnClickListener(this);
        geren.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvTui:
           vp.setCurrentItem(0);
             v1.setVisibility(View.VISIBLE);
                v2.setVisibility(View.GONE);
                tvTui.setTextColor(Color.BLACK);
                tvGuan.setTextColor(Color.GRAY);
                break;
            case R.id.tvGuan:
                vp.setCurrentItem(1);
                v1.setVisibility(View.GONE);
                v2.setVisibility(View.VISIBLE);
                tvTui.setTextColor(Color.GRAY);
                tvGuan.setTextColor(Color.BLACK);
                break;
            case R.id.geren:
                Intent intent =new Intent(MainActivity.this,GeActivity.class);
                startActivity(intent);
            break;
            case R.id.xie:
                Intent intent1 =new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent1);
                break;
        }
    }

}
