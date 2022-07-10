package com.example.moodtracker.views;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moodtracker.R;
import com.example.moodtracker.adapters.ReasonsListAdapter;
import com.example.moodtracker.databinding.FragmentNormalFeelingsBinding;
import com.example.moodtracker.models.Entry;
import com.example.moodtracker.models.Reason;
import com.example.moodtracker.viewmodels.HomeViewModel;
import com.example.moodtracker.viewmodels.NormalFeelingsViewModel;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

public class NormalFeelingsFragment extends BottomSheetDialogFragment {

    private ReasonsListAdapter listAdapter;
    private FragmentNormalFeelingsBinding binding;
    private NormalFeelingsViewModel normalFeelingsViewModel;
    public static String TAG = "ReasonsDialogFragment";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        String feelingDescription = getArguments().getString("feeling_description");
        binding = FragmentNormalFeelingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        normalFeelingsViewModel = new ViewModelProvider(this).get(NormalFeelingsViewModel.class);
        normalFeelingsViewModel.init();

        // get the sharedViewModel with homeFragment
        HomeViewModel homeViewModel = new ViewModelProvider(requireActivity()).get(HomeViewModel.class);

        int feelingsIcon = setFeelingsEmojis(root,feelingDescription);
        initListView();

        normalFeelingsViewModel.getReasons().observe(getActivity(), new Observer<ArrayList<Reason>>() {
            @Override
            public void onChanged(ArrayList<Reason> reasons) {
                listAdapter.notifyDataSetChanged();
            }
        });


        binding.reasons.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view.findViewById(R.id.reasonText);
                Log.d("Reason", textView.getText().toString());
                Log.d("Feeling", feelingDescription);
                dismiss();

                homeViewModel.addNewValue(new Entry(
                        feelingDescription,
                        textView.getText().toString(),
                        0,
                        feelingsIcon));
            }});
        return root;
    }

    private int setFeelingsEmojis(View root, String feelingDescription) {
        ImageView image = (ImageView)root.findViewById(R.id.normal_feeling_icon);
        if(feelingDescription== "Happy"){
            image.setImageResource(R.drawable.emoticon_happy_btn);
            return  R.drawable.emoticon_happy_btn;
        }
        else if (feelingDescription== "Sad") {
            image.setImageResource(R.drawable.emoticon_sad_btn);
            return  R.drawable.emoticon_sad_btn;

        }
        else if (feelingDescription== "Okay") {
            image.setImageResource(R.drawable.emoticon_neutral_btn);
            return  R.drawable.emoticon_neutral_btn;
        }
        return 0;
    }

    private void initListView() {
        listAdapter = new ReasonsListAdapter(getActivity(), normalFeelingsViewModel.getReasons().getValue());
        binding.reasons.setAdapter(listAdapter);
    }


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
        RelativeLayout layout = getDialog().findViewById(R.id.normal_feelings_layout);
        assert layout!=null;
        layout.setMinimumHeight(Resources.getSystem().getDisplayMetrics().heightPixels);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}