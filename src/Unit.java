/* SWEN20003 - Object Oriented Software Development
 * RPG Game Engine
 * Author: James Stone <stone1> 761353
 */

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

public class Unit {
    private Vector2f position;
    private String name;
    private Image image;
    private int attackTimer;
    private boolean attacked;

    public int getImageWidth() {
        return image.getWidth();
    }

    public int getImageHeight() {
        return image.getHeight();
    }

    public void move(World world, Vector2f dx) {

    }

    public void renderImage(Graphics g, Camera camera) {

    }

    public void renderHealthbar(Graphics g, Camera camera) {

    }

    public void attack(World world, Unit target) {

    }

    public void heal() {

    }

    public void getBuffs() {

    }

    public void updateUnit(int delta, World world) {

    }

    public void update(int delta, World world) {

    }

    public void render(Graphics g, Camera camera) {

    }

    public void onDeath(World world) {

    }

    public void onAttacked() {

    }
}
