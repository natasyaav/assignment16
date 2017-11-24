import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;

import javafx.geometry.Pos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
/**
 * Natasya Virgichalia
 * Date: 11/19/2017
 * Professor Tanes Kanchanawanchai
 * CSC-201.
 * Assignment 16.16
 * This program use ComboBox and ListView to make a program that demonstrates selecting items in a list.
 */
public class selectingItems extends Application {
    public ObservableList<String> items =
            FXCollections.observableArrayList("China", "Japan", "Korea", "India", "Indonesia", "Vietnam");
    public ListView<String> list = new ListView<>(items);
    public ComboBox<String> combo = new ComboBox<>();
    public Label label = new Label("Select a country");

    @Override
    public void start(Stage primaryStage) {
        combo.getItems().addAll("SINGLE", "MULTIPLE");
        combo.setValue("SINGLE");
        Label selectMode = new Label("Selection Mode:", combo);
        selectMode.setContentDisplay(ContentDisplay.RIGHT);
        list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        combo.setOnAction(e -> {
            if (combo.getValue().equals("SINGLE")) {
                list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            } else {
                list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            }
            String items = "Selected items are ";
            for (String i : list.getSelectionModel().getSelectedItems())
                items += i + " ";
            label.setText(items);
        });
        list.getSelectionModel().selectedItemProperty().addListener(v -> {
            if (combo.getValue().equals("SINGLE")) {
                list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            } else {
                list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            }
            String items = "Selected items are ";
            for (String i : list.getSelectionModel().getSelectedItems())
                items += i + " ";
            label.setText(items);
        });
        BorderPane pane = new BorderPane();
        pane.setAlignment(selectMode, Pos.CENTER);
        pane.setTop(selectMode);
        pane.setBottom(label);
        pane.setCenter(new ScrollPane(list));

        Scene scene = new Scene(pane, 300, 200);
        primaryStage.setTitle("Choose a Country");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
