package lk.ijse.pharmacy;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class AppInitializer extends Application {

    private double x = 0;
    private double y = 0;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        /*primaryStage.setScene(new Scene(FXMLLoader.load(
                getClass().getResource("/lk/ijse/pharmacy/view/DashboardForm.fxml"))));*/

        primaryStage.getIcons().add(new Image(
                Objects.requireNonNull(getClass().getResourceAsStream(
                        "/lk/ijse/pharmacy/assets/icons/pharmacyicon.png"))));
        primaryStage.setTitle("Pharmacy System");

        Parent root = FXMLLoader.load(
                getClass().getResource("/lk/ijse/pharmacy/view/LoginForm.fxml"));
        Scene scene = new Scene(root);

        root.setOnMousePressed((MouseEvent event) ->{
        x=event.getSceneX();
        y=event.getSceneY();

    });

        root.setOnMouseDragged((MouseEvent event) ->{
            primaryStage.setX(event.getScreenX() - x);
            primaryStage.setY(event.getScreenY() - y);
            primaryStage.setOpacity(.8);
        });

        root.setOnMouseReleased((MouseEvent event) ->{

            primaryStage.setOpacity(1);
        });
        primaryStage.initStyle(StageStyle.TRANSPARENT);

        primaryStage.setScene(scene);

        primaryStage.show();

    }
}
