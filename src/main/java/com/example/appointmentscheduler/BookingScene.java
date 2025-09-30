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
import java.util.ArrayList;

public class BookingScene {

    LocalDate date = LocalDate.now();
    DayOfWeek day = date.getDayOfWeek();
    Scene scene;
    Button b;
    boolean dayAssigned = false;
    VBox timeList = new VBox(2);
    int buttonCounter = 0;
    ScrollPane scrollPane;
    private static ArrayList<Booking> bookings = new ArrayList<>();

    public BookingScene() {
        System.out.println(date.toString());
        System.out.println(day);

        Label label1 = new Label("Booking");

        GridPane gp = new GridPane();
        gp.add(label1, 0, 0);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {

                if (day == DayOfWeek.of(i + 1) && !dayAssigned) {
                    b = new Button("Day");
                    gp.add(b, i, j);
                    dayAssigned = true;
                } else {
                    b = new Button("Bee");
                    gp.add(b, i, j);
                }

                b.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {

                        if(buttonCounter%2 == 0){
                            // Generate time slots (every 30 minutes)
                            for (int hour = 8; hour < 17; hour++) {
                                for (int minute = 0; minute < 60; minute += 30) {
                                    String time = hour + ":" + minute;
                                    Label timeSlot = new Label(time);

                                    final int capturedHour = hour;
                                    final int capturedMinute = minute;

                                    timeSlot.setOnMouseClicked(e -> {
                                        timeSlot.setStyle("-fx-background-color: green;");
                                        System.out.println(bookings);
                                    });

                                    timeList.getChildren().add(timeSlot);
                                }
                            }

                            scrollPane = new ScrollPane(timeList);

                            Button submit = new Button("Submit");

                            submit.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent actionEvent) {
                                    gp.getChildren().remove(scrollPane);
                                    timeList.getChildren().clear();
                                }
                            });

                            // Add scroll pane to grid
                            gp.add(scrollPane, 20, 0);
                            gp.add(submit, 40, 0);
                        }else{
                            gp.getChildren().remove(scrollPane);
                            timeList.getChildren().clear();
                        }

                        buttonCounter++;


                    }
                });
            }
        }

        VBox box = new VBox(label1, gp);

        scene = new Scene(box, 500, 750);
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
