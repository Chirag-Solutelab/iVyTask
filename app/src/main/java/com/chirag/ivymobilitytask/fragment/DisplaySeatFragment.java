package com.chirag.ivymobilitytask.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chirag.ivymobilitytask.R;
import com.chirag.ivymobilitytask.adapter.SeatAdapter;
import com.chirag.ivymobilitytask.SeatType;
import com.chirag.ivymobilitytask.model.Matrix;
import com.chirag.ivymobilitytask.model.Seat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Chirag Solanki on 09-05-2019.
 */
public class DisplaySeatFragment extends BaseFragment {

    @BindView(R.id.rvItem)
    RecyclerView recycle;
    Unbinder unbinder;
    private SeatAdapter adapter;

    public void setMatrices(List<Matrix> matrices) {
        this.matrices = matrices;
    }

    private List<Matrix> matrices;

    public void setNoOfPerson(int noOfPerson) {
        this.noOfPerson = noOfPerson;
    }

    private int noOfPerson;

    public static DisplaySeatFragment newInstance(List<Matrix> matrices, int noOfPerson) {
        DisplaySeatFragment fragment = new DisplaySeatFragment();
        fragment.setMatrices(matrices);
        fragment.setNoOfPerson(noOfPerson);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_seat_allocation, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        recycle.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        adapter = new SeatAdapter(getActivity(), matrices, 10);
        recycle.setAdapter(adapter);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 1; i <= noOfPerson; i++) {
                            bookSeat(i);
                        }
                    }
                });
            }
        }, 500);


    }

    private void bookSeat(int seat_number) {
        HashMap<Integer, List<Seat>> map = adapter.getRowWiseSheetList();
        Map<Integer, List<Seat>> treemap = new TreeMap<>(map);
        for (Map.Entry<Integer, List<Seat>> entry : treemap.entrySet()) {

            for (Seat s : entry.getValue()) {
                if (s.getType() == SeatType.ASILE && s.getBooking() <= -1) {
                    s.setBooking(seat_number);
                    s.getTextView().setText("" + seat_number);
                    return;
                }
            }
        }

        for (Map.Entry<Integer, List<Seat>> entry : treemap.entrySet()) {

            for (Seat s : entry.getValue()) {
                if (s.getType() == SeatType.WINDOWS && s.getBooking() <= -1) {
                    s.setBooking(seat_number);
                    s.getTextView().setText("" + seat_number);
                    return;
                }
            }
        }

        for (Map.Entry<Integer, List<Seat>> entry : treemap.entrySet()) {

            for (Seat s : entry.getValue()) {
                if (s.getType() == SeatType.MIDDLE && s.getBooking() <= -1) {
                    s.setBooking(seat_number);
                    s.getTextView().setText("" + seat_number);
                    return;
                }
            }
        }


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
