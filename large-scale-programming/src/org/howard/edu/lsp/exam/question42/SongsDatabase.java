package org.howard.edu.lsp.exam.question42;

import java.util.*;

/**
 * A class that holds a Map with String genre as a key and a Set of Strings with songTitles
 */
public class SongsDatabase {
    private final Map<String, Set<String>> map = new HashMap<String, Set<String>>();

    /**
     * Adds a song to a genre in the database, creates a new genre if the
     * genre does not exist in the database
     * @param genre the string of the genre
     * @param songTitle the string of the song tital
     */
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

    /**
     * Gets all songs of a given genre in the database
     * @param genre the string of the genre's name
     * @return a Set of strings of that genre's songs, null if the genre isn't in the database
     */
    public Set<String> getSongs(String genre) {
        genre = genre.toLowerCase();
        return map.getOrDefault(genre, null);
    }

    /**
     * Gets the genre a song belongs to from the database
     * @param songTitle the song's title
     * @return the genre the song belongs to in the database, null if the song isn't in the database
     */
    public String getGenreOfSong(String songTitle) {
        songTitle = songTitle.toLowerCase();
        for (String genre : this.map.keySet()) {
            if (this.map.get(genre).contains(songTitle)) {
                return genre;
            }
        }
        return null;
    }

    /**
     * Converts SongsDatabase to string
     * @return the string form of the map attribute
     */
    public String toString() {
        return map.toString();
    }
}
