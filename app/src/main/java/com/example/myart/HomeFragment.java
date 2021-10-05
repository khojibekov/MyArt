package com.example.myart;

import android.graphics.Color;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class HomeFragment extends Fragment {

    public HomeFragment() {

    }

    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;
    private RecyclerView testing;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        categoryRecyclerView = view.findViewById(R.id.category_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);

        final List<CategoryModel> categoryModelList = new ArrayList<CategoryModel>();
        categoryModelList.add(new CategoryModel("link", "Картины"));
        categoryModelList.add(new CategoryModel("link", "Живопись"));
        categoryModelList.add(new CategoryModel("link", "Графика"));
        categoryModelList.add(new CategoryModel("link", "Скульптура"));
        categoryModelList.add(new CategoryModel("link", "Фрески"));
        categoryModelList.add(new CategoryModel("link", "Фотообои"));
        categoryModelList.add(new CategoryModel("link", "Витражи"));
        categoryModelList.add(new CategoryModel("link", "Багетная"));
        categoryModelList.add(new CategoryModel("link", "Потртреты"));
        categoryModelList.add(new CategoryModel("link", "Ретушь Фото"));

        categoryAdapter = new CategoryAdapter(categoryModelList);
        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();


        List<SliderModel> sliderModelList = new ArrayList<SliderModel>();

        sliderModelList.add(new SliderModel(R.drawable.imageseven, "#D5D5D5"));
        sliderModelList.add(new SliderModel(R.drawable.imagefour, "#D5D5D5"));
        sliderModelList.add(new SliderModel(R.drawable.imagefive, "#D5D5D5"));
        sliderModelList.add(new SliderModel(R.drawable.imagesix, "#D5D5D5"));


        List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.imageone, "Картина", "Описание", "Цена"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.imagetwo, "Картина", "Описание", "Цена"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.imagethree, "Картина", "Описание", "Цена"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.imagefour, "Картина", "Описание", "Цена"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.imagefive, "Картина", "Описание", "Цена"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.imagesix, "Картина", "Описание", "Цена"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.imageseven, "Картина", "Описание", "Цена"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.imageeight, "Картина", "Описание", "Цена"));


        testing = view.findViewById(R.id.home_page_recyclerview);
        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(getContext());
        testingLayoutManager.setOrientation(RecyclerView.VERTICAL);
        testing.setLayoutManager(testingLayoutManager);

        List<HomePageModel> homePageModelList = new ArrayList<>();

        homePageModelList.add(new HomePageModel(0, sliderModelList));
        homePageModelList.add(new HomePageModel(1, R.drawable.uzb_pic, "#ff0000"));
        homePageModelList.add(new HomePageModel(2, "Рекомендации", horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3, "Рекомендации", horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1, R.drawable.uzb_pic, "#000000"));
        homePageModelList.add(new HomePageModel(2, "Рекомендации", horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3, "Рекомендации", horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1, R.drawable.uzb_pic, "#fff000"));
        homePageModelList.add(new HomePageModel(0, sliderModelList));

        HomePageAdapter homePageAdapter = new HomePageAdapter(homePageModelList);
        testing.setAdapter(homePageAdapter);
        homePageAdapter.notifyDataSetChanged();


        return view;


    }


}