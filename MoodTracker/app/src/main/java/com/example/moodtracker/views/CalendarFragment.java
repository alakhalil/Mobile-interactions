package com.example.moodtracker.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.moodtracker.R;
import com.example.moodtracker.databinding.FragmentCalendarBinding;
import com.example.moodtracker.viewmodels.CalendarViewModel;

import org.naishadhparmar.zcustomcalendar.CustomCalendar;
import org.naishadhparmar.zcustomcalendar.Property;

import java.util.Calendar;
import java.util.HashMap;

public class CalendarFragment extends Fragment {

    private FragmentCalendarBinding binding;
    CustomCalendar customCalendar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
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

        // for current date
        Property currentProperty=new Property();
        currentProperty.layoutResource=R.layout.calendar_great_view;
        currentProperty.dateTextViewResource=R.id.text_view;
        descHashMap.put("current",currentProperty);

        // for present date
        Property presentProperty=new Property();
        presentProperty.layoutResource=R.layout.calendar_happy_view;
        presentProperty.dateTextViewResource=R.id.text_view;
        descHashMap.put("present",presentProperty);

        // For absent
        Property absentProperty =new Property();
        absentProperty.layoutResource=R.layout.calendar_depressed_view;
        absentProperty.dateTextViewResource=R.id.text_view;
        descHashMap.put("absent",absentProperty);

        // set desc hashmap on custom calendar
        customCalendar.setMapDescToProp(descHashMap);

        // Initialize date hashmap
        HashMap<Integer,Object> dateHashmap=new HashMap<>();

        // initialize calendar
        Calendar calendar=  Calendar.getInstance();

        // Put values
        dateHashmap.put(1,"present");
        dateHashmap.put(2,"absent");
        dateHashmap.put(3,"present");
        dateHashmap.put(4,"absent");
        dateHashmap.put(20,"present");
        dateHashmap.put(30,"absent");

        // set date
        customCalendar.setDate(calendar,dateHashmap);

        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}