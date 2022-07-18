package com.example.moodtracker.views;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.moodtracker.R;
import com.example.moodtracker.adapters.EntriesListAdapter;
import com.example.moodtracker.databinding.FragmentHomeBinding;
import com.example.moodtracker.models.Entry;
import com.example.moodtracker.viewmodels.HomeViewModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private EntriesListAdapter listAdapter;
    private FragmentHomeBinding binding;
    private HomeViewModel homeViewModel ;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        homeViewModel = new ViewModelProvider(requireActivity()).get(HomeViewModel.class);
        homeViewModel.init();

        homeViewModel.getEntries().observe(getActivity(), new Observer<ArrayList<Entry>>() {
            @Override
            public void onChanged(ArrayList<Entry> entries) {

                 if (homeViewModel.getEntries().getValue().size()!=0) {
                    binding.emptyLog.setVisibility(View.GONE);
                }
                listAdapter.notifyDataSetChanged();
            }
        });

        homeViewModel.getIsUpdating().observe(getActivity(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    showProgressBar();
                }
                else{
                    hideProgressBar();
                    binding.entries.smoothScrollToPosition(homeViewModel.getEntries().getValue().size()-1);
                }
            }
        });

        initListView();

        // To open the dialog
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.navigation_feelings);
            }
        });
        Log.d("test", String.valueOf(homeViewModel.getEntries().getValue().size()));
        if(homeViewModel.getEntries().getValue().size()==0) {
            binding.emptyLog.setVisibility(View.VISIBLE);
        }


        return root;
    }

    private void initListView() {
        listAdapter = new EntriesListAdapter(getActivity(), homeViewModel.getEntries().getValue());
        binding.entries.setAdapter(listAdapter);
    }

    public void showProgressBar(){
        binding.progressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        binding.progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}