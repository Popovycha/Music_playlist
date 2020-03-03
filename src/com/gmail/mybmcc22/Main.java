package com.gmail.mybmcc22;
import model.Playlist;
import model.Queue;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        String[] myFiles = {"/Users/archie/Desktop/JAVA/play/sources/regional-global-weekly-2019-12-27--2020-01-03.csv",
                "/Users/archie/Desktop/JAVA/play/sources/regional-global-weekly-2020-01-17--2020-01-24.csv",
                "/Users/archie/Desktop/JAVA/play/sources/regional-global-weekly-2019-12-13--2019-12-20.csv"};

                FileWriter writer = new FileWriter("track_name_result.csv");

                ArrayList<String> Whole_Playlist = new ArrayList<>();

                for (String myFile : myFiles) {
                  model.Queue dataExtract = new Queue(myFile);
                  Whole_Playlist.addAll(dataExtract.values);
                }
                for (String str:Whole_Playlist) {
                writer.write(str + System.lineSeparator());
                }
                writer.close();


                //Playlist
                Playlist playlist = new Playlist();
                Whole_Playlist.forEach(name -> playlist.sortInsert(playlist.newSong(name)));
                playlist.writeList();
                playlist.listenSong();
                System.out.println("Last Song Played: " + playlist.history.lastListened());
                playlist.listenSong();
                System.out.println("Last Song Played: " + playlist.history.lastListened());
                playlist.listenSong();
                System.out.println("Last Song Played: " + playlist.history.lastListened());
        }
    }

