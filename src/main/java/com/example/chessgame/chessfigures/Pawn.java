package com.example.chessgame.chessfigures;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Pawn extends ChessPiece{
    public Pawn(Pane pane) throws FileNotFoundException {
        FileInputStream input = new FileInputStream("src\\main\\images\\pechka.png");
        image = new Image(input);
        imageView = new ImageView(image);
        imageView.setFitWidth(90);
        imageView.setFitHeight(90);
        imageView.setX(310);
        imageView.setY(310);

        setTurns();
        pane.getChildren().add(imageView);
    }

    public void setTurns(){
        char[] turn = position.toCharArray();
        int k = turn[1]-'0';
        if(getIndex(String.valueOf(turn[0])) < abc.length && k < 8)
            turns.add(getIndex(String.valueOf(turn[0])) + String.valueOf((k + 1)));
    }
}