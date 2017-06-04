/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Main.MDataCompany;
import Main.MEditCompany;
import Main.MInsertCompany;
import Main.MMain;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Diogo Fistarol
 */
public class DataCompanyController implements Initializable {
    
    @FXML
    void inscomp(){
        MInsertCompany ic = new MInsertCompany();
        try {
            ic.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void editcomp(){
        MEditCompany ec = new MEditCompany();
        try {
            ec.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void back(){
        MMain main = new MMain();
        try {
            main.start(new Stage());
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void close(){
        MDataCompany.getStage().close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
