/* SWEN20003 - Object Oriented Software Development
 * RPG Game Engine
 * Author: James Stone <stone1> 761353
 */

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

public class Monster extends Unit {


    private float speed;

    public Monster(Vector2f position, Image image) {
        super(position, image);
    }

    public void render(Graphics g, Camera camera) {
        super.render(g, camera);
    }

    public void onDeath(World world) {

    }

    public float getSpeed() {
        return speed;
    }
}
