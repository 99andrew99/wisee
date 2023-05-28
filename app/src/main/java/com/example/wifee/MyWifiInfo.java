package com.example.wifee;

public class MyWifiInfo {
    private String ssid;
    private int rssi;
    private double frequency;

    public MyWifiInfo(String ssid, int rssi, double frequency) {
        this.ssid = ssid;
        this.rssi = rssi;
        this.frequency = frequency;
    }

    public String getSSID() {
        return ssid;
    }
    public String setSSID(String ssid){
        this.ssid = ssid;
        return ssid;
    }

    public int getRSSI() {
        return rssi;
    }

    public double getFrequency() {
        return frequency;
    }
}
