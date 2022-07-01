package com.example.moodtracker.viewmodels;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.moodtracker.models.Reason;
import com.example.moodtracker.repositories.ReasonRepository;

import java.util.ArrayList;

public class ReasonsViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Reason>> reasons;
    private ReasonRepository reasonsRepo ;
    private MutableLiveData<Boolean> reasonsIsUpdating = new MutableLiveData<>();
    public void init() {
        if(reasons!=null)
            return;
        reasonsRepo = ReasonRepository.getInstance();
        reasons = reasonsRepo.getReasons();
    }
    public void addNewValue(final Reason newReason){
        reasonsIsUpdating.setValue(true);
        // simulating DB later
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                ArrayList<Reason> currentEntries = reasons.getValue();
                currentEntries.add(newReason);
                reasons.postValue(currentEntries);
                reasonsIsUpdating.setValue(false);
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
    public LiveData<ArrayList<Reason>> getReasons(){
        return reasons;
    }
    public LiveData<Boolean> getIsUpdating (){
        return reasonsIsUpdating;
    }

}