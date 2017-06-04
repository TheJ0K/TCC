/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Main.MLogin;
import Main.MMain;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Diogo Fistarol
 */
public class LoginController implements Initializable {

    @FXML
    private PasswordField pf;

    @FXML
    void logar() {
        if (pf.getText().equals("2209")) {
            MMain logar = new MMain();
            try {
                logar.start(new Stage());
                close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("A senha informada esta incorreta!");
            a.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    void close() {
        MLogin.getStage().close();
    }
}
