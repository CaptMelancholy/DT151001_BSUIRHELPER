package com.example.bsuir_helper_1;

/**
 * Location main class
 */
public class Position {
    private double xPos;
    private double yPos;

    /**
     * Location coordinates
     * @param xPos x coordinate
     * @param yPos y coordinate
     */
    public Position(final double xPos, final double yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    /**
     *  Returns x coordinate
     */
    public double getXPos() {
        return xPos;
    }

    /**
     * Returns y coordinate
     */
    public double getYPos() {
        return yPos;
    }

    /**
     * Indicates x coordinate
     */
    public void setXPos(double xPos) {
        this.xPos = xPos;
    }

    /**
     * Indicates y coordinate
     */
    public void setYPos(double yPos) {
        this.yPos = yPos;
    }

}
