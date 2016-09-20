/* SWEN20003 - Object Oriented Software Development
 * Player
 * Author: James Stone <stone1> 761353
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Represents a player object in the world.
 */
public class Player extends WorldObject {
    private double speed = 0.25;
    private Image backgroundUnflipped, backgroundFlipped;

    /**
     * @param x the initial x position of the Player
     * @param y the initial y position of the Player
     * @param background the background image that represents the Player
     * @param width the width of the Player (in px)
     * @param height the height of the Player (in px)
     */
    public Player(int x, int y, org.newdawn.slick.Image background, int width, int height) {
        super(x, y, background, width, height);
        backgroundFlipped = background.getFlippedCopy(true, false);
        backgroundUnflipped = background.copy();
    }

    /**
     * @param x the initial x position of the Player
     * @param y the initial y position of the Player
     * @param background the background image that represents the Player
     * @throws SlickException
     */
    public Player(int x, int y, Image background) throws SlickException {
        super(x, y, background);
    }

    /* Move the player in an x direction
     * @see WorldObject#moveX(double)
     */
    public void moveX(double direction) {
        super.moveX(speed * direction);
//		if (direction > 0){
//			background = backgroundUnflipped.copy();
//		}else if(direction < 0){
//			background = backgroundFlipped.copy();			
//		}
    }

    /* Move the player in a y direction
     * @see WorldObject#moveY(double)
     */
    public void moveY(double direction) {
        super.moveY(speed * direction);
    }
}
