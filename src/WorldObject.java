/* SWEN20003 - Object Oriented Software Development
 * WorldObject
 * Author: James Stone <stone1> 761353
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 * Represents any object in the world.
 */
/**
 * @author developer
 *
 */
public class WorldObject {
    private int gameX, gameY;
    private int width, height;
    protected Image background;

    /**
     * @param x the initial x position of the object
     * @param y the initial y position of the object
     * @param background the background image that represents the object
     * @param width the width of the object (in px)
     * @param height the height of the object (in px)
     */
    public WorldObject(int x, int y, Image background, int width, int height) {
        setxPos(x);
        setyPos(y);
        setWidth(width);
        setHeight(height);
        setBackground(background);
    }

    /**
 	 * @param x the initial x position of the object
     * @param y the initial y position of the object
     * @param background the background image that represents the object
     */
    public WorldObject(int x, int y, Image background) throws SlickException {
        gameX = x;
        gameY = y;
        setWidth(background.getWidth());
        setHeight(background.getHeight());
        setBackground(background);
    }

    /**
     * Renders the player in the correct position relative to the camera
     * @param cam the camera to position the object to.
     */
    public void render(Camera cam) {
        background.draw(gameX - cam.getxPos() - (width / 2), gameY - cam.getyPos() - (height / 2));
    }

    /**
     * Moves the object in the x direction 
     * @param amount the amount to move in px
     */
    public void moveX(double amount) {
        this.setxPos((int) (gameX + amount));
    }

    /**
     * Moves the object in the y direction 
     * @param amount the amount to move in px
     */
    public void moveY(double amount) {
        this.setyPos((int) (gameY + amount));
    }

    /**
     * Get the object current x position
     * @return the x coordinate in px
     */
    public int getxPos() {
        return gameX;
    }

    /**
     * Sets the objects x position
     * @param x the x coordinate to set in px
     */
    public void setxPos(int x) {
        if (x <= RPG.WORLDWIDTH
                && x >= 0
                && !this.blocks(x, gameY)) {
            this.gameX = x;
        }
    }

    /**
     * Get the object current y position
     * @return the y coordinate in px
     */
    public int getyPos() {
        return gameY;
    }

    /**
     * Sets the objects x position
     * @param y the y coordinate to set in px
     */
    public void setyPos(int y) {
        if (y <= RPG.WORLDHEIGHT
                && y >= 0
                && !this.blocks(gameX, y)) {

            this.gameY = y;
        }
    }

    /**
     * Returns the objects width
     * @return the width in px
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets the objects width
     * @param width the width to set in px
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Gets the objects height
     * @return the height in px
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets the objects height
     * @param height the height to set in px
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Gets the objects background
     * @return the background
     */
    public Image getBackground() {
        return background;
    }

    /**
     * Sets the objects background
     * @param background the background to set
     */
    public void setBackground(Image background) {
        this.background = background;
    }


    /**
     * Determines in the co-ordinates x,y is blocked for the object.
     * @param x the x coordinate in px
     * @param y the y coordinate in px
     * @return whether the new position is blocked
     */
    public boolean blocks(double x, double y) {

        int xTile = (int) (x / 72);
        int yTile = (int) (y / 72);
        System.out.println(x + " " + y);
        System.out.println(xTile + " " + yTile);
        
    	/* Check and return if the tile is blocking. */
        int tileID = World.background.getTileId(xTile, yTile, 0);
        Boolean block = World.background.getTileProperty(tileID, "block", "0").equals("1");
        System.out.println(block);
        return block;
    }

}
