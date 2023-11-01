package com.example.wifee;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity_copy extends AppCompatActivity {

    private ImageButton arBtn;
    private ImageButton mapBtn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onCheckPermission();

        arBtn = (ImageButton) findViewById(R.id.arBtn);
        arBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openARMainActivity();
            }
        });

        mapBtn = (ImageButton) findViewById(R.id.mapBtn);
        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMAPMainActivity();
            }
        });


    }

    public void openARMainActivity() {
        Intent intent = new Intent(this, ArMain.class);
//        Intent intent = new Intent(this, UnityPlayerActivity.class);
        startActivity(intent);
    }

    public void openMAPMainActivity() {
        Intent intent = new Intent(this, MapMain.class);
        startActivity(intent);
    }

    private void onCheckPermission() {
        String[] permission_list = {
                Manifest.permission.INTERNET,
                Manifest.permission.CAMERA,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
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


}