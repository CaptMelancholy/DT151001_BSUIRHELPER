package com.example.bsuir_helper_1;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

/**
 * Главный класс, отчечающий за блоки еды
 */
public class Food {
    private final Position position;
    private final Rectangle rectangle;
    private final Random random = new Random();
    private final double size;

    /**
     * Основные параметры еды
     * @param xPos y координата еды
     * @param yPos x координата еды
     * @param pane Фон, на котором появляется еда
     * @param size Размер еды
     */
    public Food(final double xPos, final double yPos, final AnchorPane pane, final double size) {
        this.size = (int) size;
        position = new Position(xPos, yPos);
        rectangle = new Rectangle(position.getXPos(), position.getYPos(), size, size);
        pane.getChildren().add(rectangle);
    }

    /**
     * Возвращает позицию еды
     * @return Позиция еды
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Генерация еды на случайном месте поля
     */
    public void moveFood() {
        getRandomSpotForFood();
    }

    /**
     * Уничтожение еды при ее подборе
     */
    public void destroyFood() {
        rectangle.setVisible(false);
    }

    /**
     * Генерация случайного места для еды
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
