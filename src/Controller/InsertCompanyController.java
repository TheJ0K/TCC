/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ConnectionFactory.HibernateUtil;
import DAO.CityDAO;
import DAO.CompanyDAO;
import DAO.LegalPersonDAO;
import DAO.PhoneDAO;
import DAO.PhotoDAO;
import DAO.StateDAO;
import Model.City;
import Model.Company;
import Model.LegalPerson;
import Model.Phone;
import Model.Photo;
import Model.State;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

/**
 * FXML Controller class
 *
 * @author Diogo Fistarol
 */
public class InsertCompanyController implements Initializable {

    @FXML
    private TextField tfName, tfLastname, tfCompany, tfEmail, tfLandline, tfMobile, tfCnpj, tfFace, tfCover;

    @FXML
    private PasswordField pfPassword;

    @FXML
    private TextArea taDescription;

    @FXML
    private ChoiceBox cbCity, cbState;

    @FXML
    private ObservableList<String> city = FXCollections.observableArrayList("Teste");

    @FXML
    void insert() {
        CityDAO c = new CityDAO();
        CompanyDAO cd = new CompanyDAO();
        PhoneDAO pd = new PhoneDAO();
        LegalPersonDAO lp = new LegalPersonDAO();
        PhotoDAO p = new PhotoDAO();
        StateDAO s = new StateDAO();

        Company comp = new Company();
        Phone phone = new Phone();
        LegalPerson legal = new LegalPerson();
        State state = new State();
        Photo photo = new Photo();
        City city = new City();

        phone.setLandLine(Integer.valueOf(tfLandline.getText()));
        phone.setMobile(Integer.valueOf(tfMobile.getText()));

        photo.setFace(tfFace.getText());
        photo.setCover(tfCover.getText());

        city.setNameCity(cbCity.getValue().toString());
        state.setNameState(cbState.getValue().toString());

        legal.setName(tfName.getText());
        legal.setLastName(tfLastname.getText());
        legal.setPassword(pfPassword.getText());
        legal.setDescription(taDescription.getText());
        legal.setEmail(tfEmail.getText());

        comp.setNameCompany(tfCompany.getText());
        comp.setCnpj(Integer.valueOf(tfCnpj.getText()));

        lp.addLegal(legal);
        
        
        comp.setLegalPerson(legal);

        cd.addCompany(comp);
        pd.addPhone(phone);
        p.addPhoto(photo);
        c.addCity(city);
        s.addState(state);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbCity.setItems(city);
        cbState.setItems(city);
    }

}
