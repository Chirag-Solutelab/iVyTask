package com.chirag.ivymobilitytask.dialog;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.chirag.ivymobilitytask.R;
import com.chirag.ivymobilitytask.listener.iCallback;
import com.chirag.ivymobilitytask.model.Matrix;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class AddMatrixRowAndColDialog extends DialogFragment {

    @BindView(R.id.edtRow)
    EditText edtRow;
    @BindView(R.id.edtCol)
    EditText edtCol;
    @BindView(R.id.btnSubmit)
    Button btnSubmit;
    Unbinder unbinder;

    public void setCallback(iCallback callback) {
        this.callback = callback;
    }

    private iCallback callback;

    public static AddMatrixRowAndColDialog newInstance(iCallback callback) {
        AddMatrixRowAndColDialog fragment = new AddMatrixRowAndColDialog();
        fragment.setCallback(callback);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_add_row_col, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btnSubmit)
    public void onViewClicked() {

        if (validation()) {
            callback.submitMatrix(new Matrix(Integer.parseInt(edtRow.getText().toString()),
                    Integer.parseInt(edtCol.getText().toString())));
            dismiss();
        }
    }

    boolean validation() {

        if (edtRow.getText().toString().isEmpty()) {
            Toast.makeText(getContext(), "Please enter row", Toast.LENGTH_SHORT).show();
            return false;
        } else if (edtCol.getText().toString().isEmpty()) {
            Toast.makeText(getContext(), "Please enter column", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
