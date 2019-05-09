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

import com.chirag.ivymobilitytask.R;
import com.chirag.ivymobilitytask.listener.iCallback;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class NoPassengerDialog extends DialogFragment {


    @BindView(R.id.edtPassenger)
    EditText edtPassenger;
    @BindView(R.id.btnSubmit)
    Button btnSubmit;
    Unbinder unbinder;

    public void setCallback(iCallback callback) {
        this.callback = callback;
    }

    private iCallback callback;

    public static NoPassengerDialog newInstance(iCallback callback) {
        NoPassengerDialog fragment = new NoPassengerDialog();
        fragment.setCallback(callback);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_no_of_passenger, container, false);
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
        callback.submitNoofPassenger(Integer.parseInt(edtPassenger.getText().toString()));
        dismiss();
    }
}
