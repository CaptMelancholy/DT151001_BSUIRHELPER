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
    public void testSnakeMovesWhenItShouldMoveDown() {
        ObservableList observableList = Mockito.mock(SimpleListProperty.class);
        Mockito.when(observableList.add(Mockito.any())).thenReturn(true);
        Mockito.when(anchorPane.getChildren()).thenReturn(observableList);
        snake.start();
        Position initialHeadPosition = snake.getSnakeHeadPosition();
        snake.setDirection(Direction.DOWN);
        snake.moveSnakeForward();
        Position afterMoveHeadPosition = snake.getSnakeHeadPosition();
        assertEquals(initialHeadPosition.getXPos(), afterMoveHeadPosition.getXPos());
        assertEquals(SNAKE_SIZE,  afterMoveHeadPosition.getYPos() - initialHeadPosition.getYPos());


    }
    @Test
    public void testSnakeMovesWhenItShouldMoveUP() {
        ObservableList observableList = Mockito.mock(SimpleListProperty.class);
        Mockito.when(observableList.add(Mockito.any())).thenReturn(true);
        Mockito.when(anchorPane.getChildren()).thenReturn(observableList);
        snake.start();
        Position initialHeadPosition = snake.getSnakeHeadPosition();
        snake.setDirection(Direction.UP);
        snake.moveSnakeForward();
        Position afterMoveHeadPosition = snake.getSnakeHeadPosition();
        assertEquals(initialHeadPosition.getXPos(), afterMoveHeadPosition.getXPos());
        assertEquals(SNAKE_SIZE,  initialHeadPosition.getYPos() - afterMoveHeadPosition.getYPos());


    }

    @Test
    public void testSnakeMovesWhenItShouldMoveRight() {
        ObservableList observableList = Mockito.mock(SimpleListProperty.class);
        Mockito.when(observableList.add(Mockito.any())).thenReturn(true);
        Mockito.when(anchorPane.getChildren()).thenReturn(observableList);
        snake.start();
        Position initialHeadPosition = snake.getSnakeHeadPosition();
        System.out.println(initialHeadPosition);
        snake.setDirection(Direction.RIGHT);
        snake.moveSnakeForward();
        Position afterMoveHeadPosition = snake.getSnakeHeadPosition();
        assertEquals(initialHeadPosition.getYPos(), afterMoveHeadPosition.getYPos());
        assertEquals(SNAKE_SIZE,  afterMoveHeadPosition.getXPos() - initialHeadPosition.getXPos());


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
        snake.isSnakeHitWall();
        Position afterMoveHeadPosition = snake.getSnakeHeadPosition();
        assertEquals(initialHeadPosition.getYPos(), afterMoveHeadPosition.getYPos());
        assertEquals(afterMoveHeadPosition.getXPos(), initialHeadPosition.getXPos() + 250);


    }
    @Test
    public void testSnakeMovesWhenItShouldMoveLeft() {
        ObservableList observableList = Mockito.mock(SimpleListProperty.class);
        Mockito.when(observableList.add(Mockito.any())).thenReturn(true);
        Mockito.when(anchorPane.getChildren()).thenReturn(observableList);
        snake.start();
        Position initialHeadPosition = snake.getSnakeHeadPosition();
        snake.setDirection(Direction.LEFT);
        snake.moveSnakeForward();
        Position afterMoveHeadPosition = snake.getSnakeHeadPosition();
        assertEquals(initialHeadPosition.getYPos(), afterMoveHeadPosition.getYPos());
        assertEquals(SNAKE_SIZE, initialHeadPosition.getXPos() - afterMoveHeadPosition.getXPos());


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
    public void testSnakeCleanItSelfWhenWeNeed() {

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