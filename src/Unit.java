/* SWEN20003 - Object Oriented Software Development
 * RPG Game Engine
 * Author: James Stone <stone1> 761353
 */

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

public class Unit {
    private Stats stats;
    private Vector2f position;
    private String name;

    private Image image;
    private Image image_flipped;

    private boolean attacked;
    private int attackTimer;

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
        Vector2f newPos = position.copy().add(dx);

        double new_x = newPos.getX();
        double new_y = newPos.getY();

        // Move in x first
        double x_sign = Math.signum(dx.getX());
        if (!world.terrainBlocks(new_x + x_sign * getImageWidth() / 4, position.getY() + getImageHeight() / 4) &&
                !world.terrainBlocks(new_x + x_sign * getImageWidth() / 4, position.getY() - getImageHeight() / 4)) {
            position.set((float) new_x, position.getY());
        }

        // Then move in y
        double y_sign = Math.signum(dx.getY());
        if (!world.terrainBlocks(position.getX() + getImageWidth() / 4, new_y + y_sign * getImageHeight() / 4) &&
                !world.terrainBlocks(position.getX() - getImageWidth() / 4, new_y + y_sign * getImageHeight() / 4)) {
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
        // Panel colours
        Color LABEL  = new Color(0.9f, 0.9f, 0.4f);            // Gold
        Color VALUE  = new Color(1.0f, 1.0f, 1.0f);            // White
        Color BAR_BG = new Color(0.0f, 0.0f, 0.0f, 0.8f);      // Black, transp
        Color BAR    = new Color(0.8f, 0.0f, 0.0f, 0.8f);      // Red, transp

        // Variables for layout
        String text;                   // Text to display
        int    text_x, text_y;         // Coordinates to draw text
        int    bar_x, bar_y;           // Coordinates to draw rectangles
        int    bar_width, bar_height;  // Size of rectangle to draw
        int    hp_bar_width;           // Size of red (HP) rectangle

        Stats  unitStats = this.getStats();

        float health_percent;       // Player's health, as a percentage

        bar_width = 90;
        bar_height = 30;

        // Display the player's health bar
        g.setColor(LABEL);
        text = unitStats.getHp() + "/" + unitStats.getMaxHP();

        bar_x = (int) position.getX() - bar_width /2 ;
        bar_y = (int) (position.getY() - this.getImageHeight()/2 - bar_height);

        text_x = bar_x + (bar_width - g.getFont().getWidth(text)) / 2;
        text_y = bar_y + (bar_height - g.getFont().getLineHeight()) / 2;

        health_percent = unitStats.getHp() / unitStats.getMaxHP();
        hp_bar_width = (int) (bar_width * health_percent);

        g.setColor(BAR_BG);
        g.fillRect(bar_x, bar_y, bar_width, bar_height);
        g.setColor(BAR);
        g.fillRect(bar_x, bar_y, hp_bar_width, bar_height);
        g.setColor(VALUE);
        g.drawString(text, text_x, text_y);

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
        if(onScreen(camera)) {
            this.renderImage(g, camera);
            this.renderHealthbar(g, camera);
        }
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

    public boolean onScreen(Camera cam) {
        return cam.getMinX() <= getX() && getX() <= cam.getMaxX() &&
                cam.getMinY() <= getY() && getY() <= cam.getMaxY();
    }
}
