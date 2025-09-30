package com.example.appointmentscheduler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

import java.util.HashMap;

public class StartScene {
    private Scene scene;
    private HashMap<String, String> creds = new HashMap<String, String>();
    private String usename = "";
    private String password = "";
    private boolean loggedIn = false;

    public StartScene(){
        creds.put("123", "123");
        Label label1 = new Label("Please log in");
        Label usrname = new Label("Username : ");
        Label passwrd = new Label("Password : ");
        TextField usrnameField = new TextField();
        TextField passwrdField = new TextField();

        HBox hbUsrname = new HBox();
        HBox hbPasswrd = new HBox();

        hbUsrname.getChildren().addAll(usrname, usrnameField);
        hbPasswrd.getChildren().addAll(passwrd, passwrdField);
        hbUsrname.setSpacing(20);
        hbPasswrd.setSpacing(20);

        Button submit = new Button("Submit");
        Button clear = new Button("Clear");

        //-SUBMIT LOGIN DATA--------------------------------------------------------------------------------------------

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if ((usrnameField.getText() != null && !passwrdField.getText().isEmpty())) {
                    usename = usrnameField.getText();
                    password = passwrdField.getText();
                } else {
                    //Error message to user
                }
                for(int i = 0; i < creds.size(); i++){
                    if(creds.get(usename) != null){
                        loggedIn = true;
                    }
                }
                System.out.println(usename + password);
            }
        });

        //-CLEAR THE BOXES----------------------------------------------------------------------------------------------

        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                usrnameField.setText("");
                passwrdField.setText("");
            }
        });

        //-LOOP TO CHECK FOR CREDENTIALS--------------------------------------------------------------------------------



        //-PACK EVERYTHING UP-------------------------------------------------------------------------------------------

        FlowPane paneTop = new FlowPane(label1, hbUsrname, hbPasswrd, submit, clear);
        scene = new Scene(paneTop, 500, 750);
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public HashMap<String, String> getCreds() {
        return creds;
    }

    public void setCreds(HashMap<String, String> creds) {
        this.creds = creds;
    }

    public String getUsename() {
        return usename;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}
