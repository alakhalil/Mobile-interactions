package com.example.moodtracker.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moodtracker.adapters.ReasonsListAdapter;
import com.example.moodtracker.databinding.FragmentReasonsBinding;
import com.example.moodtracker.models.Reason;
import com.example.moodtracker.viewmodels.ReasonsViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

public class ReasonsFragment extends BottomSheetDialogFragment {


    private ReasonsListAdapter listAdapter;
    private FragmentReasonsBinding binding;
    private ReasonsViewModel reasonsViewModel ;
    public static String TAG = "ReasonsDialogFragment";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentReasonsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        reasonsViewModel = new ViewModelProvider(this).get(ReasonsViewModel.class);
        reasonsViewModel.init();

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