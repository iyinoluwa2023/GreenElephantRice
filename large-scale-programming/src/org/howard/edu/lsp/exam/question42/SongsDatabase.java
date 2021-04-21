package org.howard.edu.lsp.exam.question42;

import java.util.*;

public class SongsDatabase {
    private final Map<String, Set<String>> map = new HashMap<String, Set<String>>();

    public void addSong(String genre, String songTitle) {
        genre = genre.toLowerCase();
        songTitle = songTitle.toLowerCase();
        if (this.map.containsKey(genre)) {
            this.map.get(genre).add(songTitle);
        }
        else {
            Set<String> newSong = new HashSet<String>();
            newSong.add(songTitle);
            this.map.put(genre, newSong);
        }
    }

    public Set<String> getSongs(String genre) {
        genre = genre.toLowerCase();
        return map.getOrDefault(genre, null);
    }

    public String getGenreOfSong(String songTitle) {
        songTitle = songTitle.toLowerCase();
        for (String genre : this.map.keySet()) {
            if (this.map.get(genre).contains(songTitle)) {
                return genre;
            }
        }
        return null;
    }

    public String toString() {
        return map.toString();
    }

    public boolean contains(String genre) {
        return map.containsKey(genre);
    }

    public static void main(String[] args) {

    }
}
