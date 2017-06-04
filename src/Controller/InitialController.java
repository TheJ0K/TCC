/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Main.MInitial;
import Main.MLogin;
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
public class InitialController implements Initializable {
    
    @FXML
    void login(){
        MLogin login = new MLogin();
        try {
            login.start(new Stage());
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 
    }
    
    void close(){
        MInitial.getStage().close();
    }
    
}
