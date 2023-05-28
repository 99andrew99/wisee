package com.example.wifee;

public class MyDetailResult {
    private String SSID;
    private int level;
    private int frequency;
    private String BSSID;
    private long timestamp;

    public MyDetailResult(String SSID, int level, int frequency, String BSSID, long timestamp) {
        this.SSID = SSID;
        this.level = level;
        this.frequency = frequency;
        this.BSSID = BSSID;
        this.timestamp = timestamp;
    }

    public String getSSID() {
        return SSID;
    }

    public void setSSID(String SSID) {
        this.SSID = SSID;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getBSSID() {
        return BSSID;
    }

    public void setBSSID(String BSSID) {
        this.BSSID = BSSID;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
