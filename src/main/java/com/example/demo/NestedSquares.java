package com.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class NestedSquares extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        StackPane sp = new StackPane();
        sp = NestedSquare(10000, 0.05);

        double sceneWidth = transferWidth;
        double sceneHeight = transferHeight;
        Scene scene = new Scene(sp, sceneWidth, sceneHeight, Color.WHITE);
        stage.setTitle("Nested Squares");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    double transferWidth;
    double transferHeight;

    private StackPane NestedSquare (int N, double gap){
        Color[] colors = {Color.BLUE, Color.RED, Color.GREEN, Color.PURPLE, Color.BLACK, Color.BLUEVIOLET, Color.CADETBLUE, Color.CHOCOLATE, Color.CRIMSON, Color.BISQUE};
        double sceneWidthN = N*gap;
        double sceneHeightN = N*gap;
        transferWidth = sceneWidthN;
        transferHeight = sceneHeightN;
        StackPane stack = new StackPane();
        int count = 0;

        if (N >= 0){
            while (N >= 1){
                Color randomColor = colors[((int)(Math.random() * 9 + 1))];
                Rectangle rect = new Rectangle(sceneWidthN - (count* gap), sceneHeightN - (count* gap)); // add width, and height
                rect.setStroke(randomColor);
                rect.setStrokeWidth(2);
                rect.setFill(Color.TRANSPARENT);

                count++;
                N--;

                if (N == 1){
                    Rectangle lastRect = new Rectangle(sceneWidthN - (count* gap *2), sceneHeightN - (count* gap *2));
                    lastRect.setFill(Color.TRANSPARENT);
                    lastRect.setStroke(randomColor);
                    lastRect.setStrokeWidth(2);
                    stack.getChildren().add(lastRect);
                }
                stack.getChildren().add(rect);
            }
            return stack;
        }
        else{
            return new StackPane();
        }
    }
}
