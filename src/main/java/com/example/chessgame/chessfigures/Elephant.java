package com.example.chessgame.chessfigures;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Elephant extends ChessPiece {
    public Elephant(Pane pane) throws FileNotFoundException {
        FileInputStream input = new FileInputStream("src\\main\\images\\elephant.jpg");
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
        int x = k - 1;
        int y = getIndex(String.valueOf(turn[0])) -1;
        while(1 <= x  && y >= 0){
            turns.add(abc[y] + x);
            x--;
            y--;
        }

        x = k +1;
        y = getIndex(String.valueOf(turn[0])) + 1;
        while(8 >= x && y < abc.length){
            turns.add(abc[y] + x);
            x++;
            y++;
        }

        x = k + 1;
        y = getIndex(String.valueOf(turn[0])) - 1;
        while( x >= 1 && y >= 0){
            turns.add(abc[y] + x);
            x++;
            y--;
        }

        x = k - 1;
        y = getIndex(String.valueOf(turn[0])) + 1;
        while(8 >= x && y < abc.length){
            turns.add(abc[y] + x);
            x--;
            y++;
        }
    }
}