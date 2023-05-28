package com.example.wifee;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ArCurrentwifi extends AppCompatActivity {
    private WifiManager wifiManager;
    private TextView ssidText;
    private TextView signalText;
    private TextView speedText;
    private TextView frequencyText;
    private TextView IPText;
    private TextView macText;
    private TextView timeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ar_currentwifi);

        ssidText = (TextView)  findViewById(R.id.ssidText);
        signalText = (TextView) findViewById(R.id.signalText);
        speedText = (TextView) findViewById(R.id.speedText);
        frequencyText = (TextView) findViewById(R.id.frequencyText);
        IPText = (TextView) findViewById(R.id.IPText);
        macText = (TextView) findViewById(R.id.macText);
        timeText = (TextView) findViewById(R.id.timeText);

        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        String ssid = wifiInfo.getSSID();
        ssidText.setText(ssid.substring(1,ssid.length()-1));
        signalText.setText(Integer.toString(wifiInfo.getRssi()) + "dBm");
        speedText.setText(Integer.toString(wifiInfo.getLinkSpeed()) + "Mbps");
        frequencyText.setText(Integer.toString(wifiInfo.getFrequency()) + "MHz");
        int ipAddress = wifiInfo.getIpAddress();
        String stringIpAddress = String.format(
                "%d.%d.%d.%d",
                (ipAddress & 0xff),
                (ipAddress >> 8 & 0xff),
                (ipAddress >> 16 & 0xff),
                (ipAddress >> 24 & 0xff)
        );
        IPText.setText(stringIpAddress);
        macText.setText(wifiInfo.getBSSID());
        timeText.setText(getDateTime());
    }

    public static int convertFrequencyToChannel(int freq) {
        if(freq >= 2412 && freq <= 2484) {
            if (freq == 2484)
                return (freq-2412) /5;
            return (freq-2412) /5 + 1;
        }else if( freq >= 5170 && freq <= 5825) {
            return (freq-5170) /5 + 34;
        }
        else {
            return -1;
        }
    }

    public String getDateTime() {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
        return df.format(date);
    }
}
