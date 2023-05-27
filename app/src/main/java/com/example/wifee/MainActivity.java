package com.example.wifee;

import androidx.appcompat.app.AppCompatActivity;
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


}
