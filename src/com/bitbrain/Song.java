package com.bitbrain;

public class Song {
    private String name;
    private double duration;

    public Song(String name, double duration) {
        this.name = name;
        this.duration = duration;
    }

    public Song() {

    }

    public String getName() {
        return this.name;
    }

    public double getDuration() {
        return this.duration;
    }

    @Override
    public String toString() {
        return "Song [ " + "name=" + name + " , " + "duration=" + duration + " ]";
    }
}
