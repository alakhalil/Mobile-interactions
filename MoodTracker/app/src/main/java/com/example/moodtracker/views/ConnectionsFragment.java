package com.example.moodtracker.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moodtracker.R;
import com.example.moodtracker.databinding.MoreConnectionsBinding;
import com.example.moodtracker.databinding.MoreRequestsBinding;
import com.example.moodtracker.databinding.MoreMembersBinding;
public class ConnectionsFragment extends Fragment {

    private MoreConnectionsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = MoreConnectionsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_page12Fragment_to_page13Fragment);
            }
        });

        return root;
    }
}