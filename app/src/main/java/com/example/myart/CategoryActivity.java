package com.example.myart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView categoryRecyclerView;
    HomePageAdapter mHomePageAdapter;

    //private List<CategoryModel> categoryModelFakeList=new ArrayList<>();
    private List<HomePageModel> homePageModelList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String title=getIntent().getStringExtra("CategoryName");
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        List<SliderModel> sliderModelList = new ArrayList<SliderModel>();

        sliderModelList.add(new SliderModel(R.drawable.imagefive, "#D5D5D5"));
        sliderModelList.add(new SliderModel(R.drawable.imagesix, "#D5D5D5"));
        sliderModelList.add(new SliderModel(R.drawable.imageseven, "#D5D5D5"));
        sliderModelList.add(new SliderModel(R.drawable.imageeight, "#D5D5D5"));


        List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.imageone, "Картина", "Описание", "Цена"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.imagetwo, "Картина", "Описание", "Цена"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.imagethree, "Картина", "Описание", "Цена"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.imagefour, "Картина", "Описание", "Цена"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.imagefive, "Картина", "Описание", "Цена"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.imagesix, "Картина", "Описание", "Цена"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.imageseven, "Картина", "Описание", "Цена"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.imageeight, "Картина", "Описание", "Цена"));



        List<HomePageModel> homePageModelList = new ArrayList<>();

        homePageModelList.add(new HomePageModel(0, sliderModelList));
        homePageModelList.add(new HomePageModel(1, R.drawable.uzb_pic, "#ff0000"));
        homePageModelList.add(new HomePageModel(2, "Рекомендации", horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3, "Рекомендации", horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1, R.drawable.uzb_pic, "#000000"));
        homePageModelList.add(new HomePageModel(2, "Рекомендации", horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3, "Рекомендации", horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1, R.drawable.uzb_pic, "#fff000"));


        categoryRecyclerView=findViewById(R.id.category_recycler);

        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(this);
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        categoryRecyclerView.setLayoutManager(testingLayoutManager);

        mHomePageAdapter=new HomePageAdapter(homePageModelList);



        categoryRecyclerView.setAdapter(mHomePageAdapter);
        mHomePageAdapter.notifyDataSetChanged();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_icon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if(id==R.id.main_search_icon){
            startActivity(new Intent(CategoryActivity.this,SearchActivity.class));
            return true;
        }else if(id == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}