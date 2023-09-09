package lk.ijse.hms.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hms.util.Navigation;
import lk.ijse.hms.util.Routes;

import java.io.IOException;

public class DashboardController {

    @FXML
    public AnchorPane pane;

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.LOGIN,pane);
    }

    @FXML
    void btnReservationClickOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.RESERVATION,pane);
    }

    @FXML
    void btnRoomsClickOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.ROOMS,pane);
    }

    @FXML
    void btnSettingsClickOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.CHANGE_PASSWORD,pane);
    }

    @FXML
    void btnStudentClickOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.STUDENT,pane);
    }

}
