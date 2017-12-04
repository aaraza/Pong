package pong;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author ali
 */
public class Ball extends Circle{
    
    /**
     * Creates a new ball and places it in the center of the screen 
     */
    public Ball() {
        super(300, 185, 5);
        this.setFill(Color.WHITE);
    }
    
    /**
     * Determines if the ball hit the user's paddle
     * @param paddle user's paddle
     * @return true if paddle hit ball
     */
    public boolean detectHit(Paddle paddle) {
        return paddle.contains(this.getBoundsInParent().getMinX(), this.getBoundsInParent().getMinY());
    }
    
    /**
     * Determines whether the ball has been deflected by any of the vertical boundries
     * @param panelHeight Height of the panel the game is contained in
     * @return True if the ball hits the upper or lower wall
     */
    public boolean wallCollision(Double panelHeight) {
        return this.getBoundsInParent().getMinY() <= 0 || this.getBoundsInParent().getMaxY() >=panelHeight;
    }
    
    /**
     * Determines whether ball should be deflected back from opposing wall
     * @param panelWidth Width of panel game is contained in
     * @return True if the ball bounces of the boundry opposite to the player
     */
    public boolean reflection(Double panelWidth) {
        return this.getBoundsInParent().getMaxX() >= panelWidth;
    }
    
    /**
     * Determines whether the user's paddle did not hit the ball
     * @return True if the ball hits the leftmost x-axis in the grid
     */
    public boolean miss() {
        return this.getBoundsInParent().getMinX() == 0;
    }
    
    /**
     * Moves the ball if either of the boundries are hit
     * @param horizontalDirection Horizontal direction ball is moving in
     * @param verticalDirection Vertical direction ball is moving in
     */
    public void move(int horizontalDirection, int verticalDirection) {
        this.setTranslateX(this.getTranslateX() + horizontalDirection);
        this.setTranslateY(this.getTranslateY() + verticalDirection);
    }
    
}
