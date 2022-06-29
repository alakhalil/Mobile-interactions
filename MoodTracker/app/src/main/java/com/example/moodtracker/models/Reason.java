package com.example.moodtracker.models;

import java.util.List;

public class Reason {
    public String reason;
    public List<String> subReasons;
    public int iconId;

    public Reason(String reason, List<String> subReasons, int iconId) {
        this.reason = reason;
        this.subReasons = subReasons;
        this.iconId = iconId;
    }

}
