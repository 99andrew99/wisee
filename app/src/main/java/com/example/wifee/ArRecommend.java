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


public class ArRecommend extends AppCompatActivity {

    private Button recByRSSIBtn;
    private Button recByFreqBtn;
    private TextView recNameTxt;
    private TextView recRSSITxt;
    private TextView recFreqTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ar_wifi_recommend);

        recByRSSIBtn = (Button) findViewById(R.id.arRecommendSignalBtn);
        recByFreqBtn = (Button) findViewById(R.id.arRecommendFrequencyBtn);
        recNameTxt = (TextView)  findViewById(R.id.arRecommendNameText);
        recRSSITxt = (TextView) findViewById(R.id.arRecommendSignalText);
        recFreqTxt = (TextView) findViewById(R.id.arRecommendFrequencyText);
        recByRSSIBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyWifiInfo bestWifi = getBestWifi(0);
                recNameTxt.setText(bestWifi.getSSID());
                recRSSITxt.setText(Integer.toString(bestWifi.getRSSI()));
                recFreqTxt.setText(Double.toString(bestWifi.getFrequency()));
            }
        });

        recByFreqBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyWifiInfo bestWifi = getBestWifi(1);
                recNameTxt.setText(bestWifi.getSSID());
                recRSSITxt.setText(Integer.toString(bestWifi.getRSSI()));
                recFreqTxt.setText(Double.toString(bestWifi.getFrequency()));
            }
        });
    }



    private WifiManager getWifiManager() {
        return (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
    }

    // get existing wifi list
    public MyWifiInfo getBestWifi(int option) {
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
        List<MyWifiInfo> myWifiInfoList = new ArrayList<>();
        for (int i = 0; i < scanResults.size(); i++) {
            myWifiInfoList.add(new MyWifiInfo(scanResults.get(i).SSID,scanResults.get(i).level,scanResults.get(i).frequency));
        }

        switch (option){
            case 0: sortWiFiInfoByRSSI(myWifiInfoList);
            case 1: sortWiFiInfoByFrequency(myWifiInfoList);
            default: sortWiFiInfoByRSSI(myWifiInfoList);
        }



        Log.d("TEST", myWifiInfoList.get(0).getSSID());
        Log.d("TEST", Integer.toString(myWifiInfoList.get(0).getRSSI()));
        Log.d("TEST", Double.toString(myWifiInfoList.get(0).getFrequency()));


        return myWifiInfoList.get(0);
    }

    private static List<MyWifiInfo> sortWiFiInfoByRSSI(List<MyWifiInfo> wifiInfoList) {
        Collections.sort(wifiInfoList, Comparator.comparingInt(MyWifiInfo::getRSSI).reversed());
        return wifiInfoList;
    }

    private static List<MyWifiInfo> sortWiFiInfoByFrequency(List<MyWifiInfo> wifiInfoList) {
        Collections.sort(wifiInfoList, Comparator.comparingDouble(MyWifiInfo::getFrequency));
        return wifiInfoList;
    }


}