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
        Vector2f newPos = position.add(dx);

        double new_x = newPos.getX();
        double new_y = newPos.getY();

        // Move in x first
        double x_sign = Math.signum(dx.getX());
        if (!world.terrainBlocks(new_x + x_sign * getImageWidth() / 2, position.getY() + getImageHeight() / 2) &&
                !world.terrainBlocks(new_x + x_sign * getImageWidth() / 2, position.getY() - getImageHeight() / 2)) {
            position.set((float) new_x, position.getY());
        }

        // Then move in y
        double y_sign = Math.signum(dx.getY());
        if (!world.terrainBlocks(position.getX() + getImageWidth() / 2, new_y + y_sign * getImageHeight() / 2) &&
                !world.terrainBlocks(position.getX() - getImageWidth() / 2, new_y + y_sign * getImageHeight() / 2)) {
            position.set(position.getX(), (float) new_y);
        }

        // update unit direction
        if (dx.getX() > 0) {
            this.face_left = false;
        } else if (dx.getX() < 0) {
            this.face_left = true;
        }
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
