package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class OtherLabs {
    @FXML
    private ImageView imageView;

    @FXML
    private Button btnYes;

    @FXML
    private Label btnLabel3;

    Image image = new Image(getClass().getResourceAsStream("fotok.jpg"));



    @FXML
    void changeLabel(ActionEvent event) {
        imageView.setImage(image);
        btnLabel3.setText("Ви успішно змінили картинку");
        btnYes.setDisable(true);

    }

}
