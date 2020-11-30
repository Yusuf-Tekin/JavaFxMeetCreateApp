/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import com.jfoenix.controls.JFXToggleButton;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;

/**
 *
 * @author ALTINOLUK
 */
public class FXMLDocumentController implements Initializable {
    
    
    
    public Tooltip ToolTip = new Tooltip();
    @FXML
    public ImageView closebutton;
    @FXML
    public Label ToggleStatus;
    @FXML
    public ToggleButton ToggleButton;

    @FXML 
    public JFXSpinner Spinner;
    
    @FXML 
    public JFXButton OkButton;
    @FXML
    public JFXTextField MeetHead;
    @FXML
    public JFXDatePicker MeetDate;
    @FXML
    public JFXTimePicker MeetTime;
    @FXML
    public JFXToggleButton MeetStatusButton;
   
    
    @FXML
    public void ToggleAction(Event event){
        if (MeetStatusButton.isSelected() == true) {
            ToggleStatus.setText("Herkes Girebilir.");
        }
        else if(MeetStatusButton.isSelected() == false){
            ToggleStatus.setText("Sadece Üyeler Girebilir.");
        }
    }
    @FXML
    public void AppClose(Event event){
        System.exit(0);
    }
    
    @FXML
    public void OkButtonAction(Event event){
        
        String meetinghead = MeetHead.getText();
        LocalDate meetingdate = MeetDate.getValue();
        LocalTime meetingtime = MeetTime.getValue();
        String meetingstatus;
        
        if (MeetStatusButton.isSelected() == true){
            meetingstatus = "Sadece Üyeler";
            
        }
        else{
            meetingstatus = "Herkes";
        }
        
        
 
        String meetDetail = "Başlık : " + meetinghead + "\nTarih : " + meetingdate + "\nSaat : " + meetingtime + "\nDurum : " + meetingstatus;
        this.OkButton.setDisable(true);
        this.Spinner.setVisible(true);
        
        Alert alert = new Alert(Alert.AlertType.WARNING,"İşte Detalar:\n" +meetDetail,ButtonType.OK);
        alert.setHeaderText("Uyarı");
        alert.setTitle("Toplantı Uygulaması");
        alert.show();
        System.out.println(alert.getHeaderText());
    }
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
