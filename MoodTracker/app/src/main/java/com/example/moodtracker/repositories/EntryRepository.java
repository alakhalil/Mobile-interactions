package com.example.moodtracker.repositories;

;

import androidx.lifecycle.MutableLiveData;

import com.example.moodtracker.R;
import com.example.moodtracker.models.Entry;

import java.util.ArrayList;

public class EntryRepository {
    private static EntryRepository instance;
    private ArrayList<Entry> dataset = new ArrayList<>();

    public static EntryRepository getInstance(){
        if(instance== null){
            instance=new EntryRepository();
        }
        return instance;
    }
    // simulate the webservice later
    public MutableLiveData<ArrayList<Entry>> getEntries() {
        setEntries();
        MutableLiveData<ArrayList<Entry>> data = new MutableLiveData<>();
        data.setValue(dataset);
        return data;
    }

    private void setEntries() {
        int[] imageId = {R.drawable.emoticon_sad_btn, R.drawable.emoticon_happy_btn
                , R.drawable.emoticon_depressed_btn, R.drawable.emoticon_hyperactive_btn,
                R.drawable.emoticon_neutral_btn};
        int[] attachedImageId = {0, R.drawable.entry_img, 0, 0, 0};
        String[] feeling_description = {"Feeling sad", "Feeling happy", "Feeling depressed", "Feeling hyperactive", "Feeling neutral"};
        String[] feeling_reason = {"had problems with my family", "happy with my grades", "Stressed", "Will travel tonight", "Nothing special"};
        for (int i = 0; i < imageId.length; i++) {
            Entry entry = new Entry(feeling_description[i], feeling_reason[i], attachedImageId[i], imageId[i]);
            dataset.add(entry);
        }
    }
}
