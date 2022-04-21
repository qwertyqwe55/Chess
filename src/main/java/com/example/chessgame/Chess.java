package com.example.chessgame;

import com.example.chessgame.chessfigures.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;

public class Chess extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Pane pane = new Pane();
        FileInputStream inputStream = new FileInputStream("src\\main\\images\\chess.jpg");
        Image image = new Image(inputStream);


        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(800);
        imageView.setFitWidth(800);

        Scene scene = new Scene(pane,800,800);
        pane.getChildren().add(imageView);
        stage.setTitle("Hello!");


        stage.setScene(scene);
        stage.show();
        TextInputDialog dialog1 = new TextInputDialog("Figure");
        dialog1.setHeaderText("Write info for watch possible figure(turns in console)");
        dialog1.setContentText("Write figure");
        Optional<String> result = dialog1.showAndWait();
        ChessPiece piece = new ChessPiece();
            if (result.get().equals("King")) {
                 piece = new King(pane);
            } else if (result.get().equals("Hourse")) {
                 piece = new Hourse(pane);
            } else if (result.get().equals("Piece")) {
                piece = new ChessPiece();
            } else if (result.get().equals("Rook")) {
                piece = new Rook(pane);
            } else if (result.get().equals("Pawn")) {
                piece = new Pawn(pane);
            } else if (result.get().equals("Elephant")) {
               piece = new Elephant(pane);
            }else {
                System.out.println("King Hourse Piece Rook Pawn Elephant");
            }


        while(true){
            TextInputDialog dialog = new TextInputDialog("Position");
            dialog.setHeaderText("Write info for watch possible turns(turns in console)");
            dialog.setContentText("Write next position");
            Optional<String> result1 = dialog.showAndWait();
            if (result1.isPresent()){
                piece.setNewPosition(result1.get());
            }
        }

    }





    public static void main(String[] args) {
        launch();
    }
}