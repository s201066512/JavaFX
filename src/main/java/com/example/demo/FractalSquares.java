package com.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
public class FractalSquares extends Application {
    Pane pane = new Pane();
    double sceneLength = 700;
    Scene scene = new Scene(pane, sceneLength, sceneLength, Color.FLORALWHITE);

    @Override
    public void start(Stage stage) {
        stage.setTitle("Squares");
        squares((float) sceneLength, (float) (sceneLength/2), (float) (sceneLength/2));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void squares(float length, float x, float y){
        Color[] colors = {Color.BLUE, Color.TEAL, Color.MIDNIGHTBLUE, Color.PURPLE, Color.DEEPSKYBLUE, Color.BLUEVIOLET, Color.CADETBLUE, Color.DARKCYAN, Color.DARKTURQUOISE, Color.DARKSLATEBLUE};
        Color randomColor = colors[((int)(Math.random() * 9 + 1))];

        Rectangle square = new Rectangle(x, y, length, length);
        square.setFill(randomColor);
        square.setStroke(Color.FLORALWHITE);
        pane.getChildren().add(square);
        if (length > 1){
            squares(length/2, x + length/2, y);
            squares(length/2, x - length/2, y);
            squares(length/2, x, y + length/2);
            squares(length/2, x, y - length/2);
        }
    }
}
