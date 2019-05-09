package com.chirag.ivymobilitytask.model;

import android.widget.TextView;

import com.chirag.ivymobilitytask.SeatType;

/**
 * Created by Chirag Solanki on 09-05-2019.
 */
public class Seat {
    int booking = -1;

    public int getBooking() {
        return booking;
    }

    public void setBooking(int booking) {
        this.booking = booking;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public SeatType getType() {
        return type;
    }

    public int getMatrixPosition() {
        return MatrixPosition;
    }

    private int row;
    private int col;
    private SeatType type;
    private int MatrixPosition;

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    private TextView textView;


    public Seat(int row, int col, SeatType type, int matrixPosition) {
        this.row = row;
        this.col = col;
        this.type = type;
        MatrixPosition = matrixPosition;
    }
}
