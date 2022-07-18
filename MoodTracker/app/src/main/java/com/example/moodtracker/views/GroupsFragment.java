package com.example.moodtracker.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moodtracker.R;
import com.example.moodtracker.databinding.FragmentMoreBinding;
import com.example.moodtracker.databinding.MoreGroupsBinding;
import java.util.Objects;

public class GroupsFragment extends Fragment {
    private MoreGroupsBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = MoreGroupsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


    binding.doctor.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Navigation.findNavController(view).navigate(R.id.action_page7Fragment_to_page8Fragment);
        }
    });
        binding.family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_page7Fragment_to_page8Fragment);
            }
        });
        binding.closeFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_page7Fragment_to_page8Fragment);
            }
        });
        binding.friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_page7Fragment_to_page8Fragment);
            }
        });

        binding.other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.linear.setVisibility(View.VISIBLE);
            }
        });

        binding.addNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name =  binding.editNew.getText().toString();
                binding.newGroup.setVisibility(View.VISIBLE);
                binding.other.setText(name);
                binding.other.setCompoundDrawablesWithIntrinsicBounds(R.drawable.help_circle, 0, R.drawable.chevron_right, 0);
                binding.other.setClickable(false);
                binding.linear.setVisibility(View.INVISIBLE);
            }
        });



        return root;
    }
}