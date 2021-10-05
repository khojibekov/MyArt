package com.example.myart;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class MyOrdersFragment extends Fragment {


    public MyOrdersFragment() {

    }

    private RecyclerView myOrdersRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my_orders, container, false);

        myOrdersRecyclerView = view.findViewById(R.id.my_orders_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        myOrdersRecyclerView.setLayoutManager(linearLayoutManager);
        List<MyOrderItemModel> myOrderItemModelList = new ArrayList<>();
        myOrderItemModelList.add(new MyOrderItemModel("Картина1", 3, R.drawable.imageseven, "Доставлено 7 июнья"));
        myOrderItemModelList.add(new MyOrderItemModel("Картина2", 5, R.drawable.imagetwo, "Доставлено 9 июнья"));
        myOrderItemModelList.add(new MyOrderItemModel("Картина3", 5, R.drawable.imagefive, "Отменено"));
        myOrderItemModelList.add(new MyOrderItemModel("Картина4", 4, R.drawable.imagefour, "Доставлено 12 июнья"));
        MyOrderAdapter myOrderAdapter = new MyOrderAdapter(myOrderItemModelList);
myOrdersRecyclerView.setAdapter(myOrderAdapter);
myOrderAdapter.notifyDataSetChanged();
        return view;
    }
}
