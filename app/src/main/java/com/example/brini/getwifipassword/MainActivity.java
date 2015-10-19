package com.example.brini.getwifipassword;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    public EditText SSIDNAME;
    public ImageButton CancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CancelButton = (ImageButton)findViewById((R.id.CancelButton));
        CancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SSIDNAME.setText("");
            }
        });
        SSIDNAME = (EditText)findViewById(R.id.SSIDNAME);
        SSIDNAME.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SSIDNAME.setText("");
            }
        });

        WifiServices ws = new WifiServices();
        ws.setContext(this);
        List<MWiFi> list= new List<MWiFi>() {
            @Override
            public void add(int location, MWiFi object) {

            }

            @Override
            public boolean add(MWiFi object) {
                return false;
            }

            @Override
            public boolean addAll(int location, Collection<? extends MWiFi> collection) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends MWiFi> collection) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean contains(Object object) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> collection) {
                return false;
            }

            @Override
            public MWiFi get(int location) {
                return null;
            }

            @Override
            public int indexOf(Object object) {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @NonNull
            @Override
            public Iterator<MWiFi> iterator() {
                return null;
            }

            @Override
            public int lastIndexOf(Object object) {
                return 0;
            }

            @Override
            public ListIterator<MWiFi> listIterator() {
                return null;
            }

            @NonNull
            @Override
            public ListIterator<MWiFi> listIterator(int location) {
                return null;
            }

            @Override
            public MWiFi remove(int location) {
                return null;
            }

            @Override
            public boolean remove(Object object) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> collection) {
                return false;
            }

            @Override
            public MWiFi set(int location, MWiFi object) {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }

            @NonNull
            @Override
            public List<MWiFi> subList(int start, int end) {
                return null;
            }

            @NonNull
            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @NonNull
            @Override
            public <T> T[] toArray(T[] array) {
                return null;
            }
        };
        list =ws.ListPhoneStoredWiFi(this);
        //SSIDNAME.setText(ws.getCurrentSsid(ws.getContext()));
        System.out.println("i m here");
        System.out.println("size of list="+list.size());
        for (int i = 1; i < list.size(); i++) {
            System.out.println("ssid ="+list.get(i).getSsidValueValue());
        }

        //SSIDNAME.setText(list.get(1).getSsidValueValue());
        /*
        CharSequence text = WifiServices.getCurrentSsid(ws.getContext());
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(this,text, duration);
        toast.show();
        */


    }
}
