package com.example.wisee;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ArDetailAdapter extends RecyclerView.Adapter<ArDetailAdapter.ViewHolder> {
    private List<MyDetailResult> arDetailItems;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView ssidDetailText, signalDetailText, frequencyDetailText, macDetailText, timeDetailText;

        public ViewHolder(View view) {
            super(view);
            ssidDetailText = view.findViewById(R.id.ssidDetailText);
            signalDetailText = view.findViewById(R.id.signalDetailText);
            frequencyDetailText = view.findViewById(R.id.frequencyDetailText);
            macDetailText = view.findViewById(R.id.macDetailText);
            timeDetailText = view.findViewById(R.id.timeDetailText);
        }
    }

    public ArDetailAdapter(List<MyDetailResult> arDetailItems) {
        this.arDetailItems = arDetailItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ar_detail_item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MyDetailResult item = arDetailItems.get(position);
        holder.ssidDetailText.setText(item.getSSID());
        holder.signalDetailText.setText(String.valueOf(item.getLevel()) + " dBm");
        holder.frequencyDetailText.setText(String.valueOf(item.getFrequency()) + " MHz");
        holder.macDetailText.setText(item.getBSSID());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        String currentTime = sdf.format(new Date(item.getTimestamp()));
        holder.timeDetailText.setText(currentTime);
    }

    @Override
    public int getItemCount() {
        return arDetailItems.size();
    }
}
