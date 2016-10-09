/* SWEN20003 - Object Oriented Software Development
 * RPG Game Engine
 * Author: James Stone <stone1> 761353
 */

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

public class Unit {
    private Stats    stats;
    private Vector2f position;
    private String   name;

    private Image image;
    private Image image_flipped;

    private boolean attacked;
    private int     attackTimer;

    private boolean face_left = false;

    public Unit(Vector2f position, Image image, Stats stats) {
        this.position = position;
        this.image = image;
        this.stats = stats;

        image_flipped = image.getFlippedCopy(true, false);
    }

    public int getImageWidth() {
        return image.getWidth();
    }

    public int getImageHeight() {
        return image.getHeight();
    }

    public void move(World world, Vector2f dx) {

    }

    public void renderImage(Graphics g, Camera camera) {
        Image which_img;
        which_img = this.face_left ? this.image_flipped : this.image;
        which_img.drawCentered((int) position.getX(), (int) position.getY());
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
        this.renderImage(g, camera);
        this.renderHealthbar(g, camera);
    }

    public void onDeath(World world) {

    }

    public void onAttacked() {

    }

    /**
     * The x coordinate of the player (pixels).
     */
    public double getX() {
        return position.getX();
    }

    /**
     * The y coordinate of the player (pixels).
     */
    public double getY() {
        return position.getY();
    }

    public Stats getStats() {
        return stats;
    }
}
