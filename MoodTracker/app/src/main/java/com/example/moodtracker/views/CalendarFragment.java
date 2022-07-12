package com.example.moodtracker.views;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.moodtracker.R;
import com.example.moodtracker.databinding.FragmentCalendarBinding;
import com.example.moodtracker.viewmodels.CalendarViewModel;

import org.naishadhparmar.zcustomcalendar.CustomCalendar;
import org.naishadhparmar.zcustomcalendar.OnNavigationButtonClickedListener;
import org.naishadhparmar.zcustomcalendar.Property;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class CalendarFragment extends Fragment implements OnNavigationButtonClickedListener {

    private FragmentCalendarBinding binding;
    CustomCalendar customCalendar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("test", "on create");

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Log.d("test", "onCreateView");
        CalendarViewModel calendarViewModel =
                new ViewModelProvider(this).get(CalendarViewModel.class);
        binding = FragmentCalendarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // assign variable
        customCalendar= binding.customCalendar;

        // Initialize description hashmap
        HashMap<Object, Property> descHashMap=new HashMap<>();

        // Initialize default property
        Property defaultProperty=new Property();

        // Initialize default resource
        defaultProperty.layoutResource= R.layout.default_view;

        // Initialize and assign variable
        defaultProperty.dateTextViewResource=R.id.text_view;

        // Put object and property
        descHashMap.put("default",defaultProperty);

        // for great
        Property greatProperty=new Property();
        greatProperty.layoutResource=R.layout.calendar_great_view;
        greatProperty.dateTextViewResource=R.id.text_view;
        descHashMap.put("great",greatProperty);

        // for happy
        Property happyProperty=new Property();
        happyProperty.layoutResource=R.layout.calendar_happy_view;
        happyProperty.dateTextViewResource=R.id.text_view;
        descHashMap.put("happy",happyProperty);

        // For neutral
        Property neutralProperty =new Property();
        neutralProperty.layoutResource=R.layout.calendar_neutral_view;
        neutralProperty.dateTextViewResource=R.id.text_view;
        descHashMap.put("neutral",neutralProperty);


        // for sad
        Property sadProperty=new Property();
        sadProperty.layoutResource=R.layout.calendar_sad_view;
        sadProperty.dateTextViewResource=R.id.text_view;
        descHashMap.put("sad",happyProperty);

        // For depressed
        Property depressedProperty =new Property();
        depressedProperty.layoutResource=R.layout.calendar_depressed_view;
        depressedProperty.dateTextViewResource=R.id.text_view;
        descHashMap.put("depressed",depressedProperty);

        // set desc hashmap on custom calendar
        customCalendar.setMapDescToProp(descHashMap);

        // Initialize date hashmap
        HashMap<Integer,Object> dateHashmap=new HashMap<>();

        // initialize calendar
        Calendar calendar=  Calendar.getInstance();

        // Put values
        dateHashmap.put(1,"happy");
        dateHashmap.put(2,"depressed");
        dateHashmap.put(3,"happy");
        dateHashmap.put(4,"depressed");
        dateHashmap.put(20,"happy");
        dateHashmap.put(30,"depressed");
        dateHashmap.put(7,"sad");
        dateHashmap.put(8,"sad");
        dateHashmap.put(9,"sad");
        dateHashmap.put(26,"neutral");
        dateHashmap.put(27,"neutral");
        dateHashmap.put(28,"neutral");

        // set date
        customCalendar.setDate(calendar,dateHashmap);
        customCalendar.setOnNavigationButtonClickedListener(CustomCalendar.PREVIOUS, this);
        customCalendar.setOnNavigationButtonClickedListener(CustomCalendar.NEXT, this);
        return root;
    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public Map<Integer, Object>[] onNavigationButtonClicked(int whichButton, Calendar newMonth) {
        Map<Integer, Object>[] arr = new Map[2];
        switch(newMonth.get(Calendar.MONTH)) {
            case Calendar.JULY:
                arr[0] = new HashMap<>(); //This is the map linking a date to its description
                arr[0].put(1,"happy");
                arr[0].put(2,"depressed");
                arr[0].put(3,"happy");
                arr[0].put(4,"depressed");
                arr[0].put(20,"happy");
                arr[0].put(30,"depressed");
                arr[0].put(7,"sad");
                arr[0].put(8,"sad");
                arr[0].put(9,"sad");
                arr[0].put(26,"neutral");
                arr[0].put(27,"neutral");
                arr[0].put(28,"neutral");
                arr[1] = null; //Optional: This is the map linking a date to its tag.
                break;
            case Calendar.AUGUST:
                arr[0] = new HashMap<>(); //This is the map linking a date to its description
                arr[0].put(4,"depressed");
                arr[0].put(20,"happy");
                arr[0].put(30,"depressed");
                arr[0].put(7,"sad");
                arr[0].put(8,"sad");
                arr[1] = null; //Optional: This is the map linking a date to its tag.
                break;
            case Calendar.JUNE:
                arr[0] = new HashMap<>();
                arr[0].put(8,"sad");
                arr[0].put(9,"sad");
                arr[0].put(10,"sad");
                break;
        }
        return arr;    }
}