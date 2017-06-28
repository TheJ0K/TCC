/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAL.DAL;
import Main.MGraphicCompany;
import Main.MMain;
import Model.Company;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Diogo Fistarol
 */
public class GraphicCompanyController implements Initializable {

    @FXML
    private BarChart barCompany;
    
    ObservableList<Company> compList;
    
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
        MGraphicCompany.getStage().close();
    }
    
    @FXML
    void graphicComp() {
        DAL dal = new DAL();
        compList = FXCollections.observableArrayList(dal.getList("Company"));
        
        XYChart.Series comp = new XYChart.Series();
        comp.setName("Company quantity");

        XYChart.Data company = new XYChart.Data("Company", compList.size());

        comp.getData().add(company);

        barCompany.getData().addAll(comp);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        graphicComp();
    }

}
