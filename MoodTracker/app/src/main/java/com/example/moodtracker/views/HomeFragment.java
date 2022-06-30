package com.example.moodtracker.views;


import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.moodtracker.R;
import com.example.moodtracker.adapters.ListAdapter;
import com.example.moodtracker.databinding.FragmentHomeBinding;
import com.example.moodtracker.models.Entry;
import com.example.moodtracker.viewmodels.HomeViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class HomeFragment extends Fragment {

    private ListAdapter listAdapter;
    private FragmentHomeBinding binding;
    private HomeViewModel homeViewModel ;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        homeViewModel.init();
        homeViewModel.getEntries().observe(getActivity(), new Observer<ArrayList<Entry>>() {
            @Override
            public void onChanged(ArrayList<Entry> entries) {
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
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                showBottomSheetDialog();

                //TODO: move this function to the viewModel of feelingsFragment
                homeViewModel.addNewValue(new Entry("feeling sad", "No idea what I am doing", "10:30", 0, R.drawable.emoticon_sad_outline));
            }
        });

        return root;
    }

    private void initListView() {
        listAdapter = new ListAdapter(getActivity(), homeViewModel.getEntries().getValue());
        binding.entries.setAdapter(listAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void showBottomSheetDialog() {
        FeelingsFragment feelingsBottomSheetDialog = new FeelingsFragment();
        feelingsBottomSheetDialog.show(getFragmentManager(),"tag");

    }



    public void showProgressBar(){
        binding.progressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        binding.progressBar.setVisibility(View.GONE);
    }
}