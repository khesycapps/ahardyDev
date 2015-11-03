package com.khesyc.ahardy.ahardyDev;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Splash Screen
 *
 * created date = October 11, 2015
 * last modified date = October 11, 2015
 *
 * @author Aaron Hardy
 * @version 1.0.101115
 */
public class ActivitySplash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //activate the splash activity
        setContentView(R.layout.activity_splash);

        //create a new Runnable
        Runnable wait3seconds = new Runnable() {
            public void run() {
                //run the nextActivity method
                nextActivity();
            }
        };

        //instantiate a new Handler
        Handler handler = new Handler();
        //use the handler to delay 3000 milliseconds (3 seconds)
        handler.postDelayed(wait3seconds, 3000);
    }

    /**
     * nextActivity advances the splash screen into the main activity
     *
     * created date = October 11, 2015
     *
     */
    public void nextActivity() {
        //declare the intent for the main activity
        Intent intent = new Intent(this, ActivityMain.class);
        //start the intent
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
