/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Main.MDataPerson;
import Main.MEditPerson;
import Main.MInsertPerson;
import Main.MMain;
import Model.Developer;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Diogo Fistarol
 */
public class DataPersonController implements Initializable {

    @FXML
    private TableView<Developer> tableview;

    @FXML
    private TableColumn<Developer, String> nome;
    @FXML
    private TableColumn<Developer, String> lastname;
    @FXML
    private TableColumn<Developer, String> cpf;
    @FXML
    private TableColumn<Developer, String> age;
    @FXML
    private TableColumn<Developer, String> email;
    @FXML
    private TableColumn<Developer, String> city;
    @FXML
    private TableColumn<Developer, String> state;
    @FXML
    private TableColumn<Developer, String> landline;
    @FXML
    private TableColumn<Developer, String> mobile;

    @FXML
    void insdev() {
        MInsertPerson ip = new MInsertPerson();
        try {
            ip.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*void startTable() {
        try {
            nome.setCellValueFactory(new PropertyValueFactory();
        } catch (Exception e) {
        }
    }*/

    @FXML
    void editdev() {
        MEditPerson ep = new MEditPerson();
        try {
            ep.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void back() {
        MMain main = new MMain();
        try {
            main.start(new Stage());
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void close() {
        MDataPerson.getStage().close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
