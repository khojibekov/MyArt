package com.example.myart.ui.art.Reward;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myart.R;


public class RewardFragment  extends Fragment {

    private RewardViewModel mRewardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mRewardViewModel =
                new ViewModelProvider(this).get(RewardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_reward, container, false);
        final TextView textView = root.findViewById(R.id.text_reward);
        mRewardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}