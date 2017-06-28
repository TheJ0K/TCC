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
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

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
    private TableColumn<LegalPerson, String> tcCompany;
    @FXML
    private TableColumn<LegalPerson, String> tcEmail;
    @FXML
    private TableColumn<LegalPerson, String> tcState;
    @FXML
    private TableColumn<LegalPerson, String> tcCity;
    @FXML
    private TableColumn<LegalPerson, Long> tcLandline;
    @FXML
    private TableColumn<LegalPerson, Long> tcMobile;
    @FXML
    private TableColumn<LegalPerson, Long> tcCnpj;
    
    public static LegalPerson selected;
    private Company comp;
    private Phone phone;
    private Photo photo;
    private State state;
    private City city;
    
    private String path = "/Image/imgDesign.jpg";
    
    private ObservableList<LegalPerson> company_oblist;
    
    @FXML
    void pdfGenerator() {
        Document doc = new Document();
        
        FileChooser window = new FileChooser();
        window.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF", "*.pdf"));
        File a = window.showSaveDialog(new Stage());
        if (selected != null) {
            if (a != null) {
                try {
                    PdfWriter.getInstance(doc, new FileOutputStream(a.getAbsolutePath()));
                    doc.open();
                    DAL dal = new DAL();
                    List<LegalPerson> legal = dal.getList("LegalPerson");
                    for (int x = 0; x < legal.size(); x++) {
                        doc.add(new Paragraph("Name: " + legal.get(x).getName()));
                        doc.add(new Paragraph("LastName: " + legal.get(x).getLastName()));
                        doc.add(new Paragraph("Email: " + legal.get(x).getEmail()));
                        doc.add(new Paragraph("Name company: " + legal.get(x).getCompany().getNameCompany()));
                        doc.add(new Paragraph("CNPJ: " + legal.get(x).getCompany().getCnpj()));
                        doc.add(new Paragraph("Description: " + legal.get(x).getDescription()));
                        doc.add(new Paragraph("State: " + legal.get(x).getState().getNameState()));
                        doc.add(new Paragraph("City: " + legal.get(x).getState().getCity()));
                        doc.add(new Paragraph("LandLine: " + legal.get(x).getPhone().getLandLine()));
                        doc.add(new Paragraph("Mobile: " + legal.get(x).getPhone().getMobile()));
                        doc.add(new Paragraph("\n"));
                    }
                    doc.close();
                    Alert al = new Alert(Alert.AlertType.INFORMATION);
                    al.setHeaderText("PDF gerado com sucesso e armazenado em: " + a.getAbsolutePath());
                    al.show();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(DataCompanyController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DocumentException ee) {
                    Logger.getLogger(DataCompanyController.class.getName()).log(Level.SEVERE, null, ee);
                }
            } else {
                Alert al = new Alert(Alert.AlertType.INFORMATION);
                al.setHeaderText("Defina um lugar para salvar o arquivo!");
                al.show();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Nothing selected, please select!");
            alert.setTitle("Nothing selected");
            alert.showAndWait();
        }
        
    }
    
    @FXML
    void reload() {
        DAL dal = new DAL();
        tcName.setCellValueFactory(new PropertyValueFactory("name"));
        tcLastname.setCellValueFactory(new PropertyValueFactory("lastName"));
        tcCompany.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<LegalPerson, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<LegalPerson, String> param) {
                return new SimpleStringProperty(param.getValue().getCompany().getNameCompany());
            }
        });
        tcEmail.setCellValueFactory(new PropertyValueFactory("email"));
        tcState.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<LegalPerson, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<LegalPerson, String> param) {
                return new SimpleStringProperty(param.getValue().getState().getNameState());
            }
        });
        tcCity.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<LegalPerson, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<LegalPerson, String> param) {
                return new SimpleStringProperty(param.getValue().getState().getCity().getNameCity());
            }
        }
        );
        tcLandline.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<LegalPerson, Long>, ObservableValue<Long>>() {
            @Override
            public ObservableValue<Long> call(TableColumn.CellDataFeatures<LegalPerson, Long> param) {
                return new SimpleObjectProperty<>(param.getValue().getPhone().getLandLine());
            }
        });
        tcMobile.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<LegalPerson, Long>, ObservableValue<Long>>() {
            @Override
            public ObservableValue<Long> call(TableColumn.CellDataFeatures<LegalPerson, Long> param) {
                return new SimpleObjectProperty<>(param.getValue().getPhone().getMobile());
            }
        });
        tcCnpj.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<LegalPerson, Long>, ObservableValue<Long>>() {
            @Override
            public ObservableValue<Long> call(TableColumn.CellDataFeatures<LegalPerson, Long> param) {
                return new SimpleObjectProperty<>(param.getValue().getCompany().getCnpj());
            }
        });
        
        company_oblist = FXCollections.observableArrayList(dal.getList("LegalPerson"));
        tvCompany.setItems(company_oblist);
        
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Upgraded table");
        a.setHeaderText("Upgraded table!");
        a.showAndWait();
    }
    
    @FXML
    void delete() {
        if (selected != null) {
            DAL dal = new DAL();
            
            Alert t = new Alert(Alert.AlertType.CONFIRMATION);
            t.setTitle("Really delete?!");
            t.setHeaderText("Do you really want to delete?!");
            Optional<ButtonType> bt = t.showAndWait();
            
            if (bt.get() == ButtonType.OK) {
                try {
                    dal.delete(selected.getCompany());
                    dal.delete(selected);
                    dal.delete(selected.getPhone());
                    dal.delete(selected.getPhoto());
                    dal.delete(selected.getState());
                    dal.delete(selected.getState().getCity());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
            }
        } else {
        }
    }
    
    @FXML
    void table() {
        DAL dal = new DAL();
        
        tcName.setCellValueFactory(new PropertyValueFactory("name"));
        tcLastname.setCellValueFactory(new PropertyValueFactory("lastName"));
        tcCompany.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<LegalPerson, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<LegalPerson, String> param) {
                return new SimpleStringProperty(param.getValue().getCompany().getNameCompany());
            }
        });
        tcEmail.setCellValueFactory(new PropertyValueFactory("email"));
        tcState.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<LegalPerson, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<LegalPerson, String> param) {
                return new SimpleStringProperty(param.getValue().getState().getNameState());
            }
        });
        tcCity.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<LegalPerson, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<LegalPerson, String> param) {
                return new SimpleStringProperty(param.getValue().getState().getCity().getNameCity());
            }
        }
        );
        tcLandline.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<LegalPerson, Long>, ObservableValue<Long>>() {
            @Override
            public ObservableValue<Long> call(TableColumn.CellDataFeatures<LegalPerson, Long> param) {
                return new SimpleObjectProperty<>(param.getValue().getPhone().getLandLine());
            }
        });
        tcMobile.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<LegalPerson, Long>, ObservableValue<Long>>() {
            @Override
            public ObservableValue<Long> call(TableColumn.CellDataFeatures<LegalPerson, Long> param) {
                return new SimpleObjectProperty<>(param.getValue().getPhone().getMobile());
            }
        });
        tcCnpj.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<LegalPerson, Long>, ObservableValue<Long>>() {
            @Override
            public ObservableValue<Long> call(TableColumn.CellDataFeatures<LegalPerson, Long> param) {
                return new SimpleObjectProperty<>(param.getValue().getCompany().getCnpj());
            }
        });
        
        company_oblist = FXCollections.observableArrayList(dal.getList("LegalPerson"));
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
            if (selected != null) {
                ec.start(new Stage());
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Nothing selected");
                alert.setHeaderText("Select something to edit");
                alert.showAndWait();
            }
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
    
    void init() {
        tvCompany.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                selected = (LegalPerson) newValue;
                if (selected != null) {
                    taDescription.setText(selected.getDescription());
                    imageFace.setImage(new Image(selected.getPhoto().getFace()));
                    imageCover.setImage(new Image(selected.getPhoto().getCover()));
                } else {
                    taDescription.setText("");
                    imageFace.setImage(new Image(path));
                    imageCover.setImage(new Image(path));
                }
                
            }
        }
        );
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        init();
        table();
    }
    
}
