package com.example.bsuir_helper_1;

import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;
import javafx.scene.layout.AnchorPane;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class SnakeTest {

    public static final int SNAKE_SIZE = 50;
    private Snake snake;
    AnchorPane anchorPane;

    @BeforeEach
    public void init() {
        anchorPane = Mockito.mock(AnchorPane.class);
        snake = new Snake(anchorPane, SNAKE_SIZE);
    }

    @Test
    public void testInitialSnakeSize() {
        ObservableList observableList = Mockito.mock(SimpleListProperty.class);
        Mockito.when(observableList.add(Mockito.any())).thenReturn(true);
        Mockito.when(anchorPane.getChildren()).thenReturn(observableList);
        snake.start();
        Assert.assertEquals(2, snake.getSnakeSize());
    }


    @Test
    public void testSnakeMovesWhenItShouldMove() {
        ObservableList observableList = Mockito.mock(SimpleListProperty.class);
        Mockito.when(observableList.add(Mockito.any())).thenReturn(true);
        Mockito.when(anchorPane.getChildren()).thenReturn(observableList);
        snake.start();
        Position initialHeadPosition = snake.getSnakeHeadPosition();
        System.out.println(initialHeadPosition);
        snake.setDirection(Direction.RIGHT);
        snake.moveSnakeForward();
        snake.setDirection(Direction.DOWN);
        snake.moveSnakeForward();
        snake.setDirection(Direction.LEFT);
        snake.moveSnakeForward();
        snake.setDirection(Direction.UP);
        snake.moveSnakeForward();
        Position afterMoveHeadPosition = snake.getSnakeHeadPosition();
        assertEquals(initialHeadPosition.getYPos(), afterMoveHeadPosition.getYPos());
        assertEquals(initialHeadPosition.getYPos(), afterMoveHeadPosition.getYPos());


    }
    @Test
    public void testSnakeHitItSelf() {
        ObservableList observableList = Mockito.mock(SimpleListProperty.class);
        Mockito.when(observableList.add(Mockito.any())).thenReturn(true);
        Mockito.when(anchorPane.getChildren()).thenReturn(observableList);
        snake.start();

        int initialSnakeSize = snake.getSnakeSize();
        System.out.println(initialSnakeSize);
        snake.setDirection(Direction.RIGHT);
        snake.moveSnakeForward();

        snake.onFoodEat();
        snake.moveSnakeForward();
        snake.onFoodEat();
        snake.moveSnakeForward();
        snake.onFoodEat();
        snake.moveSnakeForward();
        snake.moveSnakeForward();
        snake.onFoodEat();
        snake.moveSnakeForward();
        snake.moveSnakeForward();
        snake.setDirection(Direction.DOWN);
        snake.moveSnakeForward();
        snake.setDirection(Direction.LEFT);
        snake.moveSnakeForward();
        snake.setDirection(Direction.UP);
        snake.moveSnakeForward();



        snake.isSnakeHitItSelf();
        Assert.assertEquals(snake.getSnakeSize(), initialSnakeSize + 4);
        Mockito.verify(observableList, Mockito.times(4)).add(Mockito.any());


    }

    @Test
    public void testHitTheWallRight() {
        ObservableList observableList = Mockito.mock(SimpleListProperty.class);
        Mockito.when(observableList.add(Mockito.any())).thenReturn(true);
        Mockito.when(anchorPane.getChildren()).thenReturn(observableList);
        snake.start();
        Position initialHeadPosition = snake.getSnakeHeadPosition();
        System.out.println(initialHeadPosition);
        snake.setDirection(Direction.RIGHT);
        snake.moveSnakeForward();
        snake.moveSnakeForward();
        snake.moveSnakeForward();
        snake.moveSnakeForward();
        snake.moveSnakeForward();
        snake.moveSnakeForward();
        snake.isSnakeHitWall();
        Position afterMoveHeadPosition = snake.getSnakeHeadPosition();
        assertEquals(initialHeadPosition.getYPos(), afterMoveHeadPosition.getYPos());
        assertEquals(afterMoveHeadPosition.getXPos(), initialHeadPosition.getXPos() + 300);


    }
    @Test
    public void testHitTheWallDOWN() {
        ObservableList observableList = Mockito.mock(SimpleListProperty.class);
        Mockito.when(observableList.add(Mockito.any())).thenReturn(true);
        Mockito.when(anchorPane.getChildren()).thenReturn(observableList);
        snake.start();

        Position initialHeadPosition = snake.getSnakeHeadPosition();
        System.out.println(initialHeadPosition);
        snake.setDirection(Direction.DOWN);
        snake.moveSnakeForward();
        snake.moveSnakeForward();
        snake.moveSnakeForward();
        snake.moveSnakeForward();
        snake.moveSnakeForward();
        snake.moveSnakeForward();
        snake.isSnakeHitWall();
        Position afterMoveHeadPosition = snake.getSnakeHeadPosition();
        assertEquals(initialHeadPosition.getXPos(), afterMoveHeadPosition.getXPos());
        assertEquals(afterMoveHeadPosition.getYPos(), initialHeadPosition.getYPos() + 300);


    }
    @Test
    public void testHitTheWallUP() {
        ObservableList observableList = Mockito.mock(SimpleListProperty.class);
        Mockito.when(observableList.add(Mockito.any())).thenReturn(true);
        Mockito.when(anchorPane.getChildren()).thenReturn(observableList);
        snake.start();
        Position initialHeadPosition = snake.getSnakeHeadPosition();
        System.out.println(initialHeadPosition);
        snake.setDirection(Direction.UP);
        snake.moveSnakeForward();
        snake.moveSnakeForward();
        snake.moveSnakeForward();
        snake.moveSnakeForward();
        snake.moveSnakeForward();
        snake.moveSnakeForward();
        snake.isSnakeHitWall();
        Position afterMoveHeadPosition = snake.getSnakeHeadPosition();
        assertEquals(initialHeadPosition.getXPos(), afterMoveHeadPosition.getXPos());
        assertEquals(afterMoveHeadPosition.getYPos(), initialHeadPosition.getYPos() - 300);


    }


    @Test
    public void testHitTheWallLEFT() {
        ObservableList observableList = Mockito.mock(SimpleListProperty.class);
        Mockito.when(observableList.add(Mockito.any())).thenReturn(true);
        Mockito.when(anchorPane.getChildren()).thenReturn(observableList);
        snake.start();
        Position initialHeadPosition = snake.getSnakeHeadPosition();
        System.out.println(initialHeadPosition);
        snake.setDirection(Direction.LEFT);
        snake.moveSnakeForward();
        snake.moveSnakeForward();
        snake.moveSnakeForward();
        snake.moveSnakeForward();
        snake.moveSnakeForward();
        snake.moveSnakeForward();
        snake.isSnakeHitWall();
        Position afterMoveHeadPosition = snake.getSnakeHeadPosition();
        assertEquals(initialHeadPosition.getYPos(), afterMoveHeadPosition.getYPos());
        assertEquals(afterMoveHeadPosition.getXPos(), initialHeadPosition.getXPos() - 300);

    }
    @Test
    public void onFoodEat() {

        ObservableList observableList = Mockito.mock(SimpleListProperty.class);
        Mockito.when(observableList.add(Mockito.any())).thenReturn(true);
        Mockito.when(anchorPane.getChildren()).thenReturn(observableList);
        snake.start();
        int initialSnakeSize = snake.getSnakeSize();
        System.out.println(initialSnakeSize);
        snake.onFoodEat();
        Assert.assertEquals(snake.getSnakeSize(), initialSnakeSize + 1);
        Mockito.verify(observableList, Mockito.times(1)).add(Mockito.any());
    }
    @Test
    public void cleanItself() {

        ObservableList observableList = Mockito.mock(SimpleListProperty.class);
        Mockito.when(observableList.add(Mockito.any())).thenReturn(true);
        Mockito.when(anchorPane.getChildren()).thenReturn(observableList);
        snake.start();
        int initialSnakeSize = snake.getSnakeSize();
        System.out.println(initialSnakeSize);
        snake.cleanItself();
        Assert.assertEquals(snake.getSnakeSize(),  initialSnakeSize);
    }
}