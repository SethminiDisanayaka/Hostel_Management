package lk.ijse.hms.controller;

import animatefx.animation.Shake;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hms.bo.BOFactory;
import lk.ijse.hms.bo.custom.UserBO;
import lk.ijse.hms.util.Navigation;
import lk.ijse.hms.util.Routes;

import java.io.IOException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChangePasswordFormController {

    @FXML
     private AnchorPane pane;
    @FXML
    private Button btnconfirm;

    @FXML
    private AnchorPane changePane;

    @FXML
    private AnchorPane confirmPane;

    @FXML
    private TextField currentPassword;

    @FXML
    private TextField currentUsername;

    @FXML
    private ImageView imgPasswordView;

    @FXML
    private TextField newPassword;

    @FXML
    private TextField newUsername;

    @FXML
    private Label shownPassword;

    @FXML
    private ToggleButton toggleButton;

    UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.Type.USER);

    public void initialize() {
        changePane.toBack();
        confirmPane.toFront();

        shownPassword.setVisible(false);
    }
    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        if (pane != null) {
            Navigation.navigate(Routes.DASHBOARD, pane);
        } else {
            System.out.println("Error: Pane is null");
        }
    }

    @FXML
    void changeClickOnAction(ActionEvent event) throws IOException {
        String newUserName = newUsername.getText();
        String newPw = newPassword.getText();

        if (isValidUserName() && isValidPassword()) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Confirm Update ?", ButtonType.YES, ButtonType.NO);
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.YES) {

                boolean isUpdated = userBO.updateUser_Pw(newUserName, newPw);

                if (isUpdated) {
                    new Alert(Alert.AlertType.INFORMATION, " Changes Saved !").show();

                    changePane.toBack();
                    confirmPane.toFront();

                    newUsername.clear();
                    newPassword.clear();

                    Navigation.navigate(Routes.DASHBOARD, pane);

                } else {
                    new Alert(Alert.AlertType.ERROR, "Wrong Inputs \nTry again !").show();
                }
            } else {
                changePane.toFront();
                confirmPane.toBack();
            }
        }
    }

    @FXML
    void confirmClickOnAction(ActionEvent event) {
        Shake shakeUserName = new Shake(currentUsername);
        Shake shakePassword = new Shake(currentPassword);

        if (isCorrectUserName() && isCorrectPassword()) {
            changePane.toFront();
            confirmPane.toBack();

            currentPassword.clear();
            currentUsername.clear();

        } else {
            if (!isCorrectUserName()) {
                shakeUserName.play();
                currentUsername.requestFocus();
            }
            if (!isCorrectPassword()) {
                shakePassword.play();
                currentPassword.requestFocus();
            }
        }
    }
    private boolean isCorrectUserName() {
        String user = userBO.getUser("1");
        if (user == null) {
            new Alert(Alert.AlertType.ERROR, " Database Error !").show();
            return false;
        }
        return currentUsername.getText().equals(user);
    }

    private boolean isCorrectPassword() {
        String password = userBO.getPassword("1");
        if (password == null) {
            new Alert(Alert.AlertType.ERROR, " Database Error !").show();
            return false;
        }
        return currentPassword.getText().equals(password);
    }

    @FXML
    void toggleButton(ActionEvent event) {
        if (toggleButton.isSelected()) {
            shownPassword.setVisible(true);
            shownPassword.textProperty().bind(Bindings.concat(newPassword.getText()));
            toggleButton.setText("Hide");
            imgPasswordView.setImage(new Image("resources/img/eye-close.png"));
        } else {
            shownPassword.setVisible(false);
            newPassword.setVisible(true);
            toggleButton.setText("Show");
            imgPasswordView.setImage(new Image("resources/img/eye-open.png"));
        }
    }

    @FXML
    public void passwordFieldKeyTyped(ActionEvent actionEvent) {
        shownPassword.textProperty().bind(Bindings.concat(newPassword.getText()));
    }
    private boolean isValidUserName() {
        Pattern userNamePattern = Pattern.compile("^[a-zA-Z]{4,}$");
        Matcher userNameMatcher = userNamePattern.matcher(newUsername.getText());

        boolean userNameIsMatches = userNameMatcher.matches();
        if (userNameIsMatches) {
            return true;
        } else {
            Shake shakeUserName = new Shake(newUsername);
            newUsername.requestFocus();
            shakeUserName.play();
            return false;
        }
    }

    private boolean isValidPassword() {
        Pattern passwordPattern = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$");
        Matcher passwordMatcher = passwordPattern.matcher(newPassword.getText());

        boolean passwordIsMatches = passwordMatcher.matches();
        if (passwordIsMatches) {
            return true;
        } else {
            Shake shakePW = new Shake(newPassword);
            newPassword.requestFocus();
            shakePW.play();
            return false;
        }
    }
}
