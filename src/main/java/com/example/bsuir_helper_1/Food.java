package com.example.bsuir_helper_1;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

//TODO сдесь и везде по проекту посоветую не использовать примитивные типы без явной необходимости, лучше использовать классы-обертки, будет меньше проблем в будущем
public class Food {
    private final Position position;
    private final Rectangle rectangle;
    private final Random random = new Random();
    private final double size;

    public Food(final double xPos, final double yPos, final AnchorPane pane, final double size) {
        this.size = (int) size;
        position = new Position(xPos, yPos);
        rectangle = new Rectangle(position.getXPos(), position.getYPos(), size, size);
        pane.getChildren().add(rectangle);
    }


    public Position getPosition() {
        return position;
    }

    public void moveFood() {
        getRandomSpotForFood();
    }

    public void gameoverFood() {
        getStaticSpotForFood();
    }

    public void getStaticSpotForFood() {
        double positionX = -100;
        double positionY = -100;
        rectangle.setX(positionX * size);
        rectangle.setY(positionY * size);

        position.setXPos(positionX * size);
        position.setYPos(positionY * size);
    }

    public void getRandomSpotForFood() {
        double positionX = random.nextInt(10);
        double positionY = random.nextInt(10);
        rectangle.setX(positionX * size);
        rectangle.setY(positionY * size);

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
