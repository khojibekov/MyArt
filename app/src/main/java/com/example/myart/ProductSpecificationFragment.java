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

public class ProductSpecificationFragment extends Fragment {


    public ProductSpecificationFragment() {

    }

    private RecyclerView productSpecificationRecyclerview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_product_specification, container, false);
        productSpecificationRecyclerview = view.findViewById(R.id.product_spesification_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        productSpecificationRecyclerview.setLayoutManager(linearLayoutManager);
        List<ProductSpecificationModel> productSpecificationModelList = new ArrayList<>();
        productSpecificationModelList.add(new ProductSpecificationModel("Название", "Текст...."));
        productSpecificationModelList.add(new ProductSpecificationModel("Название", "Текст...."));
        productSpecificationModelList.add(new ProductSpecificationModel("Название", "Текст...."));
        productSpecificationModelList.add(new ProductSpecificationModel("Название", "Текст...."));
        productSpecificationModelList.add(new ProductSpecificationModel("Название", "Текст...."));
        productSpecificationModelList.add(new ProductSpecificationModel("Название", "Текст...."));
        productSpecificationModelList.add(new ProductSpecificationModel("Название", "Текст...."));
        productSpecificationModelList.add(new ProductSpecificationModel("Название", "Текст...."));
        productSpecificationModelList.add(new ProductSpecificationModel("Название", "Текст...."));
        productSpecificationModelList.add(new ProductSpecificationModel("Название", "Текст...."));
        productSpecificationModelList.add(new ProductSpecificationModel("Название", "Текст...."));

        ProductSpecificationAdapter productSpecificationAdapter = new ProductSpecificationAdapter(productSpecificationModelList);
        productSpecificationRecyclerview.setAdapter(productSpecificationAdapter);
        productSpecificationAdapter.notifyDataSetChanged();

        return view;
    }
}