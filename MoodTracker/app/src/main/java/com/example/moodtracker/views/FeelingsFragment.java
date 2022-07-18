package com.example.moodtracker.views;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.moodtracker.R;
import com.example.moodtracker.databinding.FragmentFeelingsBinding;
import com.example.moodtracker.viewmodels.HomeViewModel;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FeelingsFragment extends BottomSheetDialogFragment {

    private FragmentFeelingsBinding binding;
    public static String TAG = "FeelingsBottomSheetDialogFragment";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // get the sharedViewModel with homeFragment
        HomeViewModel homeViewModel = new ViewModelProvider(requireActivity()).get(HomeViewModel.class);

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

        /**
         * actions for the feelings btns
         */
        final ImageButton depressedBtn = binding.depressedBtn;
        depressedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSheetDialogStrongFeelings("Depressed");
            }
        });
        final ImageButton hyperactiveBtn = binding.hyperactiveBtn;
        hyperactiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSheetDialogStrongFeelings("Hyperactive");
            }
        });
        final ImageButton HappyBtn = binding.happyBtn;
        HappyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSheetDialogNormalFeelings("Happy");
            }
        });
        final ImageButton sadBtn = binding.sadBtn;
        sadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSheetDialogNormalFeelings("Sad");
            }
        });
        final ImageButton neutralBtn = binding.neutralBtn;
        neutralBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSheetDialogNormalFeelings("Neutral");
            }
        });

        final ImageButton dysthymiaBtn = binding.dysthymiaBtn;
        dysthymiaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSheetDialogStrongFeelings("Dysthymia");
            }
        });
        final ImageButton energeticBtn = binding.energeticBtn;
        energeticBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSheetDialogStrongFeelings("Energetic");
            }
        });


        // close btn
        binding.btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        return root;
    }

    public void showBottomSheetDialogStrongFeelings(String feeling_description) {
        Bundle bundle = new Bundle();
        bundle.putString("feeling_description", feeling_description);
        StrongFeelingFragment strongFeelingFragment = new StrongFeelingFragment();
        strongFeelingFragment.setArguments(bundle);
        strongFeelingFragment.show(getChildFragmentManager(), strongFeelingFragment.TAG);

    }

    public void showBottomSheetDialogNormalFeelings(String feeling_description) {
        Bundle bundle = new Bundle();
        bundle.putString("feeling_description", feeling_description);
        NormalFeelingsFragment normalFeelingsFragment = new NormalFeelingsFragment();
        normalFeelingsFragment.setArguments(bundle);
        normalFeelingsFragment.show(getChildFragmentManager(), NormalFeelingsFragment.TAG);
    }


    // for the dialog size
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        BottomSheetDialog dialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        return dialog;
    }

    // for the dialog size

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        BottomSheetBehavior<View> bottomSheetBehaviour = BottomSheetBehavior.from((View) view.getParent());
        bottomSheetBehaviour.setState(BottomSheetBehavior.STATE_EXPANDED);

        RelativeLayout layout = getDialog().findViewById(R.id.navigation_feelings);
        assert layout != null;
        layout.setMinimumHeight(Resources.getSystem().getDisplayMetrics().heightPixels);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}