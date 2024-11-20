package com.example.demo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller1 {
    Person person;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnExit;

    @FXML
    private Button btnOk;

    @FXML
    private TextField texAreaPhone;

    @FXML
    private TextField textAreaPip;


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
        texAreaPhone.setText(person.getPip());
        textAreaPip.setText(person.getPhone());

    }

    @FXML
    void eding(ActionEvent event) {
        person.setPip(textAreaPip.getText());
        person.setPhone(texAreaPhone.getText());
        exit(event);

    }

    @FXML
    void exit(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }

    @FXML
    void initialize() {
        assert btnExit != null : "fx:id=\"btnExit\" was not injected: check your FXML file '1.fxml'.";
        assert btnOk != null : "fx:id=\"btnOk\" was not injected: check your FXML file '1.fxml'.";
        assert texAreaPhone != null : "fx:id=\"texAreaPhone\" was not injected: check your FXML file '1.fxml'.";
        assert textAreaPip != null : "fx:id=\"textAreaPip\" was not injected: check your FXML file '1.fxml'.";

    }

}
