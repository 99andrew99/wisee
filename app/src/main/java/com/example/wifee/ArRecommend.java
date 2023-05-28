package com.example.wifee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


import android.content.pm.PackageManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import kotlin.collections.ArrayDeque;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ArRecommend extends AppCompatActivity {

    // 버튼 객체를 선언합니다.
    Button arRecommendSignalBtn;
    Button arRecommendFrequencyBtn;


    private TextView recNameTxt;
    private TextView recRSSITxt;
    private TextView recFreqTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ar_wifi_recommend);



        recNameTxt = (TextView)  findViewById(R.id.arRecommendNameText);
        recRSSITxt = (TextView) findViewById(R.id.arRecommendSignalText);
        recFreqTxt = (TextView) findViewById(R.id.arRecommendFrequencyText);


        // 레이아웃의 버튼 객체를 참조합니다.
        arRecommendSignalBtn = findViewById(R.id.arRecommendSignalBtn);
        arRecommendFrequencyBtn = findViewById(R.id.arRecommendFrequencyBtn);

        // 각 버튼에 대해 클릭 리스너를 설정합니다.
        arRecommendSignalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyScanResult bestWifi = getBestWifi(0);
                recNameTxt.setText(bestWifi.getSSID());
                recRSSITxt.setText(Integer.toString(bestWifi.getRSSI()) + " dBm");
                recFreqTxt.setText(Double.toString(bestWifi.getFrequency()) + " MHz");
                // 클릭된 버튼의 배경색과 글자색을 변경합니다.

                arRecommendSignalBtn.setTextColor(Color.WHITE);
                arRecommendSignalBtn.setSelected(true);
                // 다른 버튼의 색상을 원래대로 복구합니다.
                arRecommendFrequencyBtn.setSelected(false);
                arRecommendFrequencyBtn.setTextColor(Color.BLACK);
            }
        });

        arRecommendFrequencyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyScanResult bestWifi = getBestWifi(1);
                recNameTxt.setText(bestWifi.getSSID());
                recRSSITxt.setText(Integer.toString(bestWifi.getRSSI()) + " dBm");
                recFreqTxt.setText(Double.toString(bestWifi.getFrequency()) + " MHz");
                // 클릭된 버튼의 배경색과 글자색을 변경합니다.
                arRecommendFrequencyBtn.setTextColor(Color.WHITE);
                arRecommendFrequencyBtn.setSelected(true);

                // 다른 버튼의 색상을 원래대로 복구합니다.
                arRecommendSignalBtn.setSelected(false);
                arRecommendSignalBtn.setTextColor(Color.BLACK);
            }
        });
    }



    private WifiManager getWifiManager() {
        return (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
    }

    // get existing wifi list
    public MyScanResult getBestWifi(int option) {
        String[] result = new String[0];

        WifiManager wifiManager = getWifiManager();

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            String[] permission_list = {
                    android.Manifest.permission.ACCESS_WIFI_STATE,
                    android.Manifest.permission.CHANGE_WIFI_STATE
            };
            for(String permission : permission_list){
                //권한 허용 여부를 확인한다.
                int reqPer = checkCallingOrSelfPermission(permission);
                if(reqPer == PackageManager.PERMISSION_DENIED){
                    //권한 허용을여부를 확인하는 창을 띄운다
                    requestPermissions(permission_list,777);
                }
            }
        }

        List<ScanResult> scanResults = wifiManager.getScanResults();
        List<MyScanResult> myWifiInfoList = new ArrayList<>();
        for (int i = 0; i < scanResults.size(); i++) {
            myWifiInfoList.add(new MyScanResult(scanResults.get(i).SSID,scanResults.get(i).level,scanResults.get(i).frequency));
            if(myWifiInfoList.get(i).getSSID().isEmpty()){
                myWifiInfoList.get(i).setSSID("익명의 와이파이");
            }
        }

        switch (option){
            case 0:
                sortWiFiInfoByRSSI(myWifiInfoList);
                break;
            case 1:
                sortWiFiInfoByFrequency(myWifiInfoList);
                break;
            default:
                sortWiFiInfoByRSSI(myWifiInfoList);
                break;
        }


        for (MyScanResult mywifi : myWifiInfoList){
            Log.d("TEST", mywifi.getSSID());
            Log.d("TEST", Integer.toString(mywifi.getRSSI()));
            Log.d("TEST", Double.toString(mywifi.getFrequency()));
        }



        return myWifiInfoList.get(0);
    }

    private static List<MyScanResult> sortWiFiInfoByRSSI(List<MyScanResult> wifiInfoList) {
        Collections.sort(wifiInfoList, Comparator.comparingInt(MyScanResult::getRSSI).reversed());
        return wifiInfoList;
    }

    private static List<MyScanResult> sortWiFiInfoByFrequency(List<MyScanResult> wifiInfoList) {
        Collections.sort(wifiInfoList, Comparator.comparingDouble(MyScanResult::getFrequency).reversed());
        return wifiInfoList;
    }


}








