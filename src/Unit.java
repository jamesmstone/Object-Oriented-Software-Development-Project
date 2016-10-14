/* SWEN20003 - Object Oriented Software Development
 * RPG Game Engine
 * Author: James Stone <stone1> 761353
 */

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

public abstract class Unit {
    private Stats    stats;
    private Vector2f position;

    private Image image;
    private Image image_flipped;

    private int attackTimer = 0;

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

    public void move(World world, Vector2f dPos) {
        Vector2f newPos = getPosition().add(dPos);

        double new_x = newPos.getX();
        double new_y = newPos.getY();

        // Move in x first
        double x_sign = Math.signum(dPos.getX());
        if (!world.terrainBlocks(new_x + x_sign * getImageWidth() / 4, getPosition().getY() + getImageHeight() / 4) &&
                !world.terrainBlocks(new_x + x_sign * getImageWidth() / 4, getPosition().getY() - getImageHeight() / 4)) {
            position.set((float) new_x, getPosition().getY());
        }

        // Then move in y
        double y_sign = Math.signum(dPos.getY());
        if (!world.terrainBlocks(getPosition().getX() + getImageWidth() / 4, new_y + y_sign * getImageHeight() / 4) &&
                !world.terrainBlocks(getPosition().getX() - getImageWidth() / 4, new_y + y_sign * getImageHeight() / 4)) {
            position.set(getPosition().getX(), (float) new_y);
        }

        // update unit direction
        if (dPos.getX() > 0) {
            this.face_left = false;
        } else if (dPos.getX() < 0) {
            this.face_left = true;
        }
    }

    private void renderImage(Graphics g, Camera camera) {
        Image which_img;
        which_img = this.face_left ? this.image_flipped : this.image;
        which_img.drawCentered((int) getPosition().getX(), (int) getPosition().getY());
    }

    private void renderHealthbar(Graphics g, Camera camera) {
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

        Stats unitStats = this.getStats();

        float health_percent;       // Player's health, as a percentage

        bar_width = 90;
        bar_height = 30;

        // Display the player's health bar
        g.setColor(LABEL);
        text = unitStats.getHp() + "/" + unitStats.getMaxHP();

        bar_x = (int) getPosition().getX() - bar_width / 2;
        bar_y = (int) (getPosition().getY() - this.getImageHeight() / 2 - bar_height);

        text_x = bar_x + (bar_width - g.getFont().getWidth(text)) / 2;
        text_y = bar_y + (bar_height - g.getFont().getLineHeight()) / 2;

        health_percent = (float) unitStats.getHp() / unitStats.getMaxHP();
        hp_bar_width = (int) (bar_width * health_percent);

        g.setColor(BAR_BG);
        g.fillRect(bar_x, bar_y, bar_width, bar_height);
        g.setColor(BAR);
        g.fillRect(bar_x, bar_y, hp_bar_width, bar_height);
        g.setColor(VALUE);
        g.drawString(text, text_x, text_y);

    }

    public void attack(World world, Unit target) {
        if (attackTimer == 0) {
            //attack
            target.onAttacked((int) (stats.getMaxDamage() * Math.random()));

            //update attackTimer
            attackTimer = stats.getCooldown();
        }
    }

    public void heal() {
        stats.resetHP();
    }

    public void update(int delta, World world) {
        attackTimer = (attackTimer > 0 ? attackTimer - delta : 0);
        if (stats.getHp() <= 0) {
            onDeath(world);
        }
    }

    public void render(Graphics g, Camera camera) {
        if (onScreen(camera)) {
            this.renderImage(g, camera);
            this.renderHealthbar(g, camera);
        }
    }

    public abstract void onDeath(World world);

    /**
     * attack this unit
     *
     * @param damage the amount of damage to give to this unit
     */
    public void onAttacked(int damage) {
        stats.reduceHP(damage);
    }

    /**
     * The x coordinate of the player (pixels).
     */
    public double getX() {
        return getPosition().getX();
    }

    /**
     * The y coordinate of the player (pixels).
     */
    public double getY() {
        return getPosition().getY();
    }

    public Stats getStats() {
        return stats;
    }

    public boolean onScreen(Camera cam) {
        return cam.getMinX() <= getX() && getX() <= cam.getMaxX() &&
                cam.getMinY() <= getY() && getY() <= cam.getMaxY();
    }

    /**
     * Returns the distance the unit is from a point
     *
     * @param point the point
     * @return distance in px
     */
    public float distanceFromPoint(Vector2f point) {
        return getPosition().distance(point);
    }

    /**
     * Determines in a point is near the unit
     *
     * @param point the point
     * @param dist  how far away it can be
     * @return true if the point is near the unit
     */
    public boolean near(Vector2f point, float dist) {
        return distanceFromPoint(point) < dist;
    }

    public Vector2f getPosition() {
        return position.copy();
    }

    public void setPosition(Vector2f position) {
        this.position = position;
    }
}
