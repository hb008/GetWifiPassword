package com.example.brini.getwifipassword;

import android.app.Application;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.speech.tts.TextToSpeech;
import android.text.TextUtils;
import android.widget.Toast;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brini on 06/10/2015.
 */
public class WifiServices extends Application implements TextToSpeech.OnInitListener {
  private Context mContext;
    /*
    public WifiServices(Context mContext){
        this.mContext= mContext;
    }
    */
    public  Context getContext() {
        return mContext;
    }

    public  void setContext(Context mContext) {
        this.mContext = mContext;
    }


    /**
     * Get stored Wifi SSID and password
     */
    public void wificonf() {
        WifiManager wifimanager;
        String context = Context.WIFI_SERVICE;
        wifimanager = (WifiManager) mContext.getSystemService(context);
        Method[] methods = wifimanager.getClass().getDeclaredMethods();
        for (Method m : methods) {
            if (m.getName().equals("getWifiApConfiguration")) {
        try {
                 WifiConfiguration config = (WifiConfiguration) m.invoke(wifimanager);
                /*
                 //context = getApplicationContext();
                 CharSequence text = config.SSID;
                 int duration = Toast.LENGTH_SHORT;
                 Toast toast = Toast.makeText(this.mContext,text, duration);
                 toast.show();
                 //WifiConfiguration config =wifimanager.getConfiguredNetworks()[0];
                 // here, the "config" variable holds the info, your SSID is in
                 // config.SSID
                 */
             }
             catch(Exception io){io.printStackTrace();}
            }
        }
    }

    /**
     * Get the current opened wifi parameters
     * @param context
     * @return
     */
    public String getCurrentSsid(Context context) {
        String ssid = null;
        ConnectivityManager connManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
      //  if (networkInfo.isConnected()) {
            final WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
            final WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            System.out.println("connectionInfo = "+connectionInfo);
           if (connectionInfo != null && !TextUtils.isEmpty(connectionInfo.getSSID())) {
                ssid = connectionInfo.getSSID();
            }
      //  }
        return ssid;
    }

    public List<MWiFi> ListPhoneStoredWiFi(Context context) {
        List<MWiFi> myWiFiList= new ArrayList<MWiFi>();
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);

        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        if (wifiInfo!=null){
            if (wifiInfo.getNetworkId()!=-1){
                System.out.println("we found saved networks");
                MWiFi mWiFi=new  MWiFi();
                mWiFi.setSsidValue(wifiInfo.getSSID());
                mWiFi.setNetworkId(wifiInfo.getNetworkId());
                mWiFi.setBoolv(true);
                myWiFiList.add(mWiFi);
            }
        }
        // List stored networks
        List<WifiConfiguration> configs = wifiManager.getConfiguredNetworks();

        if (configs!=null){
            for (WifiConfiguration config : configs) {
                if (config.networkId!=wifiInfo.getNetworkId()) {
                    System.out.println("adding networks to list");
                    MWiFi mWiFi=new  MWiFi();
                    mWiFi.setSsidValue(config.SSID);
                    mWiFi.setNetworkId(config.networkId);
                    mWiFi.setBoolv(true);
                    myWiFiList.add(mWiFi);
                }
            }
        }
        return myWiFiList;
    }


    @Override
    public void onInit(int status) {

    }
}
