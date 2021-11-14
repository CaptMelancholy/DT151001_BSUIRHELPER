package com.example.bsuir_helper_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;


public class OrganizerController implements Initializable {

    @FXML
    private TreeView TreeView;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

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

        TreeItem<String> item = (TreeItem<String>) TreeView.getSelectionModel().getSelectedItem();
        if(item != null) {
            System.out.println(item.getValue());
        }
        System.out.println(item.getValue());

    }

    @FXML
    private MenuBar MenuBar;

    @FXML
    private Menu ChangeMenu;

    @FXML
    private MenuItem UndoMenuItem;

    @FXML
    private MenuItem DeleteMenuItem;

    @FXML
    private Menu HelpMenu;

    @FXML
    private MenuItem AboutMenuItem;

    @FXML
    private SplitPane SplitPane;

}
