package com.nick.a75fapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Nick Khoury on 2017-06-06.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
    function: called when user taps the Light button
    */
    public void senseLight(View view) {
        // respond to the user's button press here
        // An Intent is an object that provides runtime binding between separate components, such as two activities
        Intent intent = new Intent(this, LightSensorActivity.class);
        startActivity(intent);
    }

    /*
    function: called when user taps the Light button
     */
    public void sensePressure(View view) {
        // respond to the user's button press here
        // An Intent is an object that provides runtime binding between separate components, such as two activities
        Intent intent = new Intent(this, PressureSensorActivity.class);
        startActivity(intent);
    }

    /*
    function: called when user taps the View DB button
     */
    public void viewDb(View view) {
        // respond to the user's button press here
        // An Intent is an object that provides runtime binding between separate components, such as two activities
        Intent intent = new Intent(this, ViewServerActivity.class);
        startActivity(intent);
    }
}
