/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAL.DAL;
import Main.MGraphicPerson;
import Main.MMain;
import Model.Developer;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Diogo Fistarol
 */
public class GraphicPersonController implements Initializable {
    
    @FXML
    private LineChart linePerson;
    
    ObservableList<Developer> devList;
    
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
    void close(){
        MGraphicPerson.getStage().close();
    }
    
    @FXML
    void graphicDev() {
        DAL dal = new DAL();
        devList = FXCollections.observableArrayList(dal.getList("Developer"));
        
        XYChart.Series comp = new XYChart.Series();
        comp.setName("Developer quantity");

        XYChart.Data company = new XYChart.Data("Developer", devList.size());

        comp.getData().add(company);

        linePerson.getData().addAll(comp);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        graphicDev();
    }    
    
}
