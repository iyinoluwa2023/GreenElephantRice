package org.howard.edu.lsp.assignment7.tollbooth;

public abstract class Truck {
    protected int axles = 0;
    protected int weight = 0;

    /**
     * Get function for the weight of the truck object
     * @return the weight of the truck object
     */
    public int getWeight() {
        return this.weight;
    }
    /**
     * Get function for the axles of the truck object
     * @return the axle count of the truck object
     */
    public int getAxles() {
        return this.axles;
    }
}
