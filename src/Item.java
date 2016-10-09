/* SWEN20003 Object Oriented Software Development
 * RPG Game Engine
 * Author: James Stone 761353 stone1
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

public class Item {
    private Image    image;
    private Vector2f position;
    private int      ID;

    public int getID() {
        return ID;
    }

    public void onPickup(BuffState buffs) {

    }

    public void render(Camera camera) {

    }
}
