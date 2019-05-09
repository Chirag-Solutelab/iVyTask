package com.chirag.ivymobilitytask.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chirag.ivymobilitytask.R;
import com.chirag.ivymobilitytask.model.Matrix;

import java.util.List;

/**
 * Created by Chirag Solanki on 09-05-2019.
 */
public class MatrixListAdapter extends RecyclerView.Adapter<MatrixListAdapter.ViewHolder> {

    private Context context;

    public MatrixListAdapter(Context context, List<Matrix> matrices) {
        this.context = context;
        this.matrices = matrices;
    }

    private List<Matrix> matrices;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_matrix_list, viewGroup, false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Matrix matrix = matrices.get(position);
        viewHolder.tvItem.setText(matrix.getRow() + " * " + matrix.getCol());
    }

    @Override
    public int getItemCount() {
        return matrices.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        private TextView tvItem;

        public ViewHolder(View view) {
            super(view);
            tvItem = (TextView) view.findViewById(R.id.tvItem);
        }
    }

}
