package pong;

import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author ali
 */
public class Paddle extends Rectangle{
    
    public static final double PADDLE_CONSTANT = 10;
    
    public Paddle(){
        this.setX(10);
        this.setY(120);
        this.setHeight(100);
        this.setWidth(10);
        this.setFill(Color.BLACK);
    }
    
    /**
     * Moves the player's paddle
     * @param panelHeight Height of panel in which the game is being played
     * @param key User input
     * @return False if paddle cannot be moved in given direction
     */
    public boolean movePaddle(Double panelHeight, KeyCode key) {
        switch (key){    
            case DOWN:
                if( this.getY() + this.getHeight() + PADDLE_CONSTANT >= panelHeight) {
                    return false;
                }   
                this.setY(this.getY() + PADDLE_CONSTANT);
                return true;
            case UP:
                if( this.getY() + PADDLE_CONSTANT <= 0) {
                    return false;
                }   
                this.setY(this.getY() - PADDLE_CONSTANT);
                return true;
               
            default: return false;
        }
    }
    
}
