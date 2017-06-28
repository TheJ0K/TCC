/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAL.DAL;
import Main.MGraphicCompanyPerson;
import Main.MMain;
import Model.Company;
import Model.Developer;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Diogo Fistarol
 */
public class GraphicCompanyPersonController implements Initializable {

    @FXML
    private PieChart piePersonCompany;

    private ObservableList<Company> comp_oblist;

    private ObservableList<Developer> dev_oblist;

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
        MGraphicCompanyPerson.getStage().close();
    }

    @FXML
    void graphic() {
        DAL dal = new DAL();
        comp_oblist = FXCollections.observableArrayList(dal.getList("Company"));
        dev_oblist = FXCollections.observableArrayList(dal.getList("Developer"));

        piePersonCompany.getData().addAll(new PieChart.Data("Company", comp_oblist.size()),
                 new PieChart.Data("Developer", dev_oblist.size()));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        graphic();
    }

}
