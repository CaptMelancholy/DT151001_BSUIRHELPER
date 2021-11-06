package com.example.bsuir_helper_1;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class Food {
    private final Position position;
    private final Rectangle rectangle;
    private final Random random = new Random();
    private final int size;


    public Food(double xPos, double yPos, AnchorPane pane, double size) {
        this.size = (int) size;
        position = new Position(xPos,yPos);
        rectangle = new Rectangle(position.getXPos(),position.getYPos(),size,size);
        Color color = Color.GREEN;
        rectangle.setFill(color);
        pane.getChildren().add(rectangle);
    }

    public Position getPosition() {
        return position;
    }

    public void moveFood(){
        getRandomSpotForFood();
    }

    public void getRandomSpotForFood(){
        int positionX = random.nextInt(10);
        int positionY = random.nextInt(10);
        rectangle.setX(positionX * size);
        rectangle.setY(positionY * size);

        position.setXPos(positionX * size);
        position.setYPos(positionY * size);
        System.out.println((positionX * size) + "---FOOD---" +(positionY * size));
    }
}
