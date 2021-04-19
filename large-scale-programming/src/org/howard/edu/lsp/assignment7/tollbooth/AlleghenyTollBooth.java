package org.howard.edu.lsp.assignment7.tollbooth;

import java.util.ArrayList;

public class AlleghenyTollBooth implements TollBooth {

    private final ArrayList<Truck> currTrucks = new ArrayList<Truck>();

    @Override
    public void logTruck(Truck t) {
        currTrucks.add(t);
    }

    @Override
    public int currentTruckCount() {
        return currTrucks.size();
    }

    @Override
    public int calculateToll(Truck t) {
        this.logTruck(t);
        return ((5 * t.getAxles()) + (Math.floorDiv(t.getWeight(), 1000)) * 10);
    }

    @Override
    public int calculateTotal() {
        int total = 0;
        for (Truck t : this.currTrucks)
            total += ((5 * t.getAxles()) + (Math.floorDiv(t.getWeight(), 1000)) * 10);
        return total;
    }

    @Override
    public String displayData() {
        String data = "Total trucks since last collection: " + this.currTrucks.size() +
                "\nTotal tolls collected: " + this.calculateTotal();
        System.out.println(data);
        return data;
    }

    @Override
    public void reset() {
        currTrucks.clear();
        System.out.println("Current tolls collected!\n");
    }
}
