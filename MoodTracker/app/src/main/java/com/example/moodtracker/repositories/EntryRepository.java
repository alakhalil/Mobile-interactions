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
        int[] imageId = {R.drawable.emoticon_sad_outline, R.drawable.emoticon_happy_outline
                , R.drawable.emoticon_cry_outline, R.drawable.emoticon_outline,
                R.drawable.emoticon_neutral_outline};
        int[] attachedImageId = {0, R.drawable.img, 0, 0, 0};
        String[] feeling_description = {"Feeling sad", "Feeling happy", "Feeling depressed", "Feeling great", "Feeling okay"};
        String[] feeling_reason = {"had problems with my family", "happy with my grades", "Stressed", "Will travel tonight", "Nothing special"};
        String[] entry_time = {"8:45 pm", "9:00 am", "7:34 pm", "6:32 am", "5:76 am"};
        for (int i = 0; i < imageId.length; i++) {
            Entry entry = new Entry(feeling_description[i], feeling_reason[i], entry_time[i], attachedImageId[i], imageId[i]);
            dataset.add(entry);
        }
    }
}