package com.example.moodtracker.ui.home;

import android.icu.text.SimpleDateFormat;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Date;
import java.util.Locale;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> todayDate;
    private final MutableLiveData<String> FeelingQuestion;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public HomeViewModel() {
        todayDate = new MutableLiveData<>();
        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        todayDate.setValue(date);

        FeelingQuestion = new MutableLiveData<>();
        FeelingQuestion.setValue("How do you feel?");
    }

    public LiveData<String> getTodayDate() {
        return todayDate;
    }
    public LiveData<String> getFeelingQuestion() {
        return FeelingQuestion;
    }
}