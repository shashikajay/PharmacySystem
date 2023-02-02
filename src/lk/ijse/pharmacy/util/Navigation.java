package lk.ijse.pharmacy.util;

/*
    @author Akash Jayawardena
    @created 11/1/22 - 1:27 PM   
*/

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class Navigation {
    private static AnchorPane pane;
    public static void navigate(Routes route, AnchorPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage) Navigation.pane.getScene().getWindow();

        switch (route) {
            case CUSTOMER:
                window.setTitle("Customer Manage Form");
                setUi("CustomerForm.fxml");
                break;
            case PLACE_ORDER:
                window.setTitle("Place Order Form");
                setUi("PlaceOrderForm.fxml");
                break;
            case DASHBOARD:
                window.setTitle("DashBoard Form");
                setUi("DashboardForm.fxml");
                break;
            case LOGIN:

            default:
                new Alert(Alert.AlertType.ERROR, "Not suitable UI found!").show();
        }
    }
    private static void setUi(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class
                        .getResource("/lk/ijse/thogakade/view/" + location)));
    }
}
