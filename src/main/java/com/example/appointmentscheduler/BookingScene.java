package com.example.appointmentscheduler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

public class BookingScene {

    private LocalDate date = LocalDate.now();
    private DayOfWeek day = date.getDayOfWeek();
    private Scene scene;
    private Button b;
    private boolean dayAssigned = false;
    private VBox timeList = new VBox(2);
    private int buttonCounter = 0;
    private ScrollPane scrollPane;
    private static ArrayList<Booking> bookings = new ArrayList<>();
    private static ArrayList<Integer> times = new ArrayList<>();
    private boolean profile = false;

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

                final int capturedDay = i;


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
                                        times.add(capturedHour*60 + capturedMinute);
                                        System.out.println(bookings);
                                        TextField txField = new TextField();

                                    });

                                    timeList.getChildren().add(timeSlot);
                                }
                            }

                            scrollPane = new ScrollPane(timeList);

                            Button submit = new Button("Submit");

                            submit.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent actionEvent) {
                                    bookings.add(new Booking(capturedDay, times.get(0), times.getLast(), ""));
                                    gp.getChildren().remove(scrollPane);
                                    timeList.getChildren().clear();
                                    for(Booking b : bookings) System.out.println(b.toString());
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
        Button b = new Button();
        b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                profile = true;
            }
        });

        VBox box = new VBox(label1, gp, b);

        scene = new Scene(box, 500, 750);



    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public Button getB() {
        return b;
    }

    public void setB(Button b) {
        this.b = b;
    }

    public boolean isDayAssigned() {
        return dayAssigned;
    }

    public void setDayAssigned(boolean dayAssigned) {
        this.dayAssigned = dayAssigned;
    }

    public VBox getTimeList() {
        return timeList;
    }

    public void setTimeList(VBox timeList) {
        this.timeList = timeList;
    }

    public int getButtonCounter() {
        return buttonCounter;
    }

    public void setButtonCounter(int buttonCounter) {
        this.buttonCounter = buttonCounter;
    }

    public ScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(ScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public static ArrayList<Booking> getBookings() {
        return bookings;
    }

    public static void setBookings(ArrayList<Booking> bookings) {
        BookingScene.bookings = bookings;
    }

    public static ArrayList<Integer> getTimes() {
        return times;
    }

    public static void setTimes(ArrayList<Integer> times) {
        BookingScene.times = times;
    }

    public boolean isProfile() {
        return profile;
    }

    public void setProfile(boolean profile) {
        this.profile = profile;
    }
}
