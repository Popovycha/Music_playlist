package model;

import java.io.FileWriter;
import java.io.IOException;

public class Playlist {
    //PLaylist creating and implementing
        private Song head;
        public HistorySongList history = new HistorySongList();
        //name is a Song
        private static class Song {
            private String name;
            private Song next;
            private Song(String artist) {
                name = artist;
                next = null;
            }
        }

        //Creation of new Song
        public Song newSong(String name) {
            return new Song(name);
        }

        //Insertion of the Song in order
        public void sortInsert(Song newSong) {
            Song current;

            //Check for head song
            if (head == null || head.name.compareToIgnoreCase(newSong.name) >= 0) {
                newSong.next = head;
                head = newSong;
            } else {
                //Finds song before insertion
                current = head;
                while (current.next != null &&
                        current.next.name.compareToIgnoreCase(newSong.name) <= 0)
                    current = current.next;

                newSong.next = current.next;
                current.next = newSong;
            }
        }

        //Listen Song
        public void listenSong() {
            Song current = head;
            if (current == null) {
                return;
            }

            //Move head pointer to next element
            Song temp = head;
            head = head.next;
            temp = temp.next;

            //Adding song to history
            history.addSong(temp.name);

        }

        //Print list in new result file
        public void writeList() throws IOException{
            FileWriter write = new FileWriter("Merged_playlist.csv");
            Song temp = head;
            while (temp != null) {
                write.write(temp.name + ";"+ System.lineSeparator());
                temp = temp.next;
            }
            write.close();
        }

}
