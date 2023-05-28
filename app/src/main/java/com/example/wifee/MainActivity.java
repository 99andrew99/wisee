package com.example.wifee;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {

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
        startActivity(intent);
    }

    public void openMAPMainActivity() {
        Intent intent = new Intent(this, MapMain.class);
        startActivity(intent);
    }

    private void onCheckPermission() {
        String[] permission_list = {
                Manifest.permission.INTERNET,
                android.Manifest.permission.CAMERA,
                android.Manifest.permission.READ_EXTERNAL_STORAGE,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION,
                android.Manifest.permission.ACCESS_WIFI_STATE,
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
