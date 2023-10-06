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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArRecommend extends AppCompatActivity {

    private TextView recNameTxt;
    private TextView recRSSITxt;
    private TextView recFreqTxt;
    private TextView recommendChoiceText;
    private TextView recommendChoiceBtn;

    // 클릭 상태를 추적하기 위한 변수
    private boolean isFrequency = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ar_wifi_recommend);

        recNameTxt = findViewById(R.id.arRecommendNameText);
        recRSSITxt = findViewById(R.id.arRecommendSignalText);
        recFreqTxt = findViewById(R.id.arRecommendFrequencyText);
        recommendChoiceText = findViewById(R.id.recommendChoiceText);
        recommendChoiceBtn = findViewById(R.id.recommendChoiceBtn);

        // 기본 상태 설정
        updateView(0);

        recommendChoiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFrequency) {
                    updateView(0);
                    recommendChoiceText.setText("감도");
                    isFrequency = false;
                } else {
                    updateView(1);
                    recommendChoiceText.setText("주파수");
                    isFrequency = true;
                }
            }
        });
    }

    private WifiManager getWifiManager() {
        return (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
    }

    // 기존에 있는 메서드를 활용하여 상태에 따라 뷰를 업데이트하는 메서드
    private void updateView(int option) {
        MyScanResult bestWifi = getBestWifi(option);
        recNameTxt.setText(bestWifi.getSSID());
        recRSSITxt.setText(Integer.toString(bestWifi.getRSSI()));
        recFreqTxt.setText(Double.toString(bestWifi.getFrequency()));
    }

    public MyScanResult getBestWifi(int option) {
        String[] result = new String[0];

        WifiManager wifiManager = getWifiManager();

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            String[] permission_list = {
                    android.Manifest.permission.ACCESS_FINE_LOCATION,
                    android.Manifest.permission.ACCESS_WIFI_STATE,
                    android.Manifest.permission.CHANGE_WIFI_STATE
            };
            for(String permission : permission_list){
                //권한 허용 여부를 확인한다.
                int reqPer = checkCallingOrSelfPermission(permission);
                if(reqPer == PackageManager.PERMISSION_DENIED){
                    //권한 허용 여부를 확인하는 창을 띄운다
                    requestPermissions(permission_list,777);
                }
            }
        }

        List<ScanResult> scanResults = wifiManager.getScanResults();
        List<MyScanResult> myWifiInfoList = new ArrayList<>();
        for (int i = 0; i < scanResults.size(); i++) {
            myWifiInfoList.add(new MyScanResult(scanResults.get(i).SSID, scanResults.get(i).level, scanResults.get(i).frequency));
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
