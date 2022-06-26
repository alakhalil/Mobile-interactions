package com.example.moodtracker.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.moodtracker.models.Entry;
import com.example.moodtracker.repositories.EntryRepository;

import java.util.ArrayList;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Entry>> entries;
    private EntryRepository entriesRepo ;
    public void init() {
        if(entries!=null)
            return;
        entriesRepo = EntryRepository.getInstance();
        entries = entriesRepo.getEntries();
    }
    public void addNewValue(final Entry entry){
        // LAter do the ad
    }
    public LiveData<ArrayList<Entry>> getEntries(){
        return entries;
    }

}