package org.howard.edu.lsp.assignment7.tollbooth;

public interface TollBooth {
    /**
     * Helper function to add a Truck to a tollbooth's working array of Trucks.
     * @param truck any implementation of a truck object
     */
    public void logTruck(Truck truck);

    /**
     * Helper function to return the size of the tollbooth's working array of trucks.
     * @return the size of the array
     */
    public int currentTruckCount();

    /**
     * Calculates the toll of a truck and adds the truck to the tollbooth's working array of trucks.
     * @param truck any implementation of a truck object
     * @return the cost of the toll for that truck
     */
    public int calculateToll(Truck truck);

    /**
     * Iterates through the tollbooth's working array of trucks and calculates the total tolls paid.
     * @return the total tolls for each truck that has used the tollbooth since last collection
     */
    public int calculateTotal();

    /**
     * Displays the data of a tollbooth at a certain point.
     * @return the string of tbe data printout for the tollbooth
     */
    public String displayData();

    /**
     * Resets the tollbooth. Essentially "collects" from the tollbooth.
     */
    public void reset();
}
