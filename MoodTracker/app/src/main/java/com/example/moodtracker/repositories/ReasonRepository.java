package com.example.moodtracker.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.moodtracker.R;
import com.example.moodtracker.models.Reason;

import java.util.ArrayList;
import java.util.Arrays;

public class ReasonRepository {
    private static ReasonRepository instance;
    private ArrayList<Reason> dataset = new ArrayList<>();

    public static ReasonRepository getInstance(){
        if(instance== null){
            instance=new ReasonRepository();
        }
        return instance;
    }
    // simulate the webservice later
    public MutableLiveData<ArrayList<Reason>> getReasons() {
        setReasons();
        MutableLiveData<ArrayList<Reason>> data = new MutableLiveData<>();
        data.setValue(dataset);
        return data;
    }

    private void setReasons() {
        int[] images_ids = {R.drawable.emoticon_sad_outline, R.drawable.emoticon_happy_outline
                , R.drawable.emoticon_cry_outline, R.drawable.emoticon_outline,
                R.drawable.emoticon_neutral_outline, R.drawable.emoticon_outline,
                R.drawable.emoticon_neutral_outline};
        String[] reasons_titles = {"Health", "Social", "Sleep", "Work", "Education", "Productivity", "Me time"};
        String [] sub_reasons = {"Family", "Partner","Children", "Relatives", "Friends", "Others"};
        for (int i = 0; i < reasons_titles.length; i++) {
            Reason reason = new Reason(reasons_titles[i], Arrays.asList(sub_reasons), images_ids[i]);
            dataset.add(reason);
        }
    }

}
