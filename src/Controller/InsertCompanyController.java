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
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Diogo Fistarol
 */
public class InsertCompanyController implements Initializable {

    @FXML
    private TextField tfName, tfLastname, tfCompany, tfEmail, tfLandline, tfMobile, tfCnpj, tfFace, tfCover, tfState, tfCity;

    @FXML
    private PasswordField pfPassword;

    @FXML
    private TextArea taDescription;

    public String path;

    @FXML
    void insert() {
        DAL dal = new DAL();

        Company comp = new Company();
        Phone phone = new Phone();
        LegalPerson legal = new LegalPerson();
        State state = new State();
        Photo photo = new Photo();
        City city = new City();

        phone.setLandLine(Long.valueOf(tfLandline.getText()));
        phone.setMobile(Long.valueOf(tfMobile.getText()));

        photo.setFace(tfFace.getText());
        photo.setCover(tfCover.getText());
        photo.setLegalPerson(legal);

        state.setNameState(tfState.getText());
        city.setNameCity(tfCity.getText());
        state.setCity(city);

        legal.setName(tfName.getText());
        legal.setLastName(tfLastname.getText());
        legal.setPassword(pfPassword.getText());
        legal.setDescription(taDescription.getText());
        legal.setEmail(tfEmail.getText());
        legal.setState(state);

        comp.setNameCompany(tfCompany.getText());
        comp.setCnpj(Long.valueOf(tfCnpj.getText()));
        comp.setLegalPerson(legal);

        dal.add(city);

        dal.add(state);

        dal.add(legal);

        dal.add(comp);

        dal.add(phone);

        dal.add(photo);
    }

    @FXML
    void numLand() {
        String t = tfLandline.getText().replaceAll("[a-zA-Z\\á-ýÁ-Ý\\s\\.\\-\\,\\*\\/\\=\\("
                + "\\)\\&\\¨\\%\\$\\#\\@\\!\\?\\¹\\²\\³\\£\\¢\\¬\\'\\§\\_\\ª\\[\\]"
                + "\\º\\;\\:\\?\\~\\^\\ã-õÃ-Õ\\+\\|\\´\\`]", "");

        tfLandline.setText(t);
        tfLandline.end();
    }

    @FXML
    void numCnpj() {
        String t = tfCnpj.getText().replaceAll("[a-zA-Z\\á-ýÁ-Ý\\s\\.\\-\\,\\*\\/\\=\\("
                + "\\)\\&\\¨\\%\\$\\#\\@\\!\\?\\¹\\²\\³\\£\\¢\\¬\\'\\§\\_\\ª\\[\\]"
                + "\\º\\;\\:\\?\\~\\^\\ã-õÃ-Õ\\+\\|\\´\\`]", "");

        tfCnpj.setText(t);
        tfCnpj.end();
    }

    @FXML
    void numMobile() {
        Tooltip tool = new Tooltip();
        tool.setText("Insert numbers");
        tfMobile.setTooltip(tool);

        String t = tfMobile.getText().replaceAll("[a-zA-Z\\á-ýÁ-Ý\\s\\|\\\\.\\-\\,\\*\\/\\=\\("
                + "\\)\\&\\¨\\%\\$\\#\\@\\!\\?\\¹\\²\\³\\£\\¢\\¬\\'\\§\\_\\ª\\[\\]"
                + "\\º\\;\\:\\?\\~\\^\\ã-õÃ-Õ\\+\\|\\´\\`]", "");

        tfMobile.setText(t);
        tfMobile.end();
    }

    @FXML
    void imageFace() {
        try {
            FileChooser window = new FileChooser();
            window.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imagens", "*.jpg", "*.jpeg", "*.png"));
            File f = window.showOpenDialog(new Stage());

            if (f != null) {
                path = ("file:///" + f.getAbsolutePath());
                tfFace.setText(path);
            } else {
                Alert erro = new Alert(Alert.AlertType.WARNING);
                erro.setHeaderText("Por favor selecione uma imagem!");
            }

        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    @FXML
    void imageCover() {
        try {
            FileChooser window = new FileChooser();
            window.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imagens", "*.jpg", "*.jpeg", "*.png"));
            File f = window.showOpenDialog(new Stage());

            if (f != null) {
                path = ("file:///" + f.getAbsolutePath());
                tfCover.setText(path);
            } else {
                Alert erro = new Alert(Alert.AlertType.WARNING);
                erro.setHeaderText("Por favor selecione uma imagem!");
            }

        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
