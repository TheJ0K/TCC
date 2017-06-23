/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAL.DAL;
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
        DAL dal = new DAL();

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
        state.setCity(city);

        legal.setName(tfName.getText());
        legal.setLastName(tfLastname.getText());
        legal.setPassword(pfPassword.getText());
        legal.setDescription(taDescription.getText());
        legal.setEmail(tfEmail.getText());

        legal.setPhone(phone);
        legal.setPhoto(photo);
        
        comp.setNameCompany(tfCompany.getText());
        comp.setCnpj(Integer.valueOf(tfCnpj.getText()));
        
        dal.add(legal);

        comp.setLegalPerson(legal);

        dal.add(comp);
        dal.add(phone);
        dal.add(photo);
        dal.add(state);
        dal.add(city);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbCity.setItems(city);
        cbState.setItems(city);
    }

}
