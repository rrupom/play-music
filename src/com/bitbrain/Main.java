package com.bitbrain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {

        Album album = new Album("Album1", "AC/DC");
        album.addSong("TNT", 4.5);
        album.addSong("Highway to Hell", 3.5);
        album.addSong("ThunderStruck", 5.0);
        albums.add(album);

        album = new Album("Album2", "Eminem");
        album.addSong("Rap God", 4.5);
        album.addSong("Not Afraid", 3.5);
        album.addSong("Lose Yourself", 4.5);
        albums.add(album);

        LinkedList<Song> playlist1 = new LinkedList<>();
        albums.get(0).addToPlaylist("TNT", playlist1);
        albums.get(0).addToPlaylist("Highway to Hell", playlist1);
        albums.get(1).addToPlaylist("Rap Gop", playlist1);
        albums.get(1).addToPlaylist("Lose Yourself", playlist1);

        // printMenu();

        play(playlist1);

        // printList(playlist1);
    }

    private static void play(LinkedList<Song> playList) {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;

        ListIterator<Song> iterator = playList.listIterator();

        if (playList.size() == 0) {
            System.out.println("This playlist have no song");
        } else {
            System.out.println("Now playing " + iterator.next().toString());
            printMenu();
        }

        while (!quit) {
            int action = sc.nextInt();
            sc.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (iterator.hasNext()) {
                            iterator.next();
                        }
                        forward = true;
                    }
                    if (iterator.hasNext()) {
                        System.out.println("Now playing " + iterator.next().toString());
                    } else {
                        System.out.println("No song available. Reached to the end of the list");
                        forward = false;
                    }

                    break;

                case 2:
                    if (forward) {
                        if (iterator.hasPrevious()) {
                            iterator.previous();
                        }

                        forward = false;
                    }

                    if (iterator.hasPrevious()) {
                        System.out.println("Now playing " + iterator.previous().toString());
                    } else {
                        System.out.println("We are at the first song");
                        forward = false;
                    }

                    break;
                case 3:
                    if (forward) {
                        if (iterator.hasPrevious()) {
                            System.out.println("Now playing " + iterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                    } else {
                        if (iterator.hasNext()) {
                            System.out.println("Now playing " + iterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We are at the end of the list");
                        }
                    }
                    break;

                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size() > 0) {
                        iterator.remove();
                        if (iterator.hasNext()) {
                            System.out.println("Now playing " + iterator.next().toString());
                        } else {
                            if (iterator.hasPrevious()) {
                                System.out.println("Now playing " + iterator.previous().toString());
                            }
                        }
                    }
            }
        }

        sc.close();
    }

    private static void printMenu() {
        System.out.println("Available Options:");
        System.out.println("0 - to quit");
        System.out.println("1 - to play next song");
        System.out.println("2 - to play previous song");
        System.out.println("3 - to replay the current song");
        System.out.println("4 - list of all songs");
        System.out.println("5 - print all available options");
        System.out.println("6 - delete current song from playlist");
    }

    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("-------------");

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("--------------");

    }
}

