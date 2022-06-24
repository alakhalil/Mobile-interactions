package com.example.moodtracker.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.moodtracker.R;
import com.example.moodtracker.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        int[] imageId = {R.drawable.emoticon_sad_outline,R.drawable.emoticon_sad_outline,R.drawable.emoticon_sad_outline,R.drawable.emoticon_sad_outline,R.drawable.emoticon_sad_outline,
                R.drawable.emoticon_sad_outline,R.drawable.emoticon_sad_outline,R.drawable.emoticon_sad_outline,R.drawable.emoticon_sad_outline};


        String[] feeling_description = {"Feeling sad","Feeling happy", "Feeling happy", "Feeling sad", "Feeling happy", "Feeling depressed","Feeling depressed","Feeling depressed","Feeling depressed"};

        String[] feeling_reason = {"had problems with my family","Supp","Let's Catchup","Dinner tonight?","Gotta go", "i'm in meeting","Gotcha","Let's Go","any Weekend Plans?"};

        String[] entry_time = {"8:45 pm","9:00 am","7:34 pm","6:32 am","5:76 am", "5:00 am","7:34 pm","2:32 am","7:76 am"};

        ArrayList<Entry> entryArrayList = new ArrayList<>();

        for(int i = 0;i< imageId.length;i++){

            Entry entry = new Entry(feeling_description[i],feeling_reason[i],entry_time[i],imageId[i], imageId[i]);
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
}