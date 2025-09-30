package com.example.appointmentscheduler;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

import java.util.ArrayList;

public class ProfileScene{
    Scene scene;
    private ArrayList<Booking> bookings = new ArrayList<>();

    public ProfileScene(){
        Label title = new Label("Profile page");
        FlowPane fp = new FlowPane(title);

        scene = new Scene(fp, 500, 750  );


    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
