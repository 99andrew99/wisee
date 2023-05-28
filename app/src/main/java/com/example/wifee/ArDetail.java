package com.example.wifee;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ArDetail extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArDetailAdapter adapter;
    private List<ArDetailItem> arDetailItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ar_detail);

        recyclerView = findViewById(R.id.detailRecyclerView);

        // 데이터 생성. 실제 구현에서는 원하는 값으로 변경해야 함
        arDetailItems = new ArrayList<>();
        for (int i = 0; i < 10; i++) { // 여기서 10은 개수를 의미. 원하는 수로 변경 가능
            arDetailItems.add(new ArDetailItem("SSID" + i, "Signal" + i, "Frequency" + i, "MAC" + i, "Time" + i));
        }

        adapter = new ArDetailAdapter(arDetailItems);

        // LinearLayoutManager 사용
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}



