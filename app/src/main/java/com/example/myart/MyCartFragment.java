package com.example.myart;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;


public class MyCartFragment extends Fragment {



    public MyCartFragment() {

    }

    private RecyclerView cartItemsRecyclerView;
    private Button continueBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_cart, container, false);

        cartItemsRecyclerView = view.findViewById(R.id.cart_items_recycler_view);
        continueBtn = view.findViewById(R.id.cart_continue_btn);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        cartItemsRecyclerView.setLayoutManager(linearLayoutManager);

        List<CartItemModel> cartItemModelList = new ArrayList<>();
        cartItemModelList.add(new CartItemModel(0, R.drawable.imageeight, "Картина 1", 2, "Цена", "Цена", 1, 0, 0));
        cartItemModelList.add(new CartItemModel(0, R.drawable.imageeight, "Картина 1", 2, "Цена", "Цена", 1, 0, 0));
        cartItemModelList.add(new CartItemModel(0, R.drawable.imageeight, "Картина 1", 2, "Цена", "Цена", 1, 0, 0));
        cartItemModelList.add(new CartItemModel(1, "Цена 3 картирин","Цена", "Бесплатно", "Цена", "Бонус"));

        CartAdapter cartAdapter = new CartAdapter(cartItemModelList);
        cartItemsRecyclerView.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();


        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deliveryIntent = new Intent(getContext(), AddAdressActivity.class);
                getContext().startActivity(deliveryIntent);
            }
        });
        return view;
    }
}