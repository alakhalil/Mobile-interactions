package com.example.moodtracker.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Entry {
    public String feeling_description, feeling_reason, entry_time;
    public  int attached_image_id, feeling_emoji_id;


    public Entry(String feeling_description, String feeling_reason, int attached_image_id, int feeling_emoji_id) {
        this.feeling_description = feeling_description;
        this.feeling_reason = feeling_reason;
        this.entry_time = getDate();
        this.attached_image_id = attached_image_id;
        this.feeling_emoji_id = feeling_emoji_id;
    }

    private String getDate(){
        Date now = new Date();
        String date = new SimpleDateFormat("HH:mm",
                Locale.ENGLISH).format(now);
        return date;
    }

}