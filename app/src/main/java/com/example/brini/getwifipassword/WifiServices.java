package com.example.brini.getwifipassword;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;

import java.lang.reflect.Method;

/**
 * Created by Brini on 06/10/2015.
 */
public class WifiServices {
    Context mContext;
    public WifiServices(Context mContext){
        this.mContext= mContext;

    }



    public void wificonf() {
        WifiManager wifimanager;
        String context = Context.WIFI_SERVICE;
        wifimanager = (WifiManager) mContext.getSystemService(context);
        Method[] methods = wifimanager.getClass().getDeclaredMethods();
        for (Method m : methods) {
            if (m.getName().equals("getWifiApConfiguration")) {
            // WifiConfiguration config = (WifiConfiguration) m.invoke(wifimanager);
                //WifiConfiguration config =wifimanager.getConfiguredNetworks()[0];
                // here, the "config" variable holds the info, your SSID is in
                // config.SSID
            }
        }
    }
}
