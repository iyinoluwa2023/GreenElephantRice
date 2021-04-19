package org.howard.edu.lsp.assignment7.junit;

import org.howard.edu.lsp.assignment7.tollbooth.*;
import org.junit.jupiter.api.*;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class AlleghenyTollBoothTest {

    Random rand = new Random();
    TollBooth a = new AlleghenyTollBooth();

    int randInRange(int boundLow, int boundHigh) {
        return rand.nextInt(boundHigh - boundLow) + boundLow;
    }

    void outputTest(String testName) {
        StringBuilder SEPARATOR = new StringBuilder();
        SEPARATOR.append("=".repeat(15));
        System.out.println(SEPARATOR + " " + testName + " " + SEPARATOR + '\n');
    }

    void outputTruck(Truck t) {
        System.out.println("Axles: " + String.valueOf(t.getAxles()) + '\n'
                + "Weight: " + String.valueOf(t.getWeight()) + '\n');
    }

    void outputAmount(String tag, int amount) {
        System.out.println(tag + ": " + "$" + String.valueOf(amount));
    }

    @BeforeEach
    void setUp() {
        TollBooth a = new AlleghenyTollBooth();
    }

    @AfterEach
    void tearDown() {
        TollBooth a = new AlleghenyTollBooth();
    }

    @RepeatedTest(5)
    @DisplayName("TollBooth.calculateToll() - Random")
    void testCalculateTollRandom() {
        outputTest("calculateToll - Random");
        int randAxles = randInRange(3, 10);
        int randWeight = randInRange(5000, 15000);

        Truck t = new RefrigeratorTruck(randAxles, randWeight);
        System.out.println("Sample Truck");
        outputTruck(t);

        int testAxles = (5 * randAxles);
        int testWeight = (Math.floorDiv(randWeight, 1000) * 10);
        outputAmount("Expected toll: ", testAxles + testWeight);
        outputAmount("TollBooth.calculateToll(): ", a.calculateToll(t));
        a.reset();

        int lengthBefore = a.currentTruckCount();
        // asserts that the correct toll is calculated
        assertEquals(testAxles + testWeight, a.calculateToll(t));
        int lengthAfter = a.currentTruckCount();
        // asserts that the tollbooth arraylist is updated
        assertEquals(lengthBefore + 1, lengthAfter);
    }

    @Test
    @DisplayName("TollBooth.calculateToll() - Refrigerator Truck Control")
    void testCalculateTollControlR() {
        outputTest("calculateToll - Refrigerator Truck Control");
        Truck r = new RefrigeratorTruck(5, 12500);
        int sampleToll = a.calculateToll(r);
        System.out.println("Sample Truck");
        outputTruck(r);

        int testAxles = (5 * 5);
        int testWeight = (Math.floorDiv(12500, 1000) * 10);
        outputAmount("Expected toll", testAxles + testWeight);
        outputAmount("TollBooth.calculateToll()", sampleToll);
        System.out.println('\n');

        assertEquals(sampleToll, 145);
    }

    @Test
    @DisplayName("TollBooth.calculateToll() - Tractor Truck Control")
    void testCalculateTollControlT() {
        outputTest("calculateToll - Tractor Truck Control");
        Truck r = new TractorTruck(5, 4000);
        int sampleToll = a.calculateToll(r);
        System.out.println("Sample Truck");
        outputTruck(r);

        int testAxles = (5 * 5);
        int testWeight = (Math.floorDiv(4000, 1000) * 10);
        outputAmount("Expected toll", testAxles + testWeight);
        outputAmount("TollBooth.calculateToll()", sampleToll);
        System.out.println('\n');

        assertEquals(sampleToll, 65);
    }

    @Test
    @DisplayName("TollBooth.displayData() test")
    void testDisplayData() {
        outputTest("displayData");
        Truck r = new RefrigeratorTruck(5, 5000);
        Truck t = new TractorTruck(2, 5000);
        Truck t2 = new TractorTruck(6, 17000);
        a.calculateToll(r);
        a.calculateToll(t);
        a.calculateToll(t2);
        int testTotal = 75 + 60 + 200;
        int testCount = 3;
        String testData = "Total trucks since last collection: " + testCount + "\nTotal tolls collected: " + testTotal;
        System.out.println("Expected: \n\n" + testData);

        System.out.println("\nActual: \n");
        assertEquals(a.displayData(), testData);
    }

    @RepeatedTest(5)
    @DisplayName("TollBooth.reset() test")
    void testReset() {
        outputTest("reset");
        // randomly generated trucks go through the toll booth
        for (int i = 0; i < randInRange(5, 15); i++) {
            int randAxles = randInRange(3, 10);
            int randWeight = randInRange(5000, 15000);
            Truck r = new RefrigeratorTruck(randAxles, randWeight);
            a.calculateToll(r);
        }
        a.displayData();
        int lengthBefore = a.currentTruckCount();
        a.reset();
        int lengthAfter = a.currentTruckCount();
        a.displayData();
        System.out.println('\n');

        // asserts that the length after rest is 0
        assertEquals(lengthAfter, 0);
        // asserts that the length after reset is not equal to length before
        assertNotEquals(lengthBefore, lengthAfter);
    }
}