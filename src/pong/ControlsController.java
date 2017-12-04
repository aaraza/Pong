/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import static pong.Switchable.switchController;

/**
 * FXML Controller class
 *
 * @author Ali
 */
public class ControlsController extends Switchable implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void switchToMainMenu(ActionEvent event) throws Exception{
        switchController("MainMenu");
    }
    
    @FXML
    private void exitGame(ActionEvent event) {
        Platform.exit();
    }
    
}
