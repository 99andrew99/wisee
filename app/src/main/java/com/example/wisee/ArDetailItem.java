package com.example.wisee;

public class ArDetailItem {
    private String ssid;
    private String signal;
    private String frequency;
    private String mac;
    private String time;

    //생성자
    public ArDetailItem(String ssid, String signal, String frequency, String mac, String time) {
        this.ssid = ssid;
        this.signal = signal;
        this.frequency = frequency;
        this.mac = mac;
        this.time = time;
    }

    // Getter 메소드
    public String getSsid() { return ssid; }
    public String getSignal() { return signal; }
    public String getFrequency() { return frequency; }
    public String getMac() { return mac; }
    public String getTime() { return time; }
}

