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
import com.example.moodtracker.models.Reason;
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


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        String feelingDescription = getArguments().getString("feeling_description");
        Log.d("pass data", feelingDescription) ;
        binding = FragmentNormalFeelingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        normalFeelingsViewModel = new ViewModelProvider(this).get(NormalFeelingsViewModel.class);
        normalFeelingsViewModel.init();

        setFeelingsEmojis(root,feelingDescription);
        initListView();

        normalFeelingsViewModel.getReasons().observe(getActivity(), new Observer<ArrayList<Reason>>() {
            @Override
            public void onChanged(ArrayList<Reason> reasons) {
                listAdapter.notifyDataSetChanged();
            }
        });
        normalFeelingsViewModel.getIsUpdating().observe(getActivity(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    showProgressBar();
                }
                else{
                    hideProgressBar();
                    binding.reasons.smoothScrollToPosition(normalFeelingsViewModel.getReasons().getValue().size()-1);
                }
            }
        });


        binding.reasons.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                TextView textView = (TextView) view.findViewById(R.id.reasonText);
                Log.d("Reason", textView.getText().toString());
                Log.d("Feeling", feelingDescription);
                dismiss();

            }});


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
        listAdapter = new ReasonsListAdapter(getActivity(), normalFeelingsViewModel.getReasons().getValue());
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