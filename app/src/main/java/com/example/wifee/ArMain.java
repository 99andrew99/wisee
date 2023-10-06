package com.example.wifee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.unity3d.player.UnityPlayerActivity;

public class ArMain extends AppCompatActivity {

    private ConstraintLayout recommendBtn;
    private ConstraintLayout currentBtn;
    private ConstraintLayout detailBtn;
    private ConstraintLayout unityOpenBtn;
    private TextView arChangeWifiText;
    private ImageView mainLogo;
    private ImageView currentWifiCircle;
    private ImageView imageView2;
    private TextView textView;
    private WifiManager wifiManager;
    private ConstraintLayout mainBottomContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ar_main);

        arChangeWifiText = findViewById(R.id.arChangeWifiText);
        recommendBtn = findViewById(R.id.wifi_recommend);
        currentBtn = findViewById(R.id.wifi_info);
        detailBtn = findViewById(R.id.ar_detail);
        unityOpenBtn = findViewById(R.id.ar_start);
        mainLogo = findViewById(R.id.main_logo);
        currentWifiCircle = findViewById(R.id.current_wifi_circle);
        imageView2 = findViewById(R.id.imageView2);
        textView = findViewById(R.id.textView);
        mainBottomContainer = findViewById(R.id.main_bottom_container);



        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        String ssid = wifiInfo.getSSID();
        arChangeWifiText.setText(ssid.substring(1,ssid.length()-1));

        ImageView imageView3 = findViewById(R.id.imageView3);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1. Modify main_logo
                ViewGroup.LayoutParams logoParams = mainLogo.getLayoutParams();
                logoParams.width = convertDpToPx(120);
                logoParams.height = convertDpToPx(55);
                if (logoParams instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) logoParams).topMargin = convertDpToPx(16);
                }
                mainLogo.setLayoutParams(logoParams);

                // 2. Modify current_wifi_circle
                ViewGroup.LayoutParams circleParams = currentWifiCircle.getLayoutParams();
                circleParams.width = convertDpToPx(234);
                circleParams.height = convertDpToPx(221);
                currentWifiCircle.setLayoutParams(circleParams);

                // 3. Modify imageView2, textView, arChangeWifiText
                ViewGroup.LayoutParams imageView2Params = imageView2.getLayoutParams();
                imageView2Params.width = convertDpToPx(60);
                imageView2Params.height = convertDpToPx(60);
                imageView2.setLayoutParams(imageView2Params);

                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
                arChangeWifiText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
                if (arChangeWifiText.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) arChangeWifiText.getLayoutParams()).topMargin = convertDpToPx(20);
                }

                // 4. Modify main_bottom_container
                if (mainBottomContainer.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) mainBottomContainer.getLayoutParams()).topMargin = convertDpToPx(40);
                }
            }
        });

        recommendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openARRecommendActivity();
            }
        });

        currentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openARCurrentActivity();
            }
        });

        detailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openARDetailActivity();
            }
        });

        unityOpenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUnityAR();
            }
        });
    }

    public void openARRecommendActivity() {
        Intent intent = new Intent(this, ArRecommend.class);
        startActivity(intent);
    }

    public void openARCurrentActivity() {
        Intent intent = new Intent(this, ArCurrentwifi.class);
        startActivity(intent);
    }

    public void openARDetailActivity() {
        Intent intent = new Intent(this, ArDetail.class);
        startActivity(intent);
    }

    public void openUnityAR() {
        Intent intent = new Intent(this, MainUnityActivity.class);
        startActivity(intent);
    }

    private int convertDpToPx(int dp) {
        return (int) (dp * getResources().getDisplayMetrics().density);
    }
}

