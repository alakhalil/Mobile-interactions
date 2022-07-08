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
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.moodtracker.R;
import com.example.moodtracker.adapters.ReasonsListAdapter;
import com.example.moodtracker.databinding.FragmentReasonsBinding;
import com.example.moodtracker.models.Reason;
import com.example.moodtracker.viewmodels.ReasonsViewModel;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

public class ReasonsFragment extends BottomSheetDialogFragment {


    private ReasonsListAdapter listAdapter;
    private FragmentReasonsBinding binding;
    private ReasonsViewModel reasonsViewModel ;
    public static String TAG = "ReasonsDialogFragment";


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

        RelativeLayout layout = getDialog().findViewById(R.id.reasons_layout);
        assert layout!=null;
        layout.setMinimumHeight(Resources.getSystem().getDisplayMetrics().heightPixels);
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        String feelingDescription = getArguments().getString("feeling_description");
        Log.d("pass data", feelingDescription) ;
        binding = FragmentReasonsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        reasonsViewModel = new ViewModelProvider(this).get(ReasonsViewModel.class);
        reasonsViewModel.init();

        setFeelingsEmojis(root,feelingDescription);
        initListView();

        reasonsViewModel.getReasons().observe(getActivity(), new Observer<ArrayList<Reason>>() {
            @Override
            public void onChanged(ArrayList<Reason> reasons) {
                listAdapter.notifyDataSetChanged();
            }
        });
        reasonsViewModel.getIsUpdating().observe(getActivity(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    showProgressBar();
                }
                else{
                    hideProgressBar();
                    binding.reasons.smoothScrollToPosition(reasonsViewModel.getReasons().getValue().size()-1);
                }
            }
        });



        // To open the dialog
/*        binding.fab.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                showBottomSheetDialog();

                //TODO: move this function to the viewModel of feelingsFragment
                reasonsViewModel.addNewValue(new Reason("feeling sad", "No idea what I am doing", "10:30", 0, R.drawable.emoticon_sad_outline));
            }
        });*/

        return root;
    }

    private void setFeelingsEmojis(View root, String feelingDescription) {
        ImageView image = (ImageView)root.findViewById(R.id.normal_feeling_icon);
        if(feelingDescription== "Happy")
            image.setImageResource(R.drawable.emoticon_happy_btn);
        else if (feelingDescription== "Sad")
            image.setImageResource(R.drawable.emoticon_sad_btn);
        else if (feelingDescription== "Okay")
            image.setImageResource(R.drawable.emoticon_neutral_btn);
    }

    private void initListView() {
        listAdapter = new ReasonsListAdapter(getActivity(), reasonsViewModel.getReasons().getValue());
        binding.reasons.setAdapter(listAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void showProgressBar(){
        binding.progressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        binding.progressBar.setVisibility(View.GONE);
    }

}