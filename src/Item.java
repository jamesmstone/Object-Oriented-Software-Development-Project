/* SWEN20003 Object Oriented Software Development
 * RPG Game Engine
 * Author: James Stone 761353 stone1
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

abstract public class Item {
    private Image    image;
    private Vector2f position;


    Item(Image image, Vector2f position) {
        this.image = image;
        this.position = position;
    }


    public abstract void onPickup(Stats playerStats);

    public void render(Camera camera) {
        if (onScreen(camera)) {
            image.drawCentered((int) position.getX(), (int) position.getY());
        }
    }

    public void render(Camera camera, Vector2f position) {
        image.draw((int) position.getX(), (int) position.getY());
    }

    private boolean onScreen(Camera cam) {
        return cam.getMinX() <= position.getX() && position.getX() <= cam.getMaxX() &&
                cam.getMinY() <= position.getY() && position.getY() <= cam.getMaxY();
    }


    public boolean near(Vector2f point, float distance) {
        return position.distance(point) < distance;
    }
}
