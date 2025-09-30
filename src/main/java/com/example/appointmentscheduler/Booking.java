package com.example.appointmentscheduler;

public class Booking {
    private int dayofWeek;
    private int startTime;
    private int endTime;
    private String name;


    public Booking(int dayofWeek, int startTime, int endTime, String name) {
        this.dayofWeek = dayofWeek;
        this.startTime = startTime;
        this.endTime = endTime;
        this.name = name;
    }

    public int getDayofWeek() {
        return dayofWeek;
    }

    public void setDayofWeek(int dayofWeek) {
        this.dayofWeek = dayofWeek;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
