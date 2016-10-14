/* SWEN20003 Object Oriented Software Development
 * RPG Game Engine
 * Author: James Stone 761353 stone1
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

abstract public class Item {
    private Image    image;
    private Vector2f position;


    /**
     * Generates an item, called by subclasses as abstract class
     * @param image     an image representing the item
     * @param position  the start position of the item in the world
     */
    Item(Image image, Vector2f position) {
        this.image = image;
        this.position = position;
    }


    public abstract void onPickup(Stats playerStats);

    /**
     * Renders an item to the screen
     * @param camera the camera
     */
    public void render(Camera camera) {
        if (onScreen(camera)) {
            image.drawCentered((int) position.getX(), (int) position.getY());
        }
    }

    /**
     * Renders an item to the statusPanel
     * @param camera the camera
     * @param position where in the status panel to place it
     */
    public void render(Camera camera, Vector2f position) {
        image.draw((int) position.getX(), (int) position.getY());
    }

    private boolean onScreen(Camera cam) {
        return cam.getMinX() <= position.getX() && position.getX() <= cam.getMaxX() &&
                cam.getMinY() <= position.getY() && position.getY() <= cam.getMaxY();
    }

    /**
     * Returns true if a point is within a certain distance of the item
     * @param point the point
     * @param distance the distance (px)
     * @return true if a point is within a certain distance of the item
     */
    public boolean near(Vector2f point, float distance) {
        return position.distance(point) < distance;
    }
}
