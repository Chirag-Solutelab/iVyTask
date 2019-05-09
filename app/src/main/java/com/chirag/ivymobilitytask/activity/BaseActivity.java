package com.chirag.ivymobilitytask.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.chirag.ivymobilitytask.R;

/**
 * Created by Chirag Solanki on 09-05-2019.
 */
public class BaseActivity extends AppCompatActivity {
    void fragmentChange(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
      /*  if (fragmentState == FragmentState.ADD) {
            transaction.add(R.id.fragment_container, fragment);
        } else {
            transaction.replace(R.id.fragment_container, fragment);
        }*/
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(fragment.getClass().getSimpleName());
        transaction.commit();
    }

}