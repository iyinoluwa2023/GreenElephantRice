package org.howard.edu.lsp.assignment7.tollbooth;

public interface TollBooth {
    public void logTruck(Truck t);
    int currentTruckCount();
    public int calculateToll(Truck t);
    public int calculateTotal();
    public String displayData();
    public void reset();
}
