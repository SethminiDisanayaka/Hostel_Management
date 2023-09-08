package lk.ijse.hms.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class ReservationController {

    @FXML
    private ToggleGroup FilterPayment;

    @FXML
    private ToggleGroup PaymentStatus;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnNew;

    @FXML
    private Button btnReserve;

    @FXML
    private TableColumn<?, ?> colKeyMoney;

    @FXML
    private TableColumn<?, ?> colKeyMoneyRes;

    @FXML
    private TableColumn<?, ?> colPaymentStatus;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colResDate;

    @FXML
    private TableColumn<?, ?> colResID;

    @FXML
    private TableColumn<?, ?> colRoomTypeID;

    @FXML
    private TableColumn<?, ?> colRoomTypeIDRes;

    @FXML
    private TableColumn<?, ?> colRoomTypeRes;

    @FXML
    private TableColumn<?, ?> colStdID;

    @FXML
    private TableColumn<?, ?> colStdName;

    @FXML
    private TableColumn<?, ?> colStdNameRes;

    @FXML
    private TableColumn<?, ?> colStudentIDRes;

    @FXML
    private TableColumn<?, ?> colType;

    @FXML
    private DatePicker dateDate;

    @FXML
    private AnchorPane newReservationPane;

    @FXML
    private RadioButton rbAll;

    @FXML
    private RadioButton rbPaid;

    @FXML
    private RadioButton rbPaid1;

    @FXML
    private RadioButton rbPending;

    @FXML
    private RadioButton rbPending1;

    @FXML
    private AnchorPane reservationDetailsPane;

    @FXML
    private TableView<?> tblReservation;

    @FXML
    private TableView<?> tblRooms;

    @FXML
    private TableView<?> tblStudent;

    @FXML
    private TextField txtResID;

    @FXML
    private TextField txtRoomID;

    @FXML
    private TextField txtSearchReservation;

    @FXML
    private TextField txtSearchRoom;

    @FXML
    private TextField txtSearchStudent;

    @FXML
    private TextField txtStudentID;

    @FXML
    void btnCancelOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnEditOnAction(ActionEvent event) {

    }

    @FXML
    void btnNewOnAction(ActionEvent event) {

    }

    @FXML
    void btnReserveOnAction(ActionEvent event) {

    }

}
