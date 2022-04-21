package com.example.chessgame.chessfigures;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ChessPiece {
    protected Image image;
    protected ImageView imageView;
    protected List<String> turns = new ArrayList<>();
    protected String position = "d5";
    protected String[] abc = {"a","b","c","d","e","f","g","h"};


    public ChessPiece() {
    }





    public ChessPiece(Pane pane) throws FileNotFoundException {
        FileInputStream input = new FileInputStream("src\\main\\images\\fersi.jpg");
        image = new Image(input);
        imageView = new ImageView(image);
        imageView.setFitWidth(90);
        imageView.setFitHeight(90);
        imageView.setX(310);
        imageView.setY(310);
        setTurns();
        pane.getChildren().add(imageView);
    }

    protected boolean checkPosition(String new_position){
        for (String turn : turns){
            if(turn.equals(new_position)){
                return true;
            }
        }
        return false;
    }

    public void setNewPosition(String s){
        if(checkPosition(s)){
            char[] turn = s.toCharArray();
            position = s;
            turns.clear();
            imageView.setX((getIndex(String.valueOf(turn[0]))) * 100 + (45-10*(getIndex(String.valueOf(turn[0])) + 1)));
            imageView.setY((8 - (turn[1] - '0')) * 100  + (40 - 10*(8 - (turn[1] - '0'))));
            setTurns();
        }else if(s.equals("info")) {
            for (String turn : turns){
                System.out.println(turn);
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error input data");
            alert.showAndWait();
        }
    }

    protected int getIndex(String  b){
        for (int i = 0; i < abc.length; i++) {
            if(b.equals(abc[i])){
                return i;
            }
        }
        return Integer.parseInt(b);
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
