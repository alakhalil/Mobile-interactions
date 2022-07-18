package com.example.moodtracker.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moodtracker.R;
import com.example.moodtracker.databinding.MoreConnectionsBinding;
import com.example.moodtracker.databinding.MoreRequestsBinding;

public class RequestsFragment extends Fragment {

    private MoreRequestsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = MoreRequestsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }
}