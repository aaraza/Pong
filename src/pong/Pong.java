/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Ali
 */
public class Pong extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        HBox root = new HBox();
        root.setPrefSize(600, 400);

        Scene scene = new Scene(root);
       
        Switchable.scene = scene;
        Switchable.switchController("MainMenu");
        
        stage.setResizable(false);
        stage.setTitle("Pong");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */ 
    public static void main(String[] args) {
        launch(args);
    }
    
}
