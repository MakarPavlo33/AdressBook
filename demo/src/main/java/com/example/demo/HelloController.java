package com.example.demo;

import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TableColumn<Person, String> columnPIP;

    @FXML
    private TableColumn<Person, String> columnPhone;



    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private Button btnOther;
    @FXML
    private Label totalAmount;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDel;

    @FXML
    private Button btnRed;

    @FXML
    private Button btnSearch;

    @FXML
    private TextField textField;
    @FXML
    private Label myLabel;

    private CollectionAddressBook addressBookImpl = new CollectionAddressBook();
    @FXML
    private TableView<Person> tableAdressBook;
    Controller1 editController;

    @FXML
    void buttonOther(ActionEvent event) {

    }


    @FXML
    void Searching(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnPIP.setCellValueFactory(new PropertyValueFactory<Person, String>("pip"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<Person, String>("phone"));

        addressBookImpl.fillTestData();

        tableAdressBook.setItems(addressBookImpl.getPersonList());
        System.out.println(addressBookImpl.getPersonList().size());
        addressBookImpl.getPersonList().addListener(new ListChangeListener<Person>() {
            @Override
            public void onChanged(Change<? extends Person> change) {
                totalAmount.setText(String.valueOf(addressBookImpl.getPersonList().size()));
                myLabel.setText("Kibfx" + addressBookImpl.getPersonList().size());
            }
        });



        assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnDel != null : "fx:id=\"btnDel\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnRed != null : "fx:id=\"btnRed\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnSearch != null : "fx:id=\"btnSearch\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert textField != null : "fx:id=\"textField\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert totalAmount != null : "fx:id=\"totalAmount\" was not injected: check your FXML file 'hello-view.fxml'.";
        btnOther.setOnAction(acionEvent ->{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("otherLabs.fxml"));
            Stage stage = new Stage();
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(),600,600);
            } catch (IOException e){
                e.printStackTrace();
            }
            stage.setTitle("Інші практичні");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        });
    }

    private void updateCountLabel(){

    }

    void showDialog(){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("1.fxml"));

        try {
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(),400,150);
            stage.setScene(scene);

            stage.setTitle("Редагування");
            stage.setMinHeight(150);
            stage.setMaxWidth(400);
            stage.setResizable(false);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(btnAdd.getScene().getWindow());

            editController=fxmlLoader.getController();

            stage.show();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    @FXML
    void opemWindow(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        switch (clickedButton.getId()) {
            case "btnAdd":
                showDialog();
                editController.setPerson(new Person());
                addressBookImpl.add(editController.getPerson());
                break;
            case "btnRed":

                showDialog();
                editController.setPerson((Person) tableAdressBook.getSelectionModel().getSelectedItem());

                break;
            case "btnDel":
                addressBookImpl.delete((Person) tableAdressBook.getSelectionModel().getSelectedItem());
                break;
        }
    }

    @FXML
    void new_Alert(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Видалення");

        alert.setHeaderText("Results");
        alert.setContentText("Ви успішно видалили запис!");

        alert.showAndWait();
    }


}