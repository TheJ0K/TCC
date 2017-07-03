/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAL.DAL;
import Model.City;
import Model.Developer;
import Model.Encryption;
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
import javafx.scene.control.Tooltip;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Diogo Fistarol
 */
public class EditPersonController implements Initializable {

    @FXML
    private TextField tfCover, tfLastname, tfMobile, tfName, tfEmail, tfAge,
            tfCity, tfState, tfCpf, tfLandline, tfFace;

    @FXML
    private PasswordField pfPassword;

    @FXML
    private TextArea taDescription;

    private String path;

    @FXML
    void init() {
        tfName.setText(DataPersonController.selected.getName());
        tfLastname.setText(DataPersonController.selected.getLastName());
        tfAge.setText(DataPersonController.selected.getDeveloper().getAge().toString());
        pfPassword.setText(DataPersonController.selected.getPassword());
        tfEmail.setText(DataPersonController.selected.getEmail());
        tfLandline.setText(DataPersonController.selected.getPhone().getLandLine().toString());
        tfMobile.setText(DataPersonController.selected.getPhone().getMobile().toString());
        tfCpf.setText(DataPersonController.selected.getDeveloper().getCpf().toString());
        tfFace.setText(DataPersonController.selected.getPhoto().getFace());
        tfCover.setText(DataPersonController.selected.getPhoto().getCover());
        taDescription.setText(DataPersonController.selected.getDescription());
        tfState.setText(DataPersonController.selected.getState().getNameState());
        tfCity.setText(DataPersonController.selected.getState().getCity().getNameCity());
    }

    @FXML
    void update() {
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
            //Cria o objeto dal para chamar uasr as opções de CRUD
            DAL dal = new DAL();

            //Cria objetos de cada classe necessaria
            Developer dev = new Developer();
            Phone phone = new Phone();
            PhysicalPerson physical = new PhysicalPerson();
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

            physical.setName(tfName.getText());
            physical.setLastName(tfLastname.getText());
            physical.setPassword(Encryption.encrypt(pfPassword.getText()));
            physical.setDescription(taDescription.getText());
            physical.setEmail(tfEmail.getText());
            physical.setIdphysical(DataPersonController.selected.getIdphysical());
            physical.setState(state);
            physical.setPhone(phone);
            physical.setPhoto(photo);

            dev.setAge(Long.valueOf(tfAge.getText()));
            dev.setCpf(Long.valueOf(tfCpf.getText()));
            dev.setPhysicalPerson(physical);
            dev.setIddeveloper(DataPersonController.selected.getDeveloper().getIddeveloper());

            dal.update(dev);
            dal.update(physical);
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
    void numCpf() {
        String t = tfCpf.getText().replaceAll("[a-zA-Z\\á-ýÁ-Ý\\s\\.\\-\\,\\*\\/\\=\\("
                + "\\)\\&\\¨\\%\\$\\#\\@\\!\\?\\¹\\²\\³\\£\\¢\\¬\\'\\§\\_\\ª\\[\\]"
                + "\\º\\;\\:\\?\\~\\^\\ã-õÃ-Õ\\+\\|\\´\\`]", "");

        tfCpf.setText(t);
        tfCpf.end();
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        init();
    }

}
