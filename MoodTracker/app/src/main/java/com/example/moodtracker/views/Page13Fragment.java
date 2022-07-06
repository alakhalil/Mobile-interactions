package com.example.moodtracker.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moodtracker.R;
import com.example.moodtracker.databinding.FragmentPage12Binding;
import com.example.moodtracker.databinding.FragmentPage13Binding;

public class Page13Fragment extends Fragment {

    private FragmentPage13Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentPage13Binding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }
}