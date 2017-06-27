/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAL.DAL;
import Main.MDataCompany;
import Main.MEditCompany;
import Main.MInsertCompany;
import Main.MMain;
import Model.City;
import Model.Company;
import Model.LegalPerson;
import Model.Phone;
import Model.Photo;
import Model.State;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Diogo Fistarol
 */
public class DataCompanyController implements Initializable {

    @FXML
    private TextArea taDescription;

    @FXML
    private TextField tfSearch;

    @FXML
    private ImageView imageFace, imageCover;

    @FXML
    private TableView<LegalPerson> tvCompany;
    @FXML
    private TableColumn<LegalPerson, String> tcName;
    @FXML
    private TableColumn<LegalPerson, String> tcLastname;
    @FXML
    private TableColumn<LegalPerson, Company> tcCompany;
    @FXML
    private TableColumn<LegalPerson, String> tcEmail;
    @FXML
    private TableColumn<LegalPerson, State> tcState;
    @FXML
    private TableColumn<LegalPerson, City> tcCity;
    @FXML
    private TableColumn<LegalPerson, Phone> tcLandline;
    @FXML
    private TableColumn<LegalPerson, Phone> tcMobile;
    @FXML
    private TableColumn<LegalPerson, Company> tcCnpj;

    private LegalPerson lp;
    private Company comp;
    private Phone phone;
    private Photo photo;
    private State state;
    private City city;
    
    private ObservableList<LegalPerson> company_oblist;

    @FXML
    void table() {
        DAL dal = new DAL();

        tcName.setCellValueFactory(new PropertyValueFactory("name"));
        tcLastname.setCellValueFactory(new PropertyValueFactory("lastname"));
        tcCompany.setCellValueFactory(new PropertyValueFactory("company"));
        tcEmail.setCellValueFactory(new PropertyValueFactory("email"));
        tcState.setCellValueFactory(new PropertyValueFactory("state"));
        tcCity.setCellValueFactory(new PropertyValueFactory("city"));
        tcLandline.setCellValueFactory(new PropertyValueFactory("landline"));
        tcMobile.setCellValueFactory(new PropertyValueFactory("mobile"));
        tcCnpj.setCellValueFactory(new PropertyValueFactory("cnpj"));

        company_oblist = FXCollections.observableArrayList(dal.getList("view_company"));
        tvCompany.setItems(company_oblist);
    }

    @FXML
    void inscomp() {
        MInsertCompany ic = new MInsertCompany();
        try {
            ic.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void editcomp() {
        MEditCompany ec = new MEditCompany();
        try {
            ec.start(new Stage());
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
        MDataCompany.getStage().close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        table();
    }

}
