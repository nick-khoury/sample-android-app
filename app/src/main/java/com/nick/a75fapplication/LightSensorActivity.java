package com.nick.a75fapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Nick Khoury on 2017-06-06.
 */

public class LightSensorActivity extends AppCompatActivity implements SensorEventListener {
    public String no_sensor = "ERROR, NO SENSOR";
    private SensorManager mSensorManager;
    private Sensor mLight;
    private TextView textViewValue, textViewStatus;
    private String data = "";

    @Override
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_sensor);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        textViewValue = (TextView) findViewById(R.id.textViewValue);
        textViewStatus = (TextView) findViewById(R.id.textViewStatus);

        if (mLight == null) {
            //failure, sensor not found
            textViewValue.setText(no_sensor);
        }

    }

    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do something here if sensor accuracy changes.
    }

    @Override
    public final void onSensorChanged(SensorEvent event) {
        // The light sensor returns a single value.
        // Many sensors return 3 values, one for each axis.
        float lux = event.values[0];
        // Do something with this sensor value.
        textViewValue.setText(Float.toString(lux));
        data = Float.toString(lux);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mLight, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    public void pressPush(View view) {
        if (mLight != null) {
            Long result = Helper.pushDb("Light", data, this);
            textViewStatus.setText("DB insert row id: " + Long.toString(result));
        }
        else
        {
            textViewStatus.setText(no_sensor);
        }
    }
}
