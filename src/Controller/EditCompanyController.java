/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAL.DAL;
import Model.City;
import Model.Company;
import Model.Encryption;
import Model.LegalPerson;
import Model.Phone;
import Model.Photo;
import Model.State;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Diogo Fistarol
 */
public class EditCompanyController implements Initializable {

    @FXML
    private TextField tfCover, tfLastname, tfMobile, tfName, tfEmail, tfCompany,
            tfCity, tfState, tfCnpj, tfLandline, tfFace;

    @FXML
    private PasswordField pfPassword;

    @FXML
    private TextArea taDescription;

    private String path;

    @FXML
    void init() {
        tfName.setText(DataCompanyController.selected.getName());
        tfLastname.setText(DataCompanyController.selected.getLastName());
        tfCompany.setText(DataCompanyController.selected.getCompany().getNameCompany());
        pfPassword.setText(DataCompanyController.selected.getPassword());
        tfEmail.setText(DataCompanyController.selected.getEmail());
        tfLandline.setText(DataCompanyController.selected.getPhone().getLandLine().toString());
        tfMobile.setText(DataCompanyController.selected.getPhone().getMobile().toString());
        tfCnpj.setText(DataCompanyController.selected.getCompany().getCnpj().toString());
        tfFace.setText(DataCompanyController.selected.getPhoto().getFace());
        tfCover.setText(DataCompanyController.selected.getPhoto().getCover());
        taDescription.setText(DataCompanyController.selected.getDescription());
        tfState.setText(DataCompanyController.selected.getState().getNameState());
        tfCity.setText(DataCompanyController.selected.getState().getCity().getNameCity());
    }

    @FXML
    void update() {
        if (tfCompany.getText().equals("") || tfCity.getText().equals("") || tfCover.getText().equals("")
                || tfCnpj.getText().equals("") || tfEmail.getText().equals("")
                || tfFace.getText().equals("") || tfLandline.getText().equals("")
                || tfLastname.getText().equals("") || tfMobile.getText().equals("")
                || tfName.getText().equals("") || tfState.getText().equals("") || taDescription.getText().equals("")
                || pfPassword.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("There are null fields, please review!");
            alert.setTitle("Null fields");
            alert.showAndWait();
        } else {
            //Cria o objeto dal para chamar uasr as opções de CRUD
            DAL dal = new DAL();

            //Cria objetos de cada classe necessaria
            Company comp = new Company();
            Phone phone = new Phone();
            LegalPerson legal = new LegalPerson();
            State state = new State();
            Photo photo = new Photo();
            City city = new City();

            //Seta valores de acordo com os campos
            phone.setLandLine(Long.valueOf(tfLandline.getText()));
            phone.setMobile(Long.valueOf(tfMobile.getText()));
            phone.setIdPhone(DataCompanyController.selected.getPhone().getIdPhone());

            photo.setFace(tfFace.getText());
            photo.setCover(tfCover.getText());
            photo.setIdPhoto(DataCompanyController.selected.getPhoto().getIdPhoto());

            state.setNameState(tfState.getText());
            state.setIdState(DataCompanyController.selected.getState().getIdState());
            city.setNameCity(tfCity.getText());
            city.setIdCity(DataCompanyController.selected.getState().getCity().getIdCity());
            state.setCity(city);

            legal.setName(tfName.getText());
            legal.setLastName(tfLastname.getText());
            legal.setPassword(Encryption.encrypt(pfPassword.getText()));
            legal.setDescription(taDescription.getText());
            legal.setEmail(tfEmail.getText());
            legal.setIdlegal(DataCompanyController.selected.getIdlegal());
            legal.setState(state);
            legal.setPhone(phone);
            legal.setPhoto(photo);

            comp.setNameCompany(tfCompany.getText());
            comp.setCnpj(Long.valueOf(tfCnpj.getText()));
            comp.setLegalPerson(legal);
            comp.setIdCompany(DataCompanyController.selected.getCompany().getIdCompany());

            dal.update(comp);
            dal.update(legal);
            dal.update(phone);
            dal.update(photo);
            dal.update(state);
            dal.update(city);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Successful edited!");
            alert.setTitle("Successful edited");
            alert.showAndWait();
        }
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
        init();
    }

}
