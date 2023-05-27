package com.example.wifee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ArMain extends AppCompatActivity {

    private Button recommendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ar_main);

        recommendBtn = (Button) findViewById(R.id.arWifiRecommendBtn);

        recommendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openARRecommendActivity();
            }
        });
    }

    public void openARRecommendActivity() {
        Intent intent = new Intent(this, ArRecommend.class);
        startActivity(intent);
    }
}