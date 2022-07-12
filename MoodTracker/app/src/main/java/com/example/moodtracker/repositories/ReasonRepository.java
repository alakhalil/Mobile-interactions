package com.example.moodtracker.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.moodtracker.R;
import com.example.moodtracker.models.Reason;

import java.util.ArrayList;
import java.util.Arrays;

public class ReasonRepository {
    private static ReasonRepository instance;
    private ArrayList<Reason> dataset ;

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
        int[] images_ids = {R.drawable.hospital, R.drawable.account_multiple
                , R.drawable.bed, R.drawable.briefcase,
                R.drawable.school, R.drawable.food_apple};
        String[] reasons_titles = {"Health", "Social", "Sleep", "Work", "Education", "Food"};
        String [] sub_reasons = {"Family", "Partner","Children", "Relatives", "Friends", "Others"};
        dataset = new ArrayList<>();
        for (int i = 0; i < reasons_titles.length; i++) {
            Reason reason = new Reason(reasons_titles[i], Arrays.asList(sub_reasons), images_ids[i]);
            dataset.add(reason);
        }
    }

}
