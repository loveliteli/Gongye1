package com.exbawei.liteli.gongye;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

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
                    case  R.id.tvTui:
                      tvTui.setSelected(true);
                        tvGuan.setSelected(false);
                        v1.setVisibility(View.VISIBLE);
                        v2.setVisibility(View.GONE);
                    break;
                    case  R.id.tvGuan:
                        tvGuan.setSelected(true);
                        tvTui.setSelected(false);
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
        tvTui.setOnClickListener(this);
        tvGuan.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvTui:
           vp.setCurrentItem(0);
             v1.setVisibility(View.VISIBLE);
                v2.setVisibility(View.GONE);
                break;
            case R.id.tvGuan:
                vp.setCurrentItem(1);
                v1.setVisibility(View.GONE);
                v2.setVisibility(View.VISIBLE);
                break;
        }
    }

}
