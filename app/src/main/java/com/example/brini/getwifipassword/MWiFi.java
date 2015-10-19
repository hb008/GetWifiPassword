package com.example.brini.getwifipassword;

/**
 * Created by Brini on 08/10/2015.
 */
public class MWiFi {



    private String SsidValue;
    private int NetworkId;
    private boolean boolv;

/*
    public MWiFi(String toString, int value,boolean booleanvalue) {
        this.stringValue = toString;
        this.NetworkId = value;
        this.boolv=booleanvalue;

    }
    */

    public String getSsidValueValue() {
        return SsidValue;
    }

    public void setSsidValue(String stringValue) {
        this.SsidValue = SsidValue;
    }

    public int getNetworkId() {
        return NetworkId;
    }

    public void setNetworkId(int NetworkId) {
        this.NetworkId = NetworkId;
    }

    public boolean isBoolv() {
        return boolv;
    }

    public void setBoolv(boolean boolv) {
        this.boolv = boolv;
    }

}
