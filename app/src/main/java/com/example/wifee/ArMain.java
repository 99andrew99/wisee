package com.example.wifee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ArMain extends AppCompatActivity {

    private Button recommendBtn;
    private Button currentBtn;
    private Button detailBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ar_main);

        recommendBtn = (Button) findViewById(R.id.arWifiRecommendBtn);
        currentBtn = (Button) findViewById(R.id.arCurrentWifiBtn);
        detailBtn = (Button) findViewById(R.id.arWifiDetailBtn);

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
}