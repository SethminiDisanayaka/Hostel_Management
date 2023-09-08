package lk.ijse.hms;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppInitializer extends Application {

    public void start(Stage primaryStage) throws IOException {
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/resources/view/Reservation.fxml"))));
        primaryStage.show();
        primaryStage.setResizable(false);
        primaryStage.setY(0);
        primaryStage.setTitle("24D Hostel Management System | Login");
    }
}
