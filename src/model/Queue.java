package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Queue {
    // Store one csv chart into queue
    public List<String> values = new ArrayList<>();

        public Queue(String filename) {
            BufferedReader br = null;
            String line = "";


            try {
                br = new BufferedReader(new FileReader(filename));
                while ((line = br.readLine()) != null) {
                    //program use comma as separator
                    String[] newSong = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);


                    if (newSong[1].replace("\"", "").trim().equals("")) {
                    } else if (newSong[1].replace("\"", "").trim().equals("")) {
                        values.add("");
                    } else if (newSong[1].replace("\"", "").trim().equals("")) {
                        values.add("");
                    } else if (!newSong[1].replace("\"", "").trim().equals("")) {
                        values.add(newSong[1].replace("\"", "").trim());
                    }
                }
            } catch (IOException error) {
                error.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException error) {
                        error.printStackTrace();
                    }
                }
            }
        }
}

