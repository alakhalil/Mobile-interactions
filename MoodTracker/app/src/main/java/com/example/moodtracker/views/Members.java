package com.example.moodtracker.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moodtracker.R;
import com.example.moodtracker.databinding.MembersBinding;

import java.util.ArrayList;

public class Members extends Fragment {
    private MembersBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = MembersBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ArrayList<RVMembersModel> arrayList = new ArrayList<RVMembersModel>();
        CustomAdapter customAdapter = new CustomAdapter(getActivity(),arrayList);
        arrayList.add(new RVMembersModel("Ava Nathan",R.drawable.avatar1));
        arrayList.add(new RVMembersModel("Camilo Odyllo",R.drawable.avatar2));
        arrayList.add(new RVMembersModel("Derek Mac",R.drawable.avatar3));
        arrayList.add(new RVMembersModel("Jack Uke",R.drawable.avatar4));
        arrayList.add(new RVMembersModel("John Doe",R.drawable.avatar5));
        arrayList.add(new RVMembersModel("Haifa Nato",R.drawable.avatar6));
        arrayList.add(new RVMembersModel("Layla Florian",R.drawable.avatar7));
        arrayList.add(new RVMembersModel("Liah Kaylee",R.drawable.avatar8));
        binding.recycler.setAdapter(customAdapter);


        return root;
    }
}