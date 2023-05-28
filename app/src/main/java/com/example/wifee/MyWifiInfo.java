package com.example.wifee;

public class MyWifiInfo {
    private String ssid;
    private int rssi;
    private double frequency;
    private String ipAddress;

    public MyWifiInfo(String ssid, int rssi, int speed, double frequency) {
        this.ssid = ssid;
        this.rssi = rssi;
        this.frequency = frequency;
    }

    public String getSSID() {
        return ssid;
    }

    public int getRSSI() {
        return rssi;
    }

    public double getFrequency() {
        return frequency;
    }
}
