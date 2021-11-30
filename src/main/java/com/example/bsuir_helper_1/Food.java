package com.example.bsuir_helper_1;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

/**
 * The main class for food section
 */
public class Food {
    private final Position position;
    private final Rectangle rectangle;
    private final Random random = new Random();
    private final double size;

    /**
     * The main food parameters
     * @param xPos y food coordinate
     * @param yPos x food coordinate
     * @param pane The background where food appears
     * @param size Food size
     */
    public Food(final double xPos, final double yPos, final AnchorPane pane, final double size) {
        this.size = (int) size;
        position = new Position(xPos, yPos);
        rectangle = new Rectangle(position.getXPos(), position.getYPos(), size, size);
        pane.getChildren().add(rectangle);
    }

    /**
     * Returns food position
     * @return Food position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Generates food on the random field spot
     */
    public void moveFood() {
        getRandomSpotForFood();
    }

    /**
     * Destoys food once collected
     */
    public void destroyFood() {
        rectangle.setVisible(false);
    }

    /**
     * Generates a random place for food
     */
    public void getRandomSpotForFood() {
        double positionX = random.nextInt(10);
        double positionY = random.nextInt(10);
        rectangle.setX(positionX * size);
        rectangle.setY(positionY * size);
        rectangle.setVisible(true);
        position.setXPos(positionX * size);
        position.setYPos(positionY * size);
        float r = random.nextFloat();
        float g = random.nextFloat();
        float b = random.nextFloat();
        float opacity = 1;
        Color randomColor = new Color(r, g, b, opacity);
        rectangle.setFill(randomColor);
    }
}
