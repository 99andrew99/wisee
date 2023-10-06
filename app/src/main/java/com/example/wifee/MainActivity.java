package com.example.wifee;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView wiseeLogoText;
    private ImageView wiseeLogoWifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        wiseeLogoText = findViewById(R.id.wiseeLogoText);
        wiseeLogoWifi = findViewById(R.id.wiseeLogoWifi);

        onCheckPermission();
    }

    private void startAnimations() {
        AlphaAnimation alphaAnimationText = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimationText.setDuration(2000);
        alphaAnimationText.setFillAfter(true);

        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, wiseeLogoWifi.getHeight(), 0);
        translateAnimation.setDuration(1000);
        translateAnimation.setFillAfter(true);

        AlphaAnimation alphaAnimationWifi = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimationWifi.setDuration(2000);
        alphaAnimationWifi.setFillAfter(true);

        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimationWifi);

        wiseeLogoText.startAnimation(alphaAnimationText);

        alphaAnimationText.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                wiseeLogoWifi.setVisibility(View.VISIBLE);
                wiseeLogoWifi.startAnimation(animationSet);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });

        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        openARMainActivity();
                    }
                }, 1000);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });
    }

    public void openARMainActivity() {
        Intent intent = new Intent(this, ArMain.class);
        startActivity(intent);
        finish();
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
        for (String permission : permission_list) {
            int reqPer = checkCallingOrSelfPermission(permission);
            if (reqPer == PackageManager.PERMISSION_DENIED) {
                requestPermissions(permission_list, 777);
                return; // Return here to wait for the user's response
            }
        }
        // If all permissions are already granted, start the animations
        startAnimations();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 777) {
            for (int grantResult : grantResults) {
                if (grantResult == PackageManager.PERMISSION_DENIED) {
                    // Show a message to the user that the permission is necessary, or handle the lack of permission appropriately
                    return;
                }
            }
            // All permissions are granted, start the animations
            startAnimations();
        }
    }
}
