package com.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
public class RandomCircles extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        double sceneWidth = 500;
        double sceneHeight = 500;

        // adds N amount of circles to the pane
        Pane pane = new Pane(circles(1000));
        Scene scene = new Scene(pane, sceneWidth, sceneHeight, Color.WHITE);
        primaryStage.setTitle("Random Circles");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private Pane circles(int N){
        Color[] colors = {Color.BLUE, Color.RED, Color.GREEN, Color.PURPLE, Color.BLACK, Color.BLUEVIOLET, Color.CADETBLUE, Color.CHOCOLATE, Color.CRIMSON, Color.BISQUE, Color.PERU, Color.MIDNIGHTBLUE, Color.LIMEGREEN, Color.GOLD, Color.MEDIUMAQUAMARINE};
        Pane CirclePane = new Pane();
        double radius = 50;

        // now radius will decrease by N amount of times until it becomes 0
        double decrease = radius / N;
        if (N > 0){
            while (radius > 0){

                // create random X Y coordinates between 0 and 500
                double randomX = Math.random() * (500);
                double randomY = Math.random() * (500);

                // check that those coordinates plus the radius are between 100 and 500
                // this prevents any circles not being fully shown
                if (randomX + radius > 100 && randomY + radius > 100 && randomX + radius < 500 && randomY + radius < 500){
                    Color randomColor = colors[((int)(Math.random() * 14 + 1))]; // get a random color
                    Circle C = new Circle(randomX, randomY, radius); // create the circle

                    // set the properties
                    C.setFill(randomColor);
                    C.setStroke((randomColor.darker()).darker());
                    CirclePane.getChildren().add(C); // add new to the pane
                    radius = radius - decrease; // decrease radius so circles gradually get smaller
                }
            }
        }
        // if N is 0 do nothing
        else if (N == 0){
            return new Pane();
        }
        // returns the pane with all the circles
        return CirclePane;
    }
}
