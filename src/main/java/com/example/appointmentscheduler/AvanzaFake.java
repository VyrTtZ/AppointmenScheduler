package com.example.appointmentscheduler;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javafx.stage.Stage;
import java.io.IOException;

//-START----------------------------------------------------------------------------------------------------------------

public class AvanzaFake extends Application {
    StartScene startScene = new StartScene();
    BookingScene bookingScene = new BookingScene();
    ProfileScene profileScene = new ProfileScene();


    //-SET UP STATIC CONTENT ON THE SCENE-------------------------------------------------------------------------------
    @Override
    public void start(Stage stage) throws IOException {

        stage.setScene(startScene.getScene());
        stage.setTitle("Avanza");
        stage.show();

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.5), e -> {
            if (startScene.isLoggedIn()) {
                stage.setScene(bookingScene.getScene());
            }
            System.out.println(startScene.isLoggedIn());
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}
