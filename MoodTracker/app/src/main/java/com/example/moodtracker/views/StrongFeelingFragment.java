package com.example.moodtracker.views;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.moodtracker.R;
import com.example.moodtracker.databinding.FragmentStrongFeelingsBinding;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class StrongFeelingFragment extends BottomSheetDialogFragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static String TAG = "ReasonsDialogFragment";
    private FragmentStrongFeelingsBinding binding;


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

        LinearLayout layout = getDialog().findViewById(R.id.strong_feeling_layout);
        assert layout!=null;
        layout.setMinimumHeight(Resources.getSystem().getDisplayMetrics().heightPixels);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String feelingDescription = getArguments().getString("feeling_description");
        Log.d("pass data", feelingDescription) ;
        // Inflate the layout for this fragment
        binding = FragmentStrongFeelingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ImageView image = (ImageView)root.findViewById(R.id.strong_feeling_icon);
        setFeelingsEmojis(image,feelingDescription);

        return root;
    }


    private void setFeelingsEmojis(ImageView image, String feeling_description) {
        if(feeling_description== "Great")
            image.setImageResource(R.drawable.emoticon_great_btn);
        else if (feeling_description== "Depressed")
            image.setImageResource(R.drawable.emoticon_cry_btn);
    }

}