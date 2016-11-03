package com.coayo.deteccionmovimiennto;

import android.app.Activity;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.LinearLayout;

import static android.hardware.SensorManager.SENSOR_DELAY_NORMAL;

public class MainActivity extends Activity /*implements SensorEventListener */{
    //public SensorManager SM;
    //public Sensor mygirosopo;
    public LinearLayout vis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vis = (LinearLayout)findViewById(R.id.layer);

        final SensorManager SM;
        SM = (SensorManager) getSystemService(SENSOR_SERVICE);

        final Sensor mygirosopo = SM.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        SM.registerListener(elistener, mygirosopo, SENSOR_DELAY_NORMAL);


    }

       private final SensorEventListener elistener= new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            vis.setBackgroundColor(Color.RED);
        }
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };


    @Override
    protected void onResume() {
        super.onResume();
       //SM.registerListener(this, mygirosopo, SensorManager.SENSOR_DELAY_NORMAL);
    }



}
