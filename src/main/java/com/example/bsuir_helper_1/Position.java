package com.example.bsuir_helper_1;

/**
 * Основной класс местоположения
 */
public class Position {
    private double xPos;
    private double yPos;

    /**
     * Координаты местоположения
     * @param xPos x координата
     * @param yPos y координата
     */
    public Position(final double xPos, final double yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    /**
     *  Возвращает x координату
     */
    public double getXPos() {
        return xPos;
    }

    /**
     * Возвращает y координату
     */
    public double getYPos() {
        return yPos;
    }

    /**
     * Указывает x координтау
     */
    public void setXPos(double xPos) {
        this.xPos = xPos;
    }

    /**
     * Указывает y координату
     */
    public void setYPos(double yPos) {
        this.yPos = yPos;
    }

}