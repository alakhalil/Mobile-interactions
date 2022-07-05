package com.example.moodtracker.views;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.moodtracker.R;
import com.example.moodtracker.databinding.FragmentFeelingsBinding;
import com.example.moodtracker.viewmodels.HomeViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class FeelingsFragment extends BottomSheetDialogFragment {

    private FragmentFeelingsBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentFeelingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        final TextView todayDate = binding.todayDate;
        final TextView feelingQuestion = binding.howDoYouFeel;

        // TODO: move this data logic to a view model!
        Date now = new Date();
        String date = new SimpleDateFormat("EEE, d MMM HH:mm",
                Locale.ENGLISH).format(now);
        todayDate.setText(date);
        feelingQuestion.setText("How do you feel?");

        /*
         Actions of the feelings btns
         */
        final ImageButton depressedBtn = binding.cryBtn;
        depressedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSheetDialogStrongFeelings();
            }
        });

        final ImageButton HappyBtn = binding.happyBtn;
        HappyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSheetDialogNormalFeelings();
            }
        });
        return root;
    }

    public void showBottomSheetDialogStrongFeelings() {
        BottomSheetDialog bottomSheetStrongFeelings = new BottomSheetDialog(getActivity());
        bottomSheetStrongFeelings.setContentView(R.layout.strong_feelings_input);
        bottomSheetStrongFeelings.getBehavior().setPeekHeight(1000);
        bottomSheetStrongFeelings.show();
    }

    public void showBottomSheetDialogNormalFeelings() {
/*        BottomSheetDialog bottomSheetNormalFeelings = new BottomSheetDialog(getActivity());
        bottomSheetNormalFeelings.setContentView(R.layout.normal_feelings);
        bottomSheetNormalFeelings.getBehavior().setPeekHeight(1000);
        bottomSheetNormalFeelings.show();*/

        Fragment fragment = new ReasonsFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.parent_layout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}