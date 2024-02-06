package com.bitbrain;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String albumName;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.albumName = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public Album() {
    }

    public boolean addSong(String name, double duration) {
        if (findSong(name) == null) {
            this.songs.add(new Song(name, duration));
            // System.out.println("Successfully added the song");
            return true;
        } else {
            // System.out.println("Song already exists");
            return false;
        }
    }

    public Song findSong(String name) {
        if (songs.isEmpty()) {
            return null;
        }
        for (Song song : this.songs) {
            if (song.getName() == name) {
                return song;
            }
        }

        return null;
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playList) {
        int index = trackNumber - 1;
        if (index < 0 && index <= this.songs.size()) {
            playList.add(this.songs.get(index));
            return true;
        }

        // System.out.println("This album does not have song with tracknumber " +
        // trackNumber);
        return false;
    }

    public boolean addToPlaylist(String title, LinkedList<Song> playList) {
        for (Song song : this.songs) {
            if (song.getName() == title) {
                playList.add(song);
                return true;
            }
        }
        return false;
    }

    public String getAlbumName() {
        return this.albumName;
    }

    public String getArtist() {
        return this.artist;
    }

}
