package com.example.moodtracker.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moodtracker.R;
import com.example.moodtracker.databinding.ConnectionsBinding;
import com.example.moodtracker.databinding.RequestsBinding;

public class Requests extends Fragment {

    private RequestsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = RequestsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }
}