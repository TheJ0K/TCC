/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Main.MDataCompany;
import Main.MDataPerson;
import Main.MGraphicCompany;
import Main.MGraphicCompanyPerson;
import Main.MGraphicPerson;
import Main.MLogin;
import Main.MMain;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Diogo Fistarol
 */
public class MainController implements Initializable {

    @FXML
    void gcomp() {
        MGraphicCompany gc = new MGraphicCompany();
        try {
            gc.start(new Stage());
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void gdeve() {
        MGraphicPerson gd = new MGraphicPerson();
        try {
            gd.start(new Stage());
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void gdevcom() {
        MGraphicCompanyPerson gcp = new MGraphicCompanyPerson();
        try {
            gcp.start(new Stage());
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void dcomp() {
        MDataCompany dc = new MDataCompany();
        try {
            dc.start(new Stage());
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void ddeve() {
        MDataPerson dd = new MDataPerson();
        try {
            dd.start(new Stage());
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void back() {
        MLogin logout = new MLogin();
        try {
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
            confirm.setTitle("Exit confirmation");
            confirm.setHeaderText("You really want to logout?");
            Optional<ButtonType> bt = confirm.showAndWait();
            if (bt.get() == ButtonType.OK) {
                logout.start(new Stage());
                close();
            } else {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void close() {
        MMain.getStage().close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
