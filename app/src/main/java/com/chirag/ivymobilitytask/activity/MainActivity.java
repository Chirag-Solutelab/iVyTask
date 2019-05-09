package com.chirag.ivymobilitytask.activity;

import android.os.Bundle;
import android.util.Log;

import com.chirag.ivymobilitytask.R;

public class MainActivity extends AppNavigationActivity {

    private static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //openDisplaySeatFragment(matrices, 50);
        openMatrixFragment();
    }

    @Override
    public void onBackPressed() {



        int i = getSupportFragmentManager().getBackStackEntryCount();
        Log.e(TAG, "I - " + i);
        if (i > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            this.finish();
        }

    }
}
