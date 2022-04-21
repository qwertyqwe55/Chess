package com.example.chessgame.chessfigures;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


public class Hourse extends ChessPiece{

    public Hourse(Pane pane) throws FileNotFoundException {
        FileInputStream input = new FileInputStream("src\\main\\images\\hours.jpg");
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

        if(k+2 <8 && getIndex(String.valueOf(turn[0]))+1 < abc.length)
            turns.add(String.valueOf((abc[getIndex(String.valueOf(turn[0])) + 1] + (k+2))));

        if(k-2 < 8 && getIndex(String.valueOf(turn[0]))+1 < abc.length)
            turns.add(String.valueOf((abc[getIndex(String.valueOf(turn[0])) + 1] + (k))));

        if(k+1 <8 && getIndex(String.valueOf(turn[0]))+2 < abc.length)
            turns.add(String.valueOf((abc[getIndex(String.valueOf(turn[0]))+2] + (k+1))));


        if(k+1 >= 1 && getIndex(String.valueOf(turn[0]))-2 >= 0)
            turns.add(String.valueOf((abc[getIndex(String.valueOf(turn[0])) - 2] + (k-1))));

        if(k-1 >= 1 && getIndex(String.valueOf(turn[0]))+2 >= 0)
            turns.add(String.valueOf((abc[getIndex(String.valueOf(turn[0])) + 2] + (k-1))));

        if(k-1 >= 1 && getIndex(String.valueOf(turn[0])) - 2 >= 0)
            turns.add(String.valueOf((abc[getIndex(String.valueOf(turn[0]))-2] + (k-1))));

        if(k+2 >= 1 && getIndex(String.valueOf(turn[0]))-1 >= 0)
            turns.add(String.valueOf((abc[getIndex(String.valueOf(turn[0])) - 1] + (k+2))));

        if(k-2 >= 1 && getIndex(String.valueOf(turn[0]))-1 >= 0)
            turns.add(String.valueOf((abc[getIndex(String.valueOf(turn[0]) ) - 1] + (k-2))));
    }
}