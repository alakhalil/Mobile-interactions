package com.example.moodtracker.views;


import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
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
import java.util.List;
import java.util.Locale;

public class HomeFragment extends Fragment {

    private ListAdapter listAdapter;
    private FragmentHomeBinding binding;
    private HomeViewModel homeViewModel ;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        homeViewModel.init();
        homeViewModel.getEntries().observe(getActivity(), new Observer<ArrayList<Entry>>() {
            @Override
            public void onChanged(ArrayList<Entry> entries) {
                listAdapter.notifyDataSetChanged();
            }
        });

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        initListView();

        // To open the dialog
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                showBottomSheetDialog();
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

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void showBottomSheetDialog() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getActivity());
        bottomSheetDialog.setContentView(R.layout.select_feeling_dialog);
        bottomSheetDialog.getBehavior().setPeekHeight(1000);

        final TextView todayDate = bottomSheetDialog.findViewById(R.id.todayDate);
        final TextView feelingQuestion = bottomSheetDialog.findViewById(R.id.howDoYouFeel);
        Date now = new Date();
        String date = new SimpleDateFormat("EEE, d MMM HH:mm", Locale.ENGLISH).format(now);

        todayDate.setText(date);
        feelingQuestion.setText("How do you feel?");
        bottomSheetDialog.show();

        final ImageButton dperessedBtn = bottomSheetDialog.findViewById(R.id.cry_btn);
        dperessedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSheetDialogStrongFeelings();
                bottomSheetDialog.dismiss();
            }
        });

        final ImageButton HappyBtn = bottomSheetDialog.findViewById(R.id.happy_btn);
        HappyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSheetDialogNormalFeelings();
                bottomSheetDialog.dismiss();
            }
        });

        ImageButton dialogButton = (ImageButton) bottomSheetDialog.findViewById(R.id.btnClose);

        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog.dismiss();
            }
        });

    }

    public void showBottomSheetDialogStrongFeelings() {
        BottomSheetDialog bottomSheetStrongFeelings = new BottomSheetDialog(getActivity());
        bottomSheetStrongFeelings.setContentView(R.layout.strong_feelings_input);
        bottomSheetStrongFeelings.getBehavior().setPeekHeight(1000);
        bottomSheetStrongFeelings.show();
    }

    public void showBottomSheetDialogNormalFeelings() {
        BottomSheetDialog bottomSheetNormalFeelings = new BottomSheetDialog(getActivity());
        bottomSheetNormalFeelings.setContentView(R.layout.normal_feelings);
        bottomSheetNormalFeelings.getBehavior().setPeekHeight(1000);
        bottomSheetNormalFeelings.show();
    }

}