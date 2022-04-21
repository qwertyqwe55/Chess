package com.example.chessgame.chessfigures;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Rook extends ChessPiece{
    public Rook(Pane pane) throws FileNotFoundException {
        FileInputStream input = new FileInputStream("src\\main\\images\\ladia.jpg");
        turns = new ArrayList<>();
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

        for (int i = k+1; i <= 8; i++){
            turns.add(String.valueOf(turn[0] ) + i);
        }
        for (int i = k+1; i >= 1; i--){
            turns.add(String.valueOf(turn[0] ) + i);
        }

        for (int i = k+1; i <= 8; i++){
            turns.add(String.valueOf(turn[0] ) + i);
        }

        for (int i = getIndex(String.valueOf(turn[0])); i < abc.length; i++){
            turns.add(String.valueOf(abc[i] + k));
        }
        for (int i = getIndex(String.valueOf(turn[0])); i >= 0; i--){
            turns.add(String.valueOf(abc[i] + k));
        }
    }
}