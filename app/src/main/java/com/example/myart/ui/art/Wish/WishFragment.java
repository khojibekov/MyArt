package com.example.myart.ui.art.Wish;

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
import com.example.myart.ui.art.Art.ArtViewModel;

public class WishFragment extends Fragment {

    private WishViewModel mWishViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mWishViewModel =
                new ViewModelProvider(this).get(WishViewModel.class);
        View root = inflater.inflate(R.layout.fragment_wish, container, false);
        final TextView textView = root.findViewById(R.id.text_wish);
        mWishViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
