package com.khesyc.ahardy.ahardyDev;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Fragments Tutorial and Assignment
 *
 * create date = October 11, 2015
 * last modified date = October 11, 2015
 *
 * @author Aaron Hardy
 * @version 1.0.101115
 *
 * Created by Aaron on 10/11/2015.
 */
public class FragmentMain extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //inflate the main fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
}
