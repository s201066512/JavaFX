package com.example.demo;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Cube extends Application {
    Pane pane = new Pane();
    double sceneLength = 1200;
    double sceneHeight = 750;
    double theta = (Math.PI * 2) / 1000;
    double shift = 50;

    double pointOneX = -100;
    double pointOneY = -100;
    double pointOneZ = -100;
    double pointTwoX = -100;
    double pointTwoY = -100;
    double pointTwoZ = 100;
    double pointThreeX = -100;
    double pointThreeY = 100;
    double pointThreeZ = -100;
    double pointFourX = -100;
    double pointFourY = 100;
    double pointFourZ = 100;

    double pointFiveX = 100;
    double pointFiveY = -100;
    double pointFiveZ = -100;
    double pointSixX = 100;
    double pointSixY = -100;
    double pointSixZ = 100;
    double pointSevenX = 100;
    double pointSevenY = 100;
    double pointSevenZ = -100;
    double pointEightX = 100;
    double pointEightY = 100;
    double pointEightZ = 100;

    double[][] points =
            {{pointOneX, pointOneY, pointOneZ},
            {pointTwoX, pointTwoY, pointTwoZ},
            {pointThreeX, pointThreeY, pointThreeZ},
            {pointFourX, pointFourY, pointFourZ},
            {pointFiveX, pointFiveY, pointFiveZ},
            {pointSixX, pointSixY, pointSixZ},
            {pointSevenX, pointSevenY, pointSevenZ},
            {pointEightX, pointEightY, pointEightZ}};

    double[] zValues = {pointOneZ, pointTwoZ, pointThreeZ, pointFourZ, pointFiveZ, pointSixZ, pointSevenZ, pointEightZ};

    Circle point1 = new Circle(points[0][0], points[0][1],5, Color.BLACK); //
    Circle point2 = new Circle(points[1][0], points[1][1], 5, Color.BLACK);
    Circle point3 = new Circle(points[2][0], points[2][1], 5, Color.BLACK);
    Circle point4 = new Circle(points[3][0], points[3][1], 5, Color.BLACK);

    Circle point5 = new Circle(points[4][0], points[4][1], 5, Color.BLACK);
    Circle point6 = new Circle(points[5][0], points[5][1], 5, Color.BLACK);

    Circle point7 = new Circle(points[6][0], points[6][1], 5, Color.BLACK);
    Circle point8 = new Circle(points[7][0], points[7][1], 5, Color.BLACK);

    Line line1 = new Line();
    Line line2 = new Line();
    Line line3 = new Line();
    Line line4 = new Line();
    Line line5 = new Line();
    Line line6 = new Line();
    Line line7 = new Line();
    Line line8 = new Line();
    Line line9 = new Line();
    Line line10 = new Line();
    Line line11 = new Line();
    Line line12 = new Line();

    Group lines = new Group(line1, line2, line3, line4, line5, line6, line7, line8, line9, line10, line11, line12);
    Group POINTS = new Group(point1, point2, point3, point4, point5, point6, point7, point8);
    Scene scene = new Scene(pane, sceneLength, sceneHeight, Color.FLORALWHITE);

    @Override
    public void start(Stage stage) {

        pane.getChildren().add(lines);
        Timeline cube = new Timeline(
                new KeyFrame(Duration.millis(5), event -> {
                    updateLines();
                    rotateZ();
                    rotateX();
                    rotateY();
                }
                )
        );
        cube.setCycleCount(Timeline.INDEFINITE);
        cube.play();
        stage.setScene(scene);
        stage.setTitle("Cube");
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            KeyCode code = key.getCode();
            if (code == KeyCode.A){
                for (int i = 0; i < lines.getChildren().size(); i++){
                    lines.getChildren().get(i).setTranslateX(lines.getChildren().get(i).getTranslateX() - 10);
                }
            }
            if (code == KeyCode.D){
                for (int i = 0; i < lines.getChildren().size(); i++){
                    lines.getChildren().get(i).setTranslateX(lines.getChildren().get(i).getTranslateX() + 10);
                }
            }
            if (code == KeyCode.W){
                // make the
                for (int i = 0; i < zValues.length; i++){
                    zValues[i] = zValues[i] - 5;
                }
            }
            if (code == KeyCode.S){
                points[0][0] = points[0][0] + shift;
                points[0][1] = points[0][1] + shift;
                points[1][0] = points[1][0] - shift;
                points[1][1] = points[1][1] + shift;
                points[2][0] = points[2][0] + shift;
                points[2][1] = points[2][1] - shift;
                points[3][0] = points[3][0] - shift;
                points[3][1] = points[3][1] - shift;

            }
        });
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
    private void rotateZ() {
        for (int i = 0; i < points.length; i++) {
            double x = points[i][0] * Math.cos(theta) - points[i][1] * Math.sin(theta);
            double y = points[i][1] * Math.cos(theta) + points[i][0] * Math.sin(theta);

            POINTS.getChildren().get(i).setTranslateX(x + sceneLength/2);
            POINTS.getChildren().get(i).setTranslateY(y + sceneHeight/2);

            points[i][0] = x;
            points[i][1] = y;
        }
    }
    private void rotateX() {
        for (int i = 0; i < points.length; i++) {
            double z = points[i][1] * Math.cos(theta) - zValues[i] * Math.sin(theta);
            double y = zValues[i] * Math.cos(theta) + points[i][1] * Math.sin(theta);

            POINTS.getChildren().get(i).setTranslateY(y + sceneHeight/2);

            zValues[i] = z;
            points[i][1] = y;
        }
    }
    private void rotateY() {
        for (int i = 0; i < points.length; i++) {
            double x = points[i][0] * Math.cos(theta) - zValues[i] * Math.sin(theta);
            double z = zValues[i] * Math.cos(theta) + points[i][0] * Math.sin(theta);

            POINTS.getChildren().get(i).setTranslateX(x + sceneLength/2);

            zValues[i] = z;
            points[i][0] = x;
        }
    }
    private void updateLines(){
        line1.setStartX(points[0][0] + sceneLength/2); // aX
        line1.setStartY(points[0][1] + sceneHeight/2) ; // aY
        line1.setEndX(points[1][0] + sceneLength/2); // bX
        line1.setEndY(points[1][1] + sceneHeight/2); // bY

        line2.setStartX(points[2][0] + sceneLength/2); // cX
        line2.setStartY(points[2][1] + sceneHeight/2); // cY
        line2.setEndX(points[3][0] + sceneLength/2); // dX
        line2.setEndY(points[3][1] + sceneHeight/2); // dY

        line3.setStartX(points[0][0] + sceneLength/2); // a
        line3.setStartY(points[0][1] + sceneHeight/2);
        line3.setEndX(points[3][0] + sceneLength/2); // d
        line3.setEndY(points[3][1] + sceneHeight/2);

        line4.setStartX(points[1][0] + sceneLength/2); // b
        line4.setStartY(points[1][1] + sceneHeight/2);
        line4.setEndX(points[2][0] + sceneLength/2); // c
        line4.setEndY(points[2][1] + sceneHeight/2);

        line5.setStartX(points[4][0] + sceneLength/2); // e
        line5.setStartY(points[4][1] + sceneHeight/2);
        line5.setEndX(points[5][0] + sceneLength/2); // f
        line5.setEndY(points[5][1] + sceneHeight/2);

        line6.setStartX(points[5][0] + sceneLength/2); // f
        line6.setStartY(points[5][1] + sceneHeight/2);
        line6.setEndX(points[6][0] + sceneLength/2); // g
        line6.setEndY(points[6][1] + sceneHeight/2);

        line7.setStartX(points[6][0] + sceneLength/2); // g
        line7.setStartY(points[6][1] + sceneHeight/2);
        line7.setEndX(points[7][0] + sceneLength/2); // h
        line7.setEndY(points[7][1] + sceneHeight/2);

        line8.setStartX(points[7][0] + sceneLength/2); // h
        line8.setStartY(points[7][1] + sceneHeight/2);
        line8.setEndX(points[4][0] + sceneLength/2); // e
        line8.setEndY(points[4][1] + sceneHeight/2);

        line9.setStartX(points[0][0] + sceneLength/2); // a
        line9.setStartY(points[0][1] + sceneHeight/2);
        line9.setEndX(points[4][0] + sceneLength/2); // e
        line9.setEndY(points[4][1] + sceneHeight/2);

        line10.setStartX(points[7][0] + sceneLength/2); // h
        line10.setStartY(points[7][1] + sceneHeight/2);
        line10.setEndX(points[3][0] + sceneLength/2); // d
        line10.setEndY(points[3][1] + sceneHeight/2);

        line11.setStartX(points[1][0] + sceneLength/2); // b
        line11.setStartY(points[1][1] + sceneHeight/2);
        line11.setEndX(points[5][0] + sceneLength/2); // f
        line11.setEndY(points[5][1] + sceneHeight/2);

        line12.setStartX(points[6][0] + sceneLength/2); // g
        line12.setStartY(points[6][1] + sceneHeight/2);
        line12.setEndX(points[2][0] + sceneLength/2); // c
        line12.setEndY(points[2][1] + sceneHeight/2);

    }
}
