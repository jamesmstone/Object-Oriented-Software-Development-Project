/* SWEN20003 - Object Oriented Software Development
 * RPG Game Engine
 * Author: James Stone <stone1> 761353
 */

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

import java.util.concurrent.ThreadLocalRandom;

public class Monster extends Unit {


    public static final float attackDistance = 50; // distance (pxs) at which monster attacks

    public Monster(Vector2f position, Image image, Stats stats) {
        super(position, image, stats);
    }

    public void render(Graphics g, Camera camera) {
        super.render(g, camera);
    }

    public void update(int delta, World world) {
        super.update(delta,world);
    }

    public void onDeath(World world) {
        world.getUnitManager().removeMonster(this);
    }

    public Vector2f getDirection(float direction) {


        if (direction <= 22.5) {
            // Right
            return new Vector2f(1, 0);
        } else if (direction <= 67.5) {
            // Up-Right
            return new Vector2f(1, -1);
        } else if (direction <= 112.5) {
            // Up
            return new Vector2f(0, -1);
        } else if (direction <= 157.5) {
            // Up-Left
            return new Vector2f(-1, -1);
        } else if (direction <= 202.5) {
            // Left
            return new Vector2f(-1, 0);
        } else if (direction <= 247.5) {
            // Down-Left
            return new Vector2f(-1, 1);
        } else if (direction <= 292.5) {
            // Down
            return new Vector2f(0, 1);
        } else if (direction <= 337.5) {
            // Down-Right
            return new Vector2f(1, 1);
        } else {
            // Right
            return new Vector2f(1, 0);
        }
    }
}
