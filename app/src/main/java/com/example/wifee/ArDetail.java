package com.example.wifee;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ArDetail extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArDetailAdapter adapter;
    private List<MyDetailResult> arDetailItems;


    Button arDetailRoadBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ar_detail);



        recyclerView = findViewById(R.id.detailRecyclerView);
        arDetailRoadBtn = findViewById(R.id.arDetailRoadBtn);
        arDetailRoadBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                //권한 허용관련
                if (ActivityCompat.checkSelfPermission(ArDetail.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    String[] permission_list = {
                            Manifest.permission.ACCESS_WIFI_STATE,
                            Manifest.permission.CHANGE_WIFI_STATE
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
                //권한 허용 끝

                WifiManager wifiManager = getWifiManager();
                List<ScanResult> scanResults = wifiManager.getScanResults();


                // 데이터 생성. 실제 구현에서는 원하는 값으로 변경해야 함
                arDetailItems = new ArrayList<>();
                for (int i = 0; i < scanResults.size(); i++) { // 여기서 10은 개수를 의미. 원하는 수로 변경 가능


//                    arDetailItems.add(new ArDetailItem("SSID" + i, "Signal" + i, "Frequency" + i, "MAC" + i, "Time" + i));

//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//                            arDetailItems.add(new ArDetailItem(scanResults.get(i).getWifiSsid().toString(),Integer.toString(scanResults.get(i).level),Integer.toString(scanResults.get(i).frequency),scanResults.get(i).getApMldMacAddress().toString(),Long.toString(scanResults.get(i).timestamp) ));
//                        }

                    arDetailItems.add(new MyDetailResult(scanResults.get(i).SSID, scanResults.get(i).level,scanResults.get(i).frequency,
                            scanResults.get(i).BSSID, System.currentTimeMillis()));


                    if(arDetailItems.get(i).getSSID().isEmpty()){
                        arDetailItems.get(i).setSSID("익명의 와이파이");
                    }

                }

                adapter = new ArDetailAdapter(arDetailItems);

                // LinearLayoutManager 사용
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setAdapter(adapter);

            }
        });


    }

    private WifiManager getWifiManager() {
        return (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
    }


}



