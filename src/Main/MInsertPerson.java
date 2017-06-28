/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Diogo Fistarol
 */
public class MInsertPerson extends Application {

    private static Stage stage;

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage aStage) {
        stage = aStage;
    }

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/InsertPerson.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Insert Person");
        stage.setScene(scene);
        stage.show();
        stage.getIcons().add(new Image("/Image/icon2.png"));
        setStage(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
