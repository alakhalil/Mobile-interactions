package com.example.moodtracker.ui.home;


import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.moodtracker.R;
import com.example.moodtracker.databinding.FragmentHomeBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // To open the dialog
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                showBottomSheetDialog();
            }
        });


        //TODO clean up

        int[] imageId = {R.drawable.emoticon_sad_outline, R.drawable.emoticon_happy_outline
                , R.drawable.emoticon_cry_outline, R.drawable.emoticon_outline,
                R.drawable.emoticon_neutral_outline};
        int[] attachedImageId = {0, R.drawable.img, 0, 0, 0};
        String[] feeling_description = {"Feeling sad", "Feeling happy", "Feeling depressed", "Feeling great", "Feeling okay"};
        String[] feeling_reason = {"had problems with my family", "happy with my grades", "Stressed", "Will travel tonight", "Nothing special"};
        String[] entry_time = {"8:45 pm", "9:00 am", "7:34 pm", "6:32 am", "5:76 am"};
        ArrayList<Entry> entryArrayList = new ArrayList<>();
        for (int i = 0; i < imageId.length; i++) {
            Entry entry = new Entry(feeling_description[i], feeling_reason[i], entry_time[i], attachedImageId[i], imageId[i]);
            entryArrayList.add(entry);
        }
        ListAdapter listAdapter = new ListAdapter(getActivity(), entryArrayList);
        binding.entries.setAdapter(listAdapter);


        return root;
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
            }
        });

        final ImageButton HappyBtn = bottomSheetDialog.findViewById(R.id.happy_btn);
        HappyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSheetDialogNormalFeelings();
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