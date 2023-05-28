package com.example.wifee;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ArRecommend extends AppCompatActivity {

    // 버튼 객체를 선언합니다.
    Button arRecommendSignalBtn;
    Button arRecommendFrequencyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ar_wifi_recommend);

        // 레이아웃의 버튼 객체를 참조합니다.
        arRecommendSignalBtn = findViewById(R.id.arRecommendSignalBtn);
        arRecommendFrequencyBtn = findViewById(R.id.arRecommendFrequencyBtn);

        // 각 버튼에 대해 클릭 리스너를 설정합니다.
        arRecommendSignalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 클릭된 버튼의 배경색과 글자색을 변경합니다.

                arRecommendSignalBtn.setTextColor(Color.WHITE);
                arRecommendSignalBtn.setSelected(true);
                // 다른 버튼의 색상을 원래대로 복구합니다.
                arRecommendFrequencyBtn.setSelected(false);
                arRecommendFrequencyBtn.setTextColor(Color.BLACK);
            }
        });

        arRecommendFrequencyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 클릭된 버튼의 배경색과 글자색을 변경합니다.
                arRecommendFrequencyBtn.setTextColor(Color.WHITE);
                arRecommendFrequencyBtn.setSelected(true);

                // 다른 버튼의 색상을 원래대로 복구합니다.
                arRecommendSignalBtn.setSelected(false);
                arRecommendSignalBtn.setTextColor(Color.BLACK);
            }
        });
    }
}





