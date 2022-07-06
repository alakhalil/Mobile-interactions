package com.example.moodtracker.views;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
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

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class FeelingsFragment extends BottomSheetDialogFragment {

    private FragmentFeelingsBinding binding;
    public static String TAG = "FeelingsBottomSheetDialogFragment";


    // for the dialog size
    @NonNull
    @Override
     public Dialog onCreateDialog(Bundle savedInstanceState){
         BottomSheetDialog dialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
         return dialog;
     }

    // for the dialog size

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        BottomSheetBehavior<View> bottomSheetBehaviour = BottomSheetBehavior.from((View) view.getParent());
        bottomSheetBehaviour.setState(BottomSheetBehavior.STATE_EXPANDED);

        RelativeLayout layout = getDialog().findViewById(R.id.feelings_layout);
        assert layout!=null;
        layout.setMinimumHeight(Resources.getSystem().getDisplayMetrics().heightPixels);
    }

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
        new ReasonsFragment().show(getChildFragmentManager(), ReasonsFragment.TAG);
        onDestroy();

    }



}