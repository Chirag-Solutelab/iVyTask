package com.chirag.ivymobilitytask.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.chirag.ivymobilitytask.R;
import com.chirag.ivymobilitytask.activity.AppNavigationActivity;
import com.chirag.ivymobilitytask.adapter.MatrixListAdapter;
import com.chirag.ivymobilitytask.dialog.AddMatrixRowAndColDialog;
import com.chirag.ivymobilitytask.dialog.NoPassengerDialog;
import com.chirag.ivymobilitytask.listener.iCallback;
import com.chirag.ivymobilitytask.model.Matrix;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Chirag Solanki on 09-05-2019.
 */
public class MatrixListFragment extends BaseFragment implements iCallback {

    @BindView(R.id.rvItem)
    RecyclerView rvItem;
    @BindView(R.id.btnMatrix)
    Button btnMatrix;
    @BindView(R.id.btnViewSeat)
    Button btnViewSeat;
    Unbinder unbinder;
    ArrayList<Matrix> matrices = new ArrayList<>();
    private MatrixListAdapter adapter;
    private AppNavigationActivity appNavigationActivity;

    public static MatrixListFragment newInstance() {
        MatrixListFragment fragment = new MatrixListFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_matrix_list, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof AppNavigationActivity)
            appNavigationActivity = (AppNavigationActivity) context;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        rvItem.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new MatrixListAdapter(getContext(), matrices);
        rvItem.setAdapter(adapter);

    }

    @OnClick({R.id.btnMatrix, R.id.btnViewSeat})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnMatrix:
                AddMatrixRowAndColDialog dialog = AddMatrixRowAndColDialog.newInstance(this);
                dialog.show(getFragmentManager(), dialog.getTag());
                break;
            case R.id.btnViewSeat:
                NoPassengerDialog noPassengerDialog = NoPassengerDialog.newInstance(this);
                noPassengerDialog.show(getFragmentManager(), noPassengerDialog.getTag());
                break;
        }
    }

    @Override
    public void submitMatrix(Matrix matrix) {
        btnViewSeat.setVisibility(View.VISIBLE);
        matrices.add(matrix);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void submitNoofPassenger(int no) {
        appNavigationActivity.openDisplaySeatFragment(matrices, no);
    }
}
