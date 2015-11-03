package com.khesyc.ahardy.ahardyDev;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Fragments Tutorial and Assignment
 *
 * created date = October 11, 2015
 * last modified date = October 11, 2015
 *
 * @author Aaron Hardy
 * @version 1.0.101115
 */
public class ActivityGame extends Activity {
    String theWord = "word";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //activate the main activity
        setContentView(R.layout.activity_game);

        //create fragment manager
        FragmentManager fragmentManager = getFragmentManager();
        //open the fragment transaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //initialize the configuration settings
        Configuration configuration = getResources().getConfiguration();

        //check configuration settings for screen orientation
        if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            //in portrait orientation, run hideSidePanel
            hideSidePanel();
        }

        //commit the fragment transactions
        fragmentTransaction.commit();
    }

    public void newLetter(View view) {
        EditText editText = (EditText) findViewById(R.id.inputLetter);

        String newLetter = editText.getText().toString();

        editText.setText("");

        Log.d("MYLOG", "The letter is: " + newLetter);

        if (newLetter.length() == 1) {
            checkLetter(newLetter);
        } else {
            Toast.makeText(this, "Please Enter a Single Letter", Toast.LENGTH_SHORT).show();
        }
    }

    public void checkLetter(String letter) {
        Toast.makeText(this, "check letter: " + letter, Toast.LENGTH_SHORT).show();

        char aLetter = letter.charAt(0);

        boolean letterGuessed = false;

        for (int i = 0; i < theWord.length(); i++) {
            if (theWord.charAt(i) == aLetter) {
                letterGuessed = true;
                Log.d("MYLOG", "Letter Found " + aLetter);
                showLetter(i, aLetter);
            } else {

            }
        } //end for
    }

    public void showLetter(int position, char letterGuessed) {
        LinearLayout layout = (LinearLayout) findViewById(R.id.layoutLetters);

        TextView textView = (TextView) layout.getChildAt(position);

        textView.setText(Character.toString(letterGuessed));
    }

    /**
     * hideSidePanel finds the side panel and hides it if it is currently visible
     *
     * created date = October 11, 2015
     * last modified date = October 11, 2015
     *
     * @author Aaron Hardy
     * @version 1.0.101115
     */
    private void hideSidePanel() {
        //get the sidePanel view
        View sidePane = findViewById(R.id.side_fragment);
        //check if it is still visible
        if (sidePane.getVisibility() == View.VISIBLE) {
            //hide it
            sidePane.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
