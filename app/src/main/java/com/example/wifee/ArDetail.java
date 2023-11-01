package com.example.wifee;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;

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

    // Button을 TextView로 변경
    TextView arDetailRoadBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ar_detail);

        recyclerView = findViewById(R.id.detailRecyclerView);
        // findViewById를 통해 TextView를 참조
        arDetailRoadBtn = findViewById(R.id.arDetailRoadBtn);
        arDetailRoadBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                CreateDetailItems();
            }
        });


    }


                if (ActivityCompat.checkSelfPermission(ArDetail.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    String[] permission_list = {
                            Manifest.permission.ACCESS_WIFI_STATE,
                            Manifest.permission.CHANGE_WIFI_STATE
                    };
                    for (String permission : permission_list) {
                        int reqPer = checkCallingOrSelfPermission(permission);
                        if (reqPer == PackageManager.PERMISSION_DENIED) {
                            requestPermissions(permission_list, 777);
                        }
                    }
                }


        WifiManager wifiManager = getWifiManager();
        List<ScanResult> scanResults = wifiManager.getScanResults();


                arDetailItems = new ArrayList<>();
                for (int i = 0; i < scanResults.size(); i++) {
                    arDetailItems.add(new MyDetailResult(scanResults.get(i).SSID, scanResults.get(i).level, scanResults.get(i).frequency,
                            scanResults.get(i).BSSID, System.currentTimeMillis()));

                    if (arDetailItems.get(i).getSSID().isEmpty()) {
                        arDetailItems.get(i).setSSID("익명의 와이파이");
                    }
                }

                adapter = new ArDetailAdapter(arDetailItems);
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
