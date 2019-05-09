package com.chirag.ivymobilitytask.model;

/**
 * Created by Chirag Solanki on 08-05-2019.
 */
public class Matrix {



    private int row;

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    private int col;

    public Matrix(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
