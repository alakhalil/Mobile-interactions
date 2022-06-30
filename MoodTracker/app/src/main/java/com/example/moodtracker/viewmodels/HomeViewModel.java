package com.example.moodtracker.viewmodels;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.moodtracker.models.Entry;
import com.example.moodtracker.repositories.EntryRepository;

import java.util.ArrayList;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Entry>> entries;
    private EntryRepository entriesRepo ;
    private MutableLiveData<Boolean> entriesIsUpdating = new MutableLiveData<>();
    public void init() {
        if(entries!=null)
            return;
        entriesRepo = EntryRepository.getInstance();
        entries = entriesRepo.getEntries();
    }
    public void addNewValue(final Entry newEntry){
        entriesIsUpdating.setValue(true);
        // simulating DB later
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                ArrayList<Entry> currentEntries = entries.getValue();
                currentEntries.add(newEntry);
                entries.postValue(currentEntries);
                entriesIsUpdating.setValue(false);
            }

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }
    public LiveData<ArrayList<Entry>> getEntries(){
        return entries;
    }
    public LiveData<Boolean> getIsUpdating (){
        return entriesIsUpdating;
    }

}