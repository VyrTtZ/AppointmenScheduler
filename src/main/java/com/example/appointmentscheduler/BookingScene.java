package com.example.appointmentscheduler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class BookingScene {
    LocalDate date = LocalDate.now();
    DayOfWeek day = date.getDayOfWeek();
    Scene scene;
    Button b;
    boolean dayAssigned = false;

    public BookingScene(){
        System.out.println(date.toString());
        System.out.println(day);
        Label label1 = new Label("Booking");
        GridPane gp = new GridPane();
        gp.add(label1, 0, 0);
        for(int i = 0; i < 5; i++)
            for(int j = 0; j < 4; j++){
                if(day == DayOfWeek.of(i+1) && !dayAssigned){
                    b = new Button("Day");
                    b.setStyle("-fx-background-color: #333333;");
                    gp.add(b, i, j);
                    dayAssigned = true;
                } else{
                    b = new Button("Day");
                    gp.add(b, i, j);
                }
                b.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        VBox timeList = new VBox(2);

                        // Generate time slots (every 30 minutes)
                        for (int hour = 8; hour < 17; hour++) {
                            for (int minute = 0; minute < 60; minute += 30) {
                                String time = hour + " : " + minute;
                                Label timeSlot = new Label(time);
                                timeSlot.setStyle("-fx-padding: 10; -fx-border-color: lightgray;");

                                timeSlot.setOnMouseClicked(e -> {
                                    timeSlot.setStyle(" -fx-background-color: green;");
                                });

                                timeList.getChildren().add(timeSlot);
                            }
                        }

                        ScrollPane scrollPane = new ScrollPane(timeList);
                        scrollPane.setFitToWidth(true);

                        Button submit = new Button("Submit");


                        // Width x Height
                        gp.add(scrollPane, 30, 30);

                    }
                });
            }
        scene = new Scene(gp, 500, 750);
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
