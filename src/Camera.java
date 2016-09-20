/* SWEN20003 - Object Oriented Software Development
 * Camera
 * Author: James Stone <stone1> 761353
 */

import org.newdawn.slick.SlickException;

/**
 * Represents the camera that controls our viewpoint.
 */
public class Camera {

    /**
     * The unit this camera is following
     */
    private WorldObject unitFollow;

    /** The width and height of the screen in pixels*/
    public final int screenWidth;
    public final int screenHeight;
    
    /** The width and height of the map */
    public final int mapWidth;
    public final int mapHeight;
    

    /**
     * The camera's position in the world, in x and y coordinates.
     */
    private int xPos;
    private int yPos;


    /**
     * Create a new Camera object.
     *
     * @throws SlickException
     */
    public Camera(WorldObject unit, int screenWidth, int screenHeight, int mapWidth, int mapHeight)
            throws SlickException {
        this.followUnit(unit);
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
    }


    /**
     * Update the game camera to re-centre it's viewpoint around the player
     * @throws SlickException
     */
    public void update()
            throws SlickException {
    	// If not off the map, set the camera to share WorldObject position.
        if (unitFollow.getxPos() < mapWidth
                && unitFollow.getxPos() > 0) {
            xPos = unitFollow.getxPos() - (screenWidth / 2);
        }

        if (unitFollow.getyPos() < mapHeight
                && unitFollow.getyPos() > 0) {
            yPos = unitFollow.getyPos() - (screenHeight / 2);
        }
    }

    /**
     * @return Returns the minimum x value on screen
     */
    public int getMinX() {
        return xPos - screenWidth / 2;
    }

    /**
     * @return Returns the maximum x value on screen
     */
    public int getMaxX() {
        return xPos + screenWidth / 2;
    }

    /**
     * @return Returns the minimum y value on screen
     */
    public int getMinY() {
        return yPos - screenHeight / 2;
    }


    /**
     * @return Returns the maximum y value on screen
     */
    public int getMaxY() {
        return yPos + screenHeight / 2;
    }

    /**
     * Tells the camera to follow a given unit.
     * @param unit
     * @throws SlickException
     */
    public void followUnit(WorldObject unit)
            throws SlickException {
        unitFollow = unit;
    }

    
    /**
     * @return the current camera's x position
     */
    public int getxPos() {
        return xPos;
    }

    /**
     * @return the current camera's y position
     */
    public int getyPos() {
        return yPos;
    }

}