package com.example.wifee;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ArDetailAdapter extends RecyclerView.Adapter<ArDetailAdapter.ViewHolder> {
    private List<ArDetailItem> arDetailItems;

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

    public ArDetailAdapter(List<ArDetailItem> arDetailItems) {
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
        ArDetailItem item = arDetailItems.get(position);
        holder.ssidDetailText.setText(item.getSsid());
        holder.signalDetailText.setText(item.getSignal());
        holder.frequencyDetailText.setText(item.getFrequency());
        holder.macDetailText.setText(item.getMac());
        holder.timeDetailText.setText(item.getTime());
    }

    @Override
    public int getItemCount() {
        return arDetailItems.size();
    }
}

