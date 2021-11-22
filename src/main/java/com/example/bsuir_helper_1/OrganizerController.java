package com.example.bsuir_helper_1;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class OrganizerController implements Initializable {

    @FXML
    private TreeView<String> TreeView;

    //TODO зачем он тут нужен ?
    public OrganizerController() {
    }

    @Override
    public void initialize(final URL arg0, final ResourceBundle arg1) {
        //TODO так переменные не называют
        TreeItem<String> rootItem1 = new TreeItem<>("Важное");

        TreeItem<String> branchItem1 = new TreeItem<>("Домашнее задание");
        TreeItem<String> branchItem2 = new TreeItem<>("Планы");

        rootItem1.getChildren().addAll(branchItem1, branchItem2);

        TreeItem<String> rootItem2 = new TreeItem<>("Списки");

        TreeItem<String> branchItem3 = new TreeItem<>("Что посмотреть");
        TreeItem<String> branchItem4 = new TreeItem<>("Музыка");
        TreeItem<String> branchItem5 = new TreeItem<>("Места для посещения");

        rootItem2.getChildren().addAll(branchItem3, branchItem4, branchItem5);

        TreeView.setRoot(rootItem1);
        TreeView.setRoot(rootItem2);
    }

    public void SelectItem() {
        final TreeItem<String> item = TreeView.getSelectionModel().getSelectedItem();
        //TODO hahaha, это что ?? очень смешно, почитайте что сами написали
        if(item != null) {
            System.out.println(item.getValue());
        }
        assert item != null;
        System.out.println(item.getValue());
    }


    @FXML
    void initialize() {
        ButtonBase branchItem1 = null;
        //TODO это что и зачем оно тут ? Как оно решает то что ни один branchItem не инициализируется ? Вам new Button() написать религия не позволяет ?
        assert false;
        branchItem1.setOnAction(Event ->  {
            branchItem1.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("homework.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

        ButtonBase branchItem2 = null;
        branchItem2.setOnAction(Event ->  {
            branchItem2.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("plans.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

        ButtonBase branchItem3 = null;
        branchItem3.setOnAction(Event ->  {
            branchItem3.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("watch.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

        ButtonBase branchItem4 = null;
        branchItem4.setOnAction(Event ->  {
            branchItem4.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("music.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

        ButtonBase branchItem5 = null;
        branchItem5.setOnAction(Event ->  {
            branchItem5.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("places.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }

    public void Help(final ActionEvent actionEvent) {
    }
}
