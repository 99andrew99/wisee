package com.example.wifee;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.unity3d.player.UnityPlayer;

import company.product.OverrideUnityActivity;
//2023-9-12 오후 7시 41분 유니티 버튼 추가 성공
//com.unity3d.player 패키지의 UnityPlayerActivity를 추상 클래스화 해서 company.product클래스를 만들었다.
//그 클래스를 MainUnityActivity로 불러와서 실행했다.
//Manifest에도 추가했다.

public class MainUnityActivity extends OverrideUnityActivity {
    protected UnityPlayer unityPlayer;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addControlsToUnityFrame();
    }

    public void addControlsToUnityFrame() {
        FrameLayout layout = mUnityPlayer;
        {
            Button myButton = new Button(this);
            myButton.setText("돌아가기");
            myButton.setX(550);
            myButton.setY(2500);

            myButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    showMainActivity();
                }
            });
            layout.addView(myButton, 300, 200);



            Button myButton2 = new Button(this);
            myButton2.setText("히트맵");
            myButton2.setX(250);
            myButton2.setY(2500);

            myButton2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    unityPlayer.UnitySendMessage("Spawner", "Heat", "");
                }
            });
            layout.addView(myButton2, 300, 200);



            Button myButton3 = new Button(this);
            myButton3.setText("와이파이");
            myButton3.setX(850);
            myButton3.setY(2500);

            myButton3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    unityPlayer.UnitySendMessage("HSpawner", "Ar", "");
                }
            });
            layout.addView(myButton3, 300, 200);
        }
    }

    protected void showMainActivity() {
        Intent intent = new Intent(this, ArMain.class);
        startActivity(intent);
    }
}
