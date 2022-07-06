package com.example.moodtracker.views;

import android.os.Bundle;

import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moodtracker.R;
import com.example.moodtracker.databinding.FragmentPage7Binding;
import com.example.moodtracker.databinding.FragmentPage8Binding;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;


public class Page8Fragment extends Fragment {

    private FragmentPage8Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentPage8Binding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialDatePicker.Builder<Pair<Long, Long>> materialDateBuilder = MaterialDatePicker.Builder.dateRangePicker();
                materialDateBuilder.setTitleText("SELECT A DATE");

                MaterialDatePicker materialDatePicker = materialDateBuilder.build();

                materialDatePicker.show(getActivity().getSupportFragmentManager(), "MATERIAL_DATE_PICKER");

                materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
                    @Override
                    public void onPositiveButtonClick(Object selection) {
                        binding.button1.setText("" + materialDatePicker.getHeaderText());
                    }

                });
            }
        });

        binding.button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_page8Fragment_to_page9Fragment);
            }
        });


        return root;
    }
}