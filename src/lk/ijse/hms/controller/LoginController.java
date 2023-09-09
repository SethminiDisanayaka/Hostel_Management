package lk.ijse.hms.controller;

import animatefx.animation.FadeIn;
import animatefx.animation.Shake;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hms.bo.BOFactory;
import lk.ijse.hms.bo.custom.UserBO;
import lk.ijse.hms.util.Navigation;
import lk.ijse.hms.util.Routes;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import javax.swing.text.html.ImageView;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class LoginController {

    @FXML
    private ImageView imgPasswordView;

    @FXML
    private AnchorPane pane;

    @FXML
    private Label shownPassword;

    @FXML
    private ToggleButton toggleButton;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserName;

    UserBO userBO =(UserBO) BOFactory.getBoFactory().getBO(BOFactory.Type.USER);
    @FXML
    void forgotClickOnAction(ActionEvent event) {
        new Alert(Alert.AlertType.INFORMATION,"Please contact Developer !\n0740113917").show();
    }

    @FXML
        void loginClickOnAction(javafx.event.ActionEvent event) throws IOException {
        Shake shakeUserName = new Shake(txtUserName);
        Shake shakePassword = new Shake(txtPassword);

            if( isCorrectPassword() && isCorrectUserName()){
                Navigation.navigate(Routes.DASHBOARD, pane);
                new FadeIn(pane).setSpeed(3).play();

            }else if (isCorrectPassword() && !isCorrectUserName()) {
                txtUserName.requestFocus();
                shakeUserName.play();
            } else if (!isCorrectPassword() && isCorrectUserName()) {
                txtPassword.requestFocus();
                shakePassword.play();
            } else{
                new Alert(Alert.AlertType.ERROR,"Try again !").show();
                txtUserName.clear();
                txtPassword.clear();
            }
    }

    @FXML
    void passwordFieldKeyTyped(ActionEvent event) {
        shownPassword.textProperty().bind(Bindings.concat(txtPassword.getText()));
    }

    private boolean isCorrectUserName() {
        String user = userBO.getUser("1");
        if(user == null){
            new Alert(Alert.AlertType.ERROR," Database Error !").show();
            return false;
        }
        return txtUserName.getText().equals(user);
    }

    private boolean isCorrectPassword() {
        String password = userBO.getPassword("1");
        if(password == null){
            new Alert(Alert.AlertType.ERROR," Database Error !").show();
            return false;
        }
        return txtPassword.getText().equals(password);
    }

    public void toggleButton(javafx.event.ActionEvent actionEvent) {
        if (toggleButton.isSelected()) {
            shownPassword.setVisible(true);
            shownPassword.textProperty().bind(Bindings.concat(txtPassword.getText()));
            toggleButton.setText("Hide");

        }else{
            shownPassword.setVisible(false);
            txtPassword.setVisible(true);
            toggleButton.setText("Show");
        }
    }
}