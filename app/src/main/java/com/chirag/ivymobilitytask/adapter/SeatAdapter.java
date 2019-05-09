package com.chirag.ivymobilitytask.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.chirag.ivymobilitytask.R;
import com.chirag.ivymobilitytask.SeatType;
import com.chirag.ivymobilitytask.model.Matrix;
import com.chirag.ivymobilitytask.model.Seat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SeatAdapter extends RecyclerView.Adapter<SeatAdapter.ViewHolder> {

    private static final String TAG = SeatAdapter.class.getSimpleName();
    private Context context;
    private List<Matrix> matrices;
    private int noOfPassenger;


    public HashMap<Integer, List<Seat>> getRowWiseSheetList() {
        return rowWiseSheetList;
    }

    private HashMap<Integer, List<Seat>> rowWiseSheetList;

    public List<Seat> getSeatList() {
        return seatList;
    }

    private List<Seat> seatList;

    public static class ViewHolder extends RecyclerView.ViewHolder {


        TableLayout tableLayout;

        public ViewHolder(View view) {
            super(view);
            tableLayout = view.findViewById(R.id.tableLayout1);
        }
    }

    public SeatAdapter(Context context, List<Matrix> matrices, int noOfPassenger) {
        this.context = context;
        this.matrices = matrices;
        this.noOfPassenger = noOfPassenger;


        seatList = new ArrayList<>();
        rowWiseSheetList = new HashMap<>();

    }

    @NonNull
    @Override
    public SeatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_seat, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        fillTable(holder.tableLayout, matrices.get(position), position);



    }

    @Override
    public int getItemCount() {
        return matrices.size();
    }


    private void fillTable(TableLayout table, Matrix matrix, int position) {
        table.removeAllViews();

        for (int i = 1; i <= matrix.getRow(); i++) {

            TableRow row = new TableRow(context);
            row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

            for (int j = 1; j <= matrix.getCol(); j++) {
                if (position == 0) { // First Matrix
                    if (j == 1) {
                        row.addView(getTextView(new Seat(i, j, SeatType.WINDOWS, position)));
                    } else if (j == matrix.getCol()) {
                        if (matrices.size() == 1) { // When we have only single matrix
                            row.addView(getTextView(new Seat(i, j, SeatType.WINDOWS, position)));
                        } else {
                            row.addView(getTextView(new Seat(i, j, SeatType.ASILE, position)));
                        }
                    } else {
                        row.addView(getTextView(new Seat(i, j, SeatType.MIDDLE, position)));
                    }
                } else if (position == matrices.size() - 1) { //Last Matrix
                    if (j == matrix.getCol()) {
                        row.addView(getTextView(new Seat(i, j, SeatType.WINDOWS, position)));
                    } else if (j == 1) {
                        row.addView(getTextView(new Seat(i, j, SeatType.ASILE, position)));
                    } else {
                        row.addView(getTextView(new Seat(i, j, SeatType.MIDDLE, position)));
                    }
                } else { // Middle Matrix
                    if (j == 1 || j == matrix.getCol()) {
                        row.addView(getTextView(new Seat(i, j, SeatType.ASILE, position)));
                    } else {
                        row.addView(getTextView(new Seat(i, j, SeatType.MIDDLE, position)));
                    }
                }

            }

            table.addView(row);


        }
    }

    TextView getTextView(Seat seat) {

        if (rowWiseSheetList.get(seat.getRow()) == null) {
            List<Seat> list = new ArrayList<>();
            list.add(seat);
            rowWiseSheetList.put(seat.getRow(), list);
        } else {
            List<Seat> list = rowWiseSheetList.get(seat.getRow());
            list.add(seat);
            rowWiseSheetList.put(seat.getRow(), list);
        }


        TextView edit = new TextView(context);
        edit.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
        edit.setGravity(Gravity.CENTER);
        switch (seat.getType()) {
            case WINDOWS:
                edit.setBackgroundResource(R.drawable.ic_windows);
                break;
            case ASILE:
                edit.setBackgroundResource(R.drawable.ic_asile);
                break;
            case MIDDLE:
                edit.setBackgroundResource(R.drawable.ic_middle);
                break;
        }
        seat.setTextView(edit);
        seatList.add(seat);


        return edit;
    }


}
