package com.example.wifee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.pm.PackageManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.content.Context;
import android.os.Bundle;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ArRecommend extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ar_wifi_recommend);

    }

    private WifiManager getWifiManager() {
        return (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
    }

    // get existing wifi list
    public String[] getWifiList() {
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
        List<MyWifiInfo> myWifiInfoList;
        for (int i = 0; i < scanResults.size(); i++) {
            myWifiInfoList.add(new MyWifiInfo(scanResults.get(i).SSID,scanResults.get(i).level,scanResults.get(i).))
            result[i] = scanResults.get(i).;
        }

        return result;
    }

}