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


public class MyRewardsFragment extends Fragment {


    public MyRewardsFragment() {

    }
private RecyclerView rewardsRecyclerview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_rewards, container, false);
        rewardsRecyclerview = view.findViewById(R.id.my_rewards_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        rewardsRecyclerview.setLayoutManager(linearLayoutManager);

        List<RewardModel> rewardModelList = new ArrayList<>();
        rewardModelList.add(new RewardModel("Кешбэк ","до 17.08.2021", "Получить скидку 20% на любой продукт стоимостью ниже 1.000.000 сум"));
        rewardModelList.add(new RewardModel("Кешбэк ","до 17.08.2021", "Получить скидку 20% на любой продукт стоимостью ниже 1.000.000 сум"));
        rewardModelList.add(new RewardModel("Кешбэк ","до 17.08.2021", "Получить скидку 20% на любой продукт стоимостью ниже 1.000.000 сум"));
        rewardModelList.add(new RewardModel("Кешбэк ","до 17.08.2021", "Получить скидку 20% на любой продукт стоимостью ниже 1.000.000 сум"));
        rewardModelList.add(new RewardModel("Кешбэк ","до 17.08.2021", "Получить скидку 20% на любой продукт стоимостью ниже 1.000.000 сум"));
        rewardModelList.add(new RewardModel("Кешбэк ","до 17.08.2021", "Получить скидку 20% на любой продукт стоимостью ниже 1.000.000 сум"));
        rewardModelList.add(new RewardModel("Кешбэк ","до 17.08.2021", "Получить скидку 20% на любой продукт стоимостью ниже 1.000.000 сум"));

       MyRewardsAdapter myRewardsAdapter = new MyRewardsAdapter(rewardModelList);
       rewardsRecyclerview.setAdapter(myRewardsAdapter);
       myRewardsAdapter.notifyDataSetChanged();


        return view;
    }


}