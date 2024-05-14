package org.example.lab6;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.util.Random;

public class HelloApplication extends Application {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int IMAGE_SIZE = 100;

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Deplasare haotica de imagini");
        primaryStage.show();

        File directory = new File("D:\\Anul II\\RC\\screen");

        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String imageUrl = file.toURI().toString();
                        Image image = new Image(imageUrl);
                        ImageView imageView = new ImageView(image);
                        imageView.setFitWidth(IMAGE_SIZE);
                        imageView.setFitHeight(IMAGE_SIZE);
                        root.getChildren().add(imageView);

                        Random random = new Random();
                        imageView.setLayoutX(random.nextInt(300));
                        imageView.setLayoutY(random.nextInt(300));

                        new AnimationTimer() {
                            double dx = random.nextDouble() * 5 - 2.5;
                            double dy = random.nextDouble() * 5 - 2.5;

                            @Override
                            public void handle(long now) {
                                imageView.setLayoutX(imageView.getLayoutX() + dx);
                                imageView.setLayoutY(imageView.getLayoutY() + dy);

                                if (imageView.getLayoutX() < 0 || imageView.getLayoutX() > WIDTH - imageView.getBoundsInParent().getWidth()) {
                                    dx = -dx;
                                }
                                if (imageView.getLayoutY() < 0 || imageView.getLayoutY() > HEIGHT - imageView.getBoundsInParent().getHeight()) {
                                    dy = -dy;
                                }
                            }
                        }.start();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
