package org.howard.edu.lsp.exam.question42;

import org.junit.jupiter.api.*;

import java.util.*;

class SongsDatabaseTest {

    Random random = new Random();
    String[] testGenres = {"rock", "pop", "rap", "jazz", "metal", "electronic"};
    String[] testSongs = {"song1", "song2", "song3", "song4", "song5", "song6", "song7", "song8",};
    SongsDatabase db = new SongsDatabase();

    void outputDatabase() {
        System.out.println("\nCurrent Database: " + db.toString());
    }

    void outputSongGenre(String genre, String song) {
        System.out.println("Added" + ": " + genre + ", " + song);
    }

    void outputTitle(String tag) {
        System.out.println(tag + '\n');
    }

    @BeforeEach
    void setUp() {
        db = new SongsDatabase();
        System.out.println("====================================");
    }

    @Test
    @DisplayName("Test adding song to database with controlled genre and song")
    void testAddSongControl() {
        outputTitle("Test adding song to database with controlled genre and song");

        outputDatabase();
        db.addSong(testGenres[0], testSongs[0]);
        outputSongGenre(testGenres[0], testSongs[0]);
        outputDatabase();

        Assertions.assertEquals(db.toString(), "{rock=[song1]}");
    }

    @RepeatedTest(5)
    @DisplayName("Test adding song to database with random genres and song")
    void testAddSongRandom() {
        outputTitle("Test adding song to database with controlled genre and song");

        // gets random genres and random songs and places them in the database
        ArrayList<String> randomSongs = new ArrayList<>();
        ArrayList<String> randomGenres = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            randomSongs.add(testSongs[random.nextInt(testSongs.length)]);
            randomGenres.add(testGenres[random.nextInt(testGenres.length)]);
        }
        for (int i = 0; i < 5; i++) {
            db.addSong(randomGenres.get(i), randomSongs.get(i));
            outputSongGenre(randomGenres.get(i), randomSongs.get(i));
        }
        outputDatabase();

        // asserts that each song is found in the database and getGenreOfSong has a value that exists
        for (String song : randomSongs) {
            Assertions.assertNotEquals(db.getGenreOfSong(song), null);
        }
    }

    @Test
    @DisplayName("Test adding duplicate song to database")
    void testAddSongDuplicate() {
        outputTitle("Test adding duplicate song to database");

        db.addSong(testGenres[0], testSongs[0]);
        outputSongGenre(testGenres[0], testSongs[0]);
        db.addSong(testGenres[0], testSongs[0]);
        outputSongGenre(testGenres[0], testSongs[0]);
        outputDatabase();

        Assertions.assertEquals(db.toString(), "{rock=[song1]}");
    }

    @Test
    @DisplayName("Test getting known songs from control genre")
    void testGetSongsControl() {
        outputTitle("Test getting known songs from control genre");

        db.addSong(testGenres[0], testSongs[0]);
        outputSongGenre(testGenres[0], testSongs[0]);
        outputDatabase();
        System.out.println("Expected Song for " + testGenres[0] + ": [" + testSongs[0] + ']');
        System.out.println("Actual Genre for " + testGenres[0] + ": " + db.getSongs(testGenres[0]));

        Assertions.assertEquals("[song1]", db.getSongs(testGenres[0]).toString());
    }

    @RepeatedTest(5)
    @DisplayName("Test getting known songs from random genre")
    void testGetSongsRandom() {
        outputTitle("Test getting known genre from random song");

        // gets random genres and random songs and places them in the database
        ArrayList<String> randomSongs = new ArrayList<>();
        ArrayList<String> randomGenres = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            randomSongs.add(testSongs[random.nextInt(testSongs.length)]);
            randomGenres.add(testGenres[random.nextInt(testGenres.length)]);
        }
        Set<String> expectedSongs = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            db.addSong(randomGenres.get(i), randomSongs.get(i));
            outputSongGenre(randomGenres.get(i), randomSongs.get(i));
        }
        outputDatabase();

        int randIndex = random.nextInt(randomGenres.size());
        String randomGenre = randomGenres.get(randIndex);

        // generates set of all expected songs
        for (int i = 0; i < 5; i++) {
            if (randomGenres.get(i).equals(randomGenre)) {
                expectedSongs.add(randomSongs.get(i));
            }
        }
        System.out.println("Expected Songs for " + randomGenre + ": " + expectedSongs.toString());
        System.out.println("Actual Songs for " + randomGenre + ": " + db.getSongs(randomGenre).toString());

        Assertions.assertEquals(expectedSongs, db.getSongs(randomGenre));
    }

    @Test
    @DisplayName("Test getting known genre from control song")
    void testGetGenreOfSongControl() {
        outputTitle("Test getting known genre from control song");

        db.addSong(testGenres[0], testSongs[0]);
        outputSongGenre(testGenres[0], testSongs[0]);
        outputDatabase();
        System.out.println("Expected Genre for " + testSongs[0] + ": " + testGenres[0]);
        System.out.println("Actual Genre for " + testSongs[0] + ": " + db.getGenreOfSong(testSongs[0]));

        Assertions.assertEquals("rock", db.getGenreOfSong(testSongs[0]).toString());
    }

    @RepeatedTest(5)
    @DisplayName("Test getting known genre from random song")
    void testGetGenreOfSongRandom() {
        outputTitle("Test getting known genre from random song");

        // uses LinkedHashSet to get random songs and genres to prevent duplication for testing
        Set<String> rSongs = new LinkedHashSet<>(), rGenres = new LinkedHashSet<>();
        while (rSongs.size() != 5) { rSongs.add(testSongs[random.nextInt(testSongs.length)]); }
        while (rGenres.size() != 5) { rGenres.add(testGenres[random.nextInt(testGenres.length)]); }

        // gets random genres and random songs and places them in the database
        String[] randomSongs = new String[5], randomGenres = new String[5];
        randomSongs = rSongs.toArray(randomSongs); randomGenres = rGenres.toArray(randomGenres);
        for (int i = 0; i < 5; i++) {
            db.addSong(randomGenres[i], randomSongs[i]);
            outputSongGenre(randomGenres[i], randomSongs[i]);
        }
        outputDatabase();

        // random index should get the correct genre song pair
        int randIndex = random.nextInt(5);
        System.out.println("Expected Genre for " + randomSongs[randIndex] + ": " + randomGenres[randIndex]);
        System.out.println("Actual Genre for " + randomSongs[randIndex] + ": " + db.getGenreOfSong(randomSongs[randIndex]));

        // assert the expected genre is the actual genre
        Assertions.assertEquals(randomGenres[randIndex], db.getGenreOfSong(randomSongs[randIndex]));
    }

}