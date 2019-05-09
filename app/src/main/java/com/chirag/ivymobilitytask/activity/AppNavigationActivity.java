package com.chirag.ivymobilitytask.activity;


import com.chirag.ivymobilitytask.fragment.DisplaySeatFragment;
import com.chirag.ivymobilitytask.fragment.MatrixListFragment;
import com.chirag.ivymobilitytask.iNavigator;
import com.chirag.ivymobilitytask.model.Matrix;

import java.util.ArrayList;

/**
 * Created by ADNROID1 on 12-07-2017.
 */

public class AppNavigationActivity extends BaseActivity implements iNavigator {
    @Override
    public void openDisplaySeatFragment(ArrayList<Matrix> matrices, int noOfPerson) {
        fragmentChange(DisplaySeatFragment.newInstance(matrices, noOfPerson));
    }

    @Override
    public void openMatrixFragment() {
        fragmentChange(MatrixListFragment.newInstance());
    }


}
