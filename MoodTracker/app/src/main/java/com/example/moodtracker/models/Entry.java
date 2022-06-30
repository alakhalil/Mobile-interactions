package com.example.moodtracker.models;

public class Entry {
    public String feeling_description, feeling_reason, entry_time;
    public  int attached_image_id, feeling_emoji_id;


    public Entry(String feeling_description, String feeling_reason, String entry_time, int attached_image_id, int feeling_emoji_id) {
        this.feeling_description = feeling_description;
        this.feeling_reason = feeling_reason;
        this.entry_time = entry_time;
        this.attached_image_id = attached_image_id;
        this.feeling_emoji_id = feeling_emoji_id;
    }
}