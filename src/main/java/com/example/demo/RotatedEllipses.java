package com.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class RotatedEllipses extends Application {
    double sceneHeight = 500;
    double sceneWidth = 500;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane(ellipses(1000));
        Scene scene = new Scene(pane, sceneWidth, sceneHeight, Color.WHITE);
        primaryStage.setTitle("Rotated Ellipses");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    private Pane ellipses (int N){
        Color[] colors = {Color.BLUE, Color.RED, Color.GREEN, Color.PURPLE, Color.BLACK, Color.BLUEVIOLET, Color.CADETBLUE, Color.CHOCOLATE, Color.CRIMSON, Color.BISQUE, Color.PERU, Color.MIDNIGHTBLUE, Color.LIMEGREEN, Color.GOLD, Color.MEDIUMAQUAMARINE};
        Pane ellipsesPane = new Pane();
        while (N > 0){
            double rotation = (double) 180 / N;
            Color randomColor = colors[((int)(Math.random() * 14 + 1))]; // get a random color
            Ellipse E = new Ellipse(sceneHeight/2, sceneWidth/2, sceneWidth/2, sceneWidth/4);
            E.setFill(Color.TRANSPARENT);
            E.setStroke(randomColor);
            E.setStrokeWidth(2);
            Rotate rotate = new Rotate(rotation, sceneWidth/2, sceneHeight/2);
            E.getTransforms().add(rotate);
            ellipsesPane.getChildren().add(E);
            N--;
        }
        return ellipsesPane;
    }
}
