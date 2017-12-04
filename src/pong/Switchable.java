package pong;

import java.io.IOException;
import java.util.HashMap;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * @author Ali Raza
 * This class allows for a user to switch the GUI of a page by controller.
 */
public abstract class Switchable {
    
    /**
     * List of controllers being used by program
     */
    public static final HashMap<String, Switchable> CONTROLLERS = new HashMap<>();
    
    /**
     * Current scene of the program
     */
    public static Scene scene;
    
    private Parent root;
    
    /**
     * Sets root of a newController
     * @param root 
     */
    public void setRoot(Parent root){
        this.root = root;
    }
    
    /**
     * Gets root of a newController
     * @return 
     */
    public Parent getRoot(){
        return root;
    }
    
    /**
     * Add newController to list of switchable scenes
     * @param name Name of newController being added to program
     * @return New newController added to program, or null newController if exception was encountered
     */
    public static Switchable addController(String name){
        
        Switchable newController;
        newController = CONTROLLERS.get(name);
        
        // Will not executre if controller <name> already exists
        if(newController == null){
            try{
                
                FXMLLoader loader = new FXMLLoader(Switchable.class.getResource(name + ".fxml"));
                Parent root = (Parent)loader.load();
                
                newController = (Switchable)loader.getController();
                newController.setRoot(root);
                
                CONTROLLERS.put(name, newController);
            
            } catch (IOException ex){
                newController = null;
            }
        }
        
        return newController;
    }
    
    /**
     * Switch controller
     * @param name Name of controller to switch to
     */
    public static void switchController(String name){
        Switchable controller = CONTROLLERS.get(name);
        
        if(controller == null){
            controller = addController(name);
        }
        
        if(controller !=null){
            if(scene != null){
                scene.setRoot(controller.getRoot());
                controller.ready();
            }
        }
    }
    
    /**
     * @param name Name of controller to get
     * @return Controller we are searching for or null if it doesn't exist
     */
    public static Switchable getControllerByName(String name){
        return CONTROLLERS.get(name);
    }
    
    public void ready() {
        //TODO
    }
    
}