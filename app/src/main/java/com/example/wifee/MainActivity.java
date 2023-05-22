package com.example.wifee;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton arBtn;

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
    }

    public void openARMainActivity() {
        Intent intent = new Intent(this, ArMain.class);
        startActivity(intent);
    }
}
