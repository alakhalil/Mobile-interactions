package com.example.moodtracker.models;

public class Member {
    String name;
    String email;
    int photo;

    public Member(String name, int photo) {
        this.name = name;
        this.email = email;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.name = email;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
