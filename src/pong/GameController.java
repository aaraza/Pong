package pong;

import javafx.scene.input.KeyEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;


/**
 * @author Ali
 */
public class GameController extends Switchable implements Initializable {
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }
    
    private AnchorPane grid;
    private Timeline timeline;
    private Paddle paddle;
    private Ball ball;
        
    Boolean paused = false;
    int horizontalDirection=1;
    int verticalDirection=1;
    Integer score = 0;
    
    
    @Override
    public void ready(){
        startGame();
    }
    
    private void startGame(){
        
        grid = (AnchorPane)this.getRoot();
        
        final Double paneHeight = grid.getPrefHeight();
        final Double paneWidth = grid.getPrefWidth();
        
        paddle = new Paddle();
        ball = new Ball();
        
        timeline = new Timeline();
             
        grid.getChildren().add(paddle);
        grid.getChildren().add(ball);
        
        grid.requestFocus();
        grid.addEventFilter(KeyEvent.KEY_PRESSED, (KeyEvent event) -> {
            if(event.getCode()== KeyCode.SPACE){
                if(paused) {
                    timeline.play();
                    paused = false;
                } else {
                    timeline.pause();
                    paused = true;
                }
            } else {
                paddle.movePaddle(paneHeight, event.getCode());
            }
        }); 
             
       
        KeyFrame moveBall = new KeyFrame(Duration.seconds(.00350), (ActionEvent event) -> {
            
            if(ball.detectHit(paddle)){
                horizontalDirection *= -1;
            }
            
            if(ball.miss()) {
                timeline.stop();
                clearGame();  
            }
            if(ball.reflection(paneWidth)){
                horizontalDirection *= -1;
            }
            if(ball.wallCollision(paneHeight)){
                verticalDirection *= -1;
            }
            
            ball.move(horizontalDirection, verticalDirection);
        });
        
        timeline.getKeyFrames().add(moveBall);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
    
    private void clearGame(){
        grid.getChildren().clear();
        horizontalDirection *= -1;
        switchController("MainMenu");
    };  
}