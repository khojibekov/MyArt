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


public class MyWishlistFragment extends Fragment {

   private RecyclerView wishlistRecyclerview;

    public MyWishlistFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_wishlist, container, false);
        wishlistRecyclerview=view.findViewById(R.id.my_wishlist_recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        wishlistRecyclerview.setLayoutManager(linearLayoutManager);

        List<WishlistModel> wishlistModelList = new ArrayList<>();
        wishlistModelList.add(new WishlistModel(R.drawable.imagetwo, "Картина", 1, "3", 55, "Цена", "Цена", "Оплата при получении"));
        wishlistModelList.add(new WishlistModel(R.drawable.imagetwo, "Картина", 1, "3", 55, "Цена", "Цена", "Оплата при получении"));
        wishlistModelList.add(new WishlistModel(R.drawable.imagetwo, "Картина", 1, "3", 55, "Цена", "Цена", "Оплата при получении"));
        wishlistModelList.add(new WishlistModel(R.drawable.imagetwo, "Картина", 1, "3", 55, "Цена", "Цена", "Оплата при получении"));
        wishlistModelList.add(new WishlistModel(R.drawable.imagetwo, "Картина", 1, "3", 55, "Цена", "Цена", "Оплата при получении"));

        WishlistAdapter wishlistAdapter = new WishlistAdapter(wishlistModelList);
        wishlistRecyclerview.setAdapter(wishlistAdapter);
        wishlistAdapter.notifyDataSetChanged();

        return view;
    }
}