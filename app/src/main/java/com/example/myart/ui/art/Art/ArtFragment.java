package com.example.myart.ui.art.Art;

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

public class ArtFragment  extends Fragment {

    private ArtViewModel mArtViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mArtViewModel =
                new ViewModelProvider(this).get(ArtViewModel.class);
        View root = inflater.inflate(R.layout.fragment_art, container, false);
        final TextView textView = root.findViewById(R.id.text_art);
        mArtViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}