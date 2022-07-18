package com.example.moodtracker.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moodtracker.R;
import com.example.moodtracker.adapters.ContactsCustomAdapter;
import com.example.moodtracker.databinding.MoreMembersBinding;
import com.example.moodtracker.models.Member;

import java.util.ArrayList;

public class MembersFragment extends Fragment {
    private MoreMembersBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = MoreMembersBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ArrayList<Member> arrayList = new ArrayList<Member>();
        ContactsCustomAdapter customAdapter = new ContactsCustomAdapter(getActivity(),arrayList);
        arrayList.add(new Member("Ava Nathan",R.drawable.avatar1));
        arrayList.add(new Member("Camilo Odyllo",R.drawable.avatar2));
        arrayList.add(new Member("Derek Mac",R.drawable.avatar3));
        arrayList.add(new Member("Jack Uke",R.drawable.avatar4));
        arrayList.add(new Member("John Doe",R.drawable.avatar5));
        arrayList.add(new Member("Haifa Nato",R.drawable.avatar6));
        arrayList.add(new Member("Layla Florian",R.drawable.avatar7));
        arrayList.add(new Member("Liah Kaylee",R.drawable.avatar8));
        binding.recycler.setAdapter(customAdapter);


        return root;
    }
}