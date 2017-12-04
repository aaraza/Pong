package pong;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * Controller class for the main menu
 * See MainMenu.fxml for GUI
 * @author ali
 */
public class MainMenuController extends Switchable implements Initializable {

    @FXML
    private void startGame(ActionEvent event) {
        switchController("Game");
    }
    
    @FXML
    private void showControls(ActionEvent event) {
        switchController("Controls");
    }
    
    @FXML
    private void closeGame(ActionEvent event) {
        Platform.exit();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
