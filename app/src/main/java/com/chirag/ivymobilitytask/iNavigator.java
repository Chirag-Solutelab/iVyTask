package com.chirag.ivymobilitytask;

import com.chirag.ivymobilitytask.model.Matrix;

import java.util.ArrayList;

/**
 * Created by Chirag Solanki on 09-05-2019.
 */
public interface iNavigator {
    void openDisplaySeatFragment(ArrayList<Matrix> matrices, int i);
    void openMatrixFragment();
}
