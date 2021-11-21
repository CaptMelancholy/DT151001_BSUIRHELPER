package com.example.bsuir_helper_1;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

//TODO такие комментрарии иногда пишут для пояснения сложных/неочевидных кусков кода, в остальных случаях пишите java-doc-и для описания классов и методов
public class GameController implements Initializable {
    //TODO почему всё public ? Где-то нет модификаторов доступа совсем, переменные раскиданы по всему классу фиг знает как, выглядит очень так себе, перепишите нормально
    public static final int SNAKE_SIZE = 50;
    public Button startButton;
    public Label gameoverlabel;
    public Label gamecounterlabel;
    public Button exitButton;
    //TODO этот комментарий к чему ?
    //The head of the snake is created, at position (2  50,250)
    //x and y position of the snake head different from starting position

    //Food
    Food food;
    private int foodHitCounter;


    //Game ticks is how many times the snake have moved

    private Snake snake;

    @FXML
    private AnchorPane gameField;


    //Timeline that is running the game every time the KeyFrame is called (0.3 s)
    Timeline timeline;
    //Method called after the stage is loaded
    private boolean canChangeDirection;

    @FXML
    void start() {
        gameoverlabel.setText("");
        gamecounterlabel.setText("");

        canChangeDirection = true;
        food.moveFood();

        snake.start();
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    @FXML
    public void exit(final ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sample.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("BSUIR HELPER");
        stage.show();
    }

    @Override
    public void initialize(final URL url, final ResourceBundle resourceBundle) {
       snake = new Snake(gameField, SNAKE_SIZE);
        timeline = new Timeline(new KeyFrame(Duration.seconds(0.3), e -> {
            canChangeDirection = true;
            snake.moveSnakeForward();
            if (snake.isSnakeHitFood(food)) {
                eatFood();
            } else if (checkIfGameIsOver()) {
                notifyUser();
                timeline.stop();
                foodHitCounter = 0;
            }
        }));
        //A snake body part is 50x50
        double snakeSize = 50.;
        food = new Food(-50, -50, gameField, snakeSize);
    }

    private void notifyUser() {
        gameoverlabel.setText("GAME OVER PLEASE TRY AGAIN");
        snake.cleanItself();
        gamecounterlabel.setText("EATEN SQUARES: " + foodHitCounter + " GOOD JOB, SEE YOU LATER");

        food.gameoverFood();
        gameOverSound();
        timeline.stop();
    }

    //Change position with key pressed
    @FXML
    private void moveSquareKeyPressed(KeyEvent event) {
        if (canChangeDirection) {
            if (event.getCode().equals(KeyCode.W) && snake.getDirection() != Direction.DOWN) {
                snake.setDirection(Direction.UP);
            } else if (event.getCode().equals(KeyCode.S) && snake.getDirection() != Direction.UP) {
                snake.setDirection(Direction.DOWN);
            } else if (event.getCode().equals(KeyCode.A) && snake.getDirection() != Direction.RIGHT) {
                snake.setDirection(Direction.LEFT);
            } else if (event.getCode().equals(KeyCode.D) && snake.getDirection() != Direction.LEFT) {
                snake.setDirection(Direction.RIGHT);
            }
            canChangeDirection = false;
        }
    }

    public void gameOverSound() {
        String gameovermusicfile = "C:/Users/user/Desktop/bsuir_helper_1/src/main/resources/com/example/bsuir_helper_1/gameover.mp3";
        Media sound = new Media(new File(gameovermusicfile).toURI().toString());
        MediaPlayer gameoverplayer = new MediaPlayer(sound);
        gameoverplayer.play();
    }

    public void takeFoodSound() {
        String foodmusicfile = "C:/Users/user/Desktop/bsuir_helper_1/src/main/resources/com/example/bsuir_helper_1/food.mp3";
        Media sound = new Media(new File(foodmusicfile).toURI().toString());
        MediaPlayer foodplayer = new MediaPlayer(sound);
        foodplayer.play();
    }

    //Change position with key pressed
    public boolean checkIfGameIsOver() {
        return snake.isSnakeHitWall() || snake.isSnakeHitItSelf();
    }

    private void eatFood() {
            foodHitCounter++;
            takeFoodSound();
            gamecounterlabel.setText("EATEN SQUARES: " + foodHitCounter);
            foodCantSpawnInsideSnake();
            snake.onFoodEat();
    }

    private void foodCantSpawnInsideSnake() {
        food.moveFood();
        while (snake.isFoodInsideSnake(food)) {
            food.moveFood();
        }
    }
}
