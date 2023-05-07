package com.example.demo;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Fractal extends Application {
    Pane pane = new Pane();

    double sceneLength = 1000;
    double sceneHeight = 1000;
    Scene scene = new Scene(pane, sceneLength, sceneHeight, Color.FLORALWHITE);

    @Override
    public void start(Stage stage) {
        stage.setTitle("Circles");
        circles(sceneLength/2, (sceneLength/2), (sceneHeight/2));
        stage.setScene(scene);

        Timeline zoom = new Timeline(
                new KeyFrame(Duration.millis(10), event -> {
                    zoomIn(pane);
                }
                )
        );
        Timeline zoomOut = new Timeline(
                new KeyFrame(Duration.seconds(23), event -> {
                    Scale newScale = new Scale();
                    newScale.setX(pane.getScaleX() - 0.52);
                    newScale.setY(pane.getScaleY() - 0.52);
                    newScale.setPivotX(sceneHeight/2);
                    newScale.setPivotY(sceneLength/2);
                    pane.getTransforms().add(newScale);
                    System.out.println("zoomOut");
                }
                )
        );
        zoomOut.setCycleCount(Timeline.INDEFINITE);
        zoomOut.play();
        zoom.setCycleCount(Timeline.INDEFINITE);
        zoom.play();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void circles(double radius, double x, double y){
        // double originalX = x;
        Color[] colors = {Color.BLUE, Color.TEAL, Color.MIDNIGHTBLUE, Color.PURPLE, Color.DEEPSKYBLUE, Color.BLUEVIOLET, Color.CADETBLUE, Color.DARKCYAN, Color.DARKTURQUOISE, Color.DARKSLATEBLUE};
        Color randomColor = colors[((int)(Math.random() * 9 + 1))];
        // x = (x*Math.cos(Math.PI/2)) - y*(Math.sin(Math.PI/2));
        // y = (originalX*Math.sin(Math.PI/2) + y*Math.cos(Math.PI/2));
        Circle circle = new Circle(x, y, radius);
        circle.setFill(randomColor);
        circle.setStroke(Color.FLORALWHITE);
        pane.getChildren().add(circle);
        if (radius > 1){
            circles(radius/2, x + radius/2, y);
            circles(radius/2, x - radius/2, y);
            circles(radius/2, x, y + radius/2);
            circles(radius/2, x, y - radius/2);
        }
    }
    private void zoomIn(Pane pane) {
        Scale newScale = new Scale();
        newScale.setX(pane.getScaleX() + 0.00035);
        newScale.setY(pane.getScaleY() + 0.00035);
        newScale.setPivotX(sceneHeight/2);
        newScale.setPivotY((sceneLength/2));
        pane.getTransforms().add(newScale);
    }
}
