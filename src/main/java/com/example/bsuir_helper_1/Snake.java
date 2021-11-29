package com.example.bsuir_helper_1;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Основной класс змейки
 */
public class Snake {
    //A snake body part is 50x50
    private final double snakeSize;
    //Game ticks is how many times the snake have moved
    private int gameTicks;

    //x and y position of the snake head different from starting position
    double xPos;
    double yPos;
    //Direction snake is moving at start
    private Direction direction;

    private Rectangle snakeHead;
    private final ArrayList<Rectangle> snakeBody = new ArrayList<>();
    private final AnchorPane gameField;

    //List of all position of the snake head
    private final List<Position> positions = new ArrayList<>();
    //Direction snake is moving at start

    /**
     * Задание размера ополя игры
     * @param gameField Поле игры
     * @param size Разме поля игры
     */
    public Snake(AnchorPane gameField, double size) {
        this.gameField = gameField;
        this.snakeSize = size;
    }

    /**
     * Старт игры
     */
    public void start() {
        cleanItself();
        direction = Direction.D;
        gameTicks = 0;
        positions.clear();
        snakeBody.clear();
        snakeHead = new Rectangle(250, 250, snakeSize, snakeSize);
        //First snake tail created behind the head of the snake
        Rectangle snakeTail1 = new Rectangle(snakeHead.getX() - snakeSize, snakeHead.getY(), snakeSize, snakeSize);
        snakeBody.add(snakeHead);
        snakeHead.setFill(Color.DARKORANGE);
        snakeBody.add(snakeTail1);
        snakeTail1.setFill(Color.GREEN);
        gameField.getChildren().addAll(snakeHead, snakeTail1);
        snakeHead.setFill(Color.DARKORANGE);
        xPos = snakeHead.getLayoutX();
        yPos = snakeHead.getLayoutY();
    }

    /**
     * Передвижение хвоста змейки
     */
    public void moveSnakeForward() {

        positions.add(new Position(snakeHead.getX() + xPos, snakeHead.getY() + yPos));
        moveHead();
        for (int i = 1; i < snakeBody.size(); i++) {
            moveSnakeTail(snakeBody.get(i), i);
        }
        gameTicks++;
    }

    /**
     * Перемещение головы змейки
     */
    private void moveHead() {
        if (getDirection().equals(Direction.D)) {
            xPos = xPos + snakeSize;
            snakeHead.setTranslateX(xPos);
        } else if (getDirection().equals(Direction.A)) {
            xPos = xPos - snakeSize;
            snakeHead.setTranslateX(xPos);
        } else if (getDirection().equals(Direction.W)) {
            yPos = yPos - snakeSize;
            snakeHead.setTranslateY(yPos);
        } else if (getDirection().equals(Direction.S)) {
            yPos = yPos + snakeSize;
            snakeHead.setTranslateY(yPos);
        }
    }

    /**
     * Передвижение тела змейки
     * @param snakeTail Название тела змейки
     * @param tailNumber Разер тела
     */
    private void moveSnakeTail(Rectangle snakeTail, int tailNumber) {
        double yPos = positions.get(gameTicks - tailNumber + 1).getYPos() - snakeTail.getY();
        double xPos = positions.get(gameTicks - tailNumber + 1).getXPos() - snakeTail.getX();
        snakeTail.setTranslateX(xPos);
        snakeTail.setTranslateY(yPos);
    }

    /**
     * Очищение поля
     */
    public void cleanItself() {
        for (Rectangle snake : snakeBody) {
            gameField.getChildren().remove(snake);
        }
    }

    /**
     * Получение направления двежения змейки
     * @return Возвращает направления двежения змейки
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Задание напрвления движения змейки
     * @param direction направления двежения змейки
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * Увеличение размера тела при подборе еды
     * @param food Переменная, отвечающая за еду
     */
    public boolean isFoodInsideSnake(Food food) {
        int size = positions.size();
        if (size > 2) {
            for (int i = size - snakeBody.size(); i < size; i++) {
                if (food.getPosition().getXPos() == (positions.get(i).getXPos())
                        && food.getPosition().getYPos() == (positions.get(i).getYPos())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Отвечает за то, коснулась ли змея еды
     * @param food Переменная отвечающая за еду
     * @return Возвращает, затронула ли змея еду
     */
    public boolean isSnakeHitFood(Food food) {
        return xPos + snakeHead.getX() == food.getPosition().getXPos() && yPos + snakeHead.getY() == food.getPosition().getYPos();
    }

    //New snake tail is created and added to the snake and the anchor pane

    /**
     * Создание нового тела змейки при подборе еды
     */
    public void onFoodEat() {
        Rectangle snakeTail = new Rectangle(
                snakeBody.get(1).getX() + xPos + snakeSize,
                snakeBody.get(1).getY() + yPos,
                snakeSize, snakeSize);
        snakeBody.add(snakeTail);
        snakeTail.setFill(Color.GREEN);
        gameField.getChildren().add(snakeTail);
    }

    /**
     * Коснулась ли змейка стены
     */
    public boolean isSnakeHitWall() {
        return xPos > 250 || xPos < -250 || yPos < -250 || yPos > 250;
    }

    /**
     * Получения размера змейки
     */
    public int getSnakeSize() {
        return snakeBody.size();
    }

    /**
     * Коснулась ли змейка с собой
     * @return Возврат ответа, коснулась ли она себя
     */
    public boolean isSnakeHitItSelf() {
        int size = positions.size() - 1;
        if (size > 2) {
            for (int i = size - snakeBody.size(); i < size; i++) {
                if (positions.get(size).getXPos() == (positions.get(i).getXPos())
                        && positions.get(size).getYPos() == (positions.get(i).getYPos())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Получения координат местоположения змейки
     * @return Возвращает координаты змейки
     */
    Position getSnakeHeadPosition() {
        return new Position(snakeHead.getTranslateX(), snakeHead.getTranslateY());
    }


}
