package org.howard.edu.lsp.exam.question42;

import org.junit.jupiter.api.*;

import java.util.*;

/**
 * JUnit5 testing of the SongsDatabase class
 */
class SongsDatabaseTest {

    Random random = new Random();
    String[] testGenres = {"rock", "pop", "rap", "jazz", "metal", "electronic"};
    String[] testSongs = {"song1", "song2", "song3", "song4", "song5", "song6", "song7", "song8",};
    SongsDatabase db = new SongsDatabase();

    /**
     * Helper function outputs the working SongsDatabase
     */
    void outputDatabase() {
        System.out.println("\nCurrent Database: " + db.toString());
    }

    /**
     * Helper function to output a genre, song pair
     * @param genre the String of the current genre
     * @param song the String of the current song
     */
    void outputSongGenre(String genre, String song) {
        System.out.println("Added" + ": " + genre + ", " + song);
    }

    /**
     * Outputs the display name of a test case.
     * @param name the display name of a test case
     */
    void outputTitle(String name) {
        System.out.println(name + '\n');
    }

    /**
     * Initializes a SongsDatabase instance before each test
     */
    @BeforeEach
    void setUp() {
        db = new SongsDatabase();
        System.out.println("====================================");
    }

    /**
     * Re-initializes a SongsDatabase instance after each test
     */
    @AfterEach
    void tearDown() {
        db = new SongsDatabase();
    }

    /**
     * Tests adding known song and known genre to the SongsDatabase
     */
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

    /**
     * Randomly generates a SongsDatabase and tests if known genre/song pairs are succesfully added
     */
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

    /**
     * Tests if adding a duplicate song within the same genre does not duplicate in the SongsDatabase
     */
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

    /**
     * Tests if trying to get songs from a genre that doesn't exist in the database returns null
     */
    @Test
    @DisplayName("Test returning null from trying to get songs from genre not in database")
    void testGetSongsNull() {
        outputTitle("Test returning null from trying to get songs from genre not in database");
        outputDatabase();
        System.out.println("Expected Genre for " + testSongs[0] + ": " + null);
        System.out.println("Actual Genre for " + testSongs[0] + ": " + db.getSongs(testSongs[0]));

        Assertions.assertNull(db.getSongs(testSongs[0]));
    }

    /**
     * Tests getting known songs from known genre in the SongsDatabase
     */
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

    /**
     * Tests getting random songs from random genre in the SongsDatabase
     */
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

        // asserts the expected songs equals the database songs
        Assertions.assertEquals(expectedSongs, db.getSongs(randomGenre));
    }

    /**
     * Tests if trying to get genre from a song that doesn't exist in the database returns null
     */
    @Test
    @DisplayName("Test returning null from trying to get genre from song not in database")
    void testGetGenreOfSongNull() {
        outputTitle("Test returning null from trying to get genre from song not in database");
        outputDatabase();
        System.out.println("Expected Genre for " + testSongs[0] + ": " + null);
        System.out.println("Actual Genre for " + testSongs[0] + ": " + db.getGenreOfSong(testSongs[0]));

        Assertions.assertNull(db.getGenreOfSong(testSongs[0]));
    }

    /**
     * Tests getting known genre from known song in the SongsDatabase
     */
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

    /**
     * Tests getting random genre from random song in the SongsDatabase
     */
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