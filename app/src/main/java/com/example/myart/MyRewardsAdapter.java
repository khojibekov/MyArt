package com.example.myart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRewardsAdapter extends RecyclerView.Adapter<MyRewardsAdapter.ViewHolder> {

    private List<RewardModel> rewardModelList;

    public MyRewardsAdapter(List<RewardModel> rewardModelList) {
        this.rewardModelList = rewardModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rewards_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String title = rewardModelList.get(position).getTitle();
        String date = rewardModelList.get(position).getExpiryDate();
        String body = rewardModelList.get(position).getCoupanBody();
        holder.setData(title, date, body);


    }

    @Override
    public int getItemCount() {
        return rewardModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView coupanTitle, coupanExpiryDate, coupanBody;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            coupanTitle = itemView.findViewById(R.id.coupan_title);
            coupanExpiryDate = itemView.findViewById(R.id.coupan_validity);
            coupanBody = itemView.findViewById(R.id.coupan_body);
        }
        private void setData(String title, String date, String body){
            coupanTitle.setText(title);
            coupanExpiryDate.setText(date);
            coupanBody.setText(body);
        }
    }
}
