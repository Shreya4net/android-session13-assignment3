package com.dce.puja.musicplayer;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity implements MusicPlay.MusicListener {

    MusicPlay service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent = new Intent(MainActivity.this,MusicPlay.class);
        bindService(intent, new Bin(), BIND_AUTO_CREATE); // start...


        IntentFilter filter = new IntentFilter("a.b.co.d.q");// user custom action....
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                prepareListView();
            }
        }, filter);

    }

    @Override
    public void songCompleted() {
        Toast.makeText(this,"songCompleted....",Toast.LENGTH_LONG).show();
    }

    public void prepareListView(){
        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,MusicPlay.arrayList);
        listView.setAdapter(arrayAdapter);

    }

    public void play(View v) {
        try {
            service.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    class Bin implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            //messenger = new Messenger(iBinder);
            MusicPlay.MusicBinder binder = (MusicPlay.MusicBinder) iBinder;
            service = binder.getinstace();
            service.registerActivity(MainActivity.this);
            Log.i("TAG","onSeconc="+service +" ininder"+iBinder);
        }
        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    }

    public void pause(View view) {

    }

    public void next(View v) {

        service.next();
    }

    public void previosu(View view) {

    }


}



