/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAL.DAL;
import Model.City;
import Model.Developer;
import Model.Phone;
import Model.Photo;
import Model.PhysicalPerson;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Diogo Fistarol
 */
public class InsertPersonController implements Initializable {

    @FXML
    private TextField tfName, tfLastname, tfEmail, tfLandline, tfMobile, tfCpf, tfFace, tfCover, tfState, tfCity, tfAge;

    @FXML
    private PasswordField pfPassword;

    @FXML
    private TextArea taDescription;

    public String path;

    @FXML
    void insert() {
        if (tfAge.getText().equals("") || tfCity.getText().equals("") || tfCover.getText().equals("")
                || tfCpf.getText().equals("") || tfEmail.getText().equals("")
                || tfFace.getText().equals("") || tfLandline.getText().equals("")
                || tfLastname.getText().equals("") || tfMobile.getText().equals("")
                || tfName.getText().equals("") || tfState.getText().equals("") || taDescription.getText().equals("")
                || pfPassword.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("There are null fields, please review!");
            alert.setTitle("Null fields");
            alert.showAndWait();

        } else {
            DAL dal = new DAL();

            Developer dev = new Developer();
            Phone phone = new Phone();
            PhysicalPerson physical = new PhysicalPerson();
            State state = new State();
            Photo photo = new Photo();
            City city = new City();

            phone.setLandLine(Long.valueOf(tfLandline.getText()));
            phone.setMobile(Long.valueOf(tfMobile.getText()));

            photo.setFace(tfFace.getText());
            photo.setCover(tfCover.getText());

            state.setNameState(tfState.getText());
            city.setNameCity(tfCity.getText());
            state.setCity(city);

            physical.setName(tfName.getText());
            physical.setLastName(tfLastname.getText());
            physical.setPassword(pfPassword.getText());
            physical.setDescription(taDescription.getText());
            physical.setEmail(tfEmail.getText());
            physical.setState(state);
            physical.setPhone(phone);
            physical.setPhoto(photo);

            dev.setAge(Long.valueOf(tfAge.getText()));
            dev.setCpf(Long.valueOf(tfCpf.getText()));
            dev.setPhysicalPerson(physical);

            dal.add(phone);
            dal.add(photo);
            dal.add(city);
            dal.add(state);
            dal.add(physical);
            dal.add(dev);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Successful registration!");
            alert.setTitle("Successful registration");
            alert.showAndWait();

            clear();
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
    void numCpf() {
        String t = tfCpf.getText().replaceAll("[a-zA-Z\\á-ýÁ-Ý\\s\\.\\-\\,\\*\\/\\=\\("
                + "\\)\\&\\¨\\%\\$\\#\\@\\!\\?\\¹\\²\\³\\£\\¢\\¬\\'\\§\\_\\ª\\[\\]"
                + "\\º\\;\\:\\?\\~\\^\\ã-õÃ-Õ\\+\\|\\´\\`]", "");

        tfCpf.setText(t);
        tfCpf.end();
    }

    @FXML
    void numMobile() {
        String t = tfMobile.getText().replaceAll("[a-zA-Z\\á-ýÁ-Ý\\s\\|\\\\.\\-\\,\\*\\/\\=\\("
                + "\\)\\&\\¨\\%\\$\\#\\@\\!\\?\\¹\\²\\³\\£\\¢\\¬\\'\\§\\_\\ª\\[\\]"
                + "\\º\\;\\:\\?\\~\\^\\ã-õÃ-Õ\\+\\|\\´\\`]", "");

        tfMobile.setText(t);
        tfMobile.end();
    }

    @FXML
    void age() {
        String t = tfAge.getText().replaceAll("[a-zA-Z\\á-ýÁ-Ý\\s\\|\\\\.\\-\\,\\*\\/\\=\\("
                + "\\)\\&\\¨\\%\\$\\#\\@\\!\\?\\¹\\²\\³\\£\\¢\\¬\\'\\§\\_\\ª\\[\\]"
                + "\\º\\;\\:\\?\\~\\^\\ã-õÃ-Õ\\+\\|\\´\\`]", "");

        tfAge.setText(t);
        tfAge.end();
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

    @FXML
    void clear() {
        tfAge.clear();
        tfCity.clear();
        tfCover.clear();
        tfCpf.clear();
        tfEmail.clear();
        tfFace.clear();
        tfLandline.clear();
        tfLastname.clear();
        tfMobile.clear();
        tfName.clear();
        tfState.clear();
        taDescription.clear();
        pfPassword.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
