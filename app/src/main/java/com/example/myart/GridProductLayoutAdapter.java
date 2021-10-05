package com.example.myart;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import java.util.List;

public class GridProductLayoutAdapter extends BaseAdapter {


    public GridProductLayoutAdapter(List<HorizontalProductScrollModel> horizontalProductScrollModelList) {
        this.horizontalProductScrollModelList = horizontalProductScrollModelList;

    }
    List<HorizontalProductScrollModel> horizontalProductScrollModelList;


    @Override
    public int getCount() {
        return horizontalProductScrollModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
     View view;
     if (convertView == null){
         view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_scroll_item_layout, null);
         view.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent productDetailsIntent = new Intent(parent.getContext(), ProductDetailsActivity.class);
                 parent.getContext().startActivity(productDetailsIntent);
             }
         });

         ImageView productImage = view.findViewById(R.id.h_s_product_image);
         TextView productTitle = view.findViewById(R.id.h_s_product_title);
         TextView productDescription = view.findViewById(R.id.h_s_product_description);
         TextView productPrice = view.findViewById(R.id.h_s_product_price);

         Glide.with(parent.getContext()).load(horizontalProductScrollModelList.get(position).getProductImage()).apply(new RequestOptions().placeholder(R.mipmap.logo)).into(productImage);
         productTitle.setText(horizontalProductScrollModelList.get(position).getProductTitle());
         productDescription.setText(horizontalProductScrollModelList.get(position).getProductDescription());
         productPrice.setText(horizontalProductScrollModelList.get(position).getProductPrice());
     }else{
         view = convertView;

     }
     return view;
    }
}
