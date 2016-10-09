/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * Author: Matt Giuca <mgiuca>
 * Modified: James Stone 761353 stone1
 */

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

/**
 * The character which the user plays as.
 */
public class Player extends Unit {
    private static final double                  speed = 0.25; // Pixels per millisecond
    public               org.newdawn.slick.Image panel = new Image(RPG.ASSETS_PATH + "/panel.png");
    private int[] inventory = new int[]{};

    public static final int initialCooldown = 600;
    public static final int initialDamage   = 26;
    public static final int initialMaxHP    = 100;
    public static final int initialHP       = 100;

    public Player(Vector2f location) throws SlickException {
        super(location, new Image(RPG.ASSETS_PATH + "/units/player.png"), new Stats(initialCooldown, initialDamage, initialMaxHP, initialHP));
    }

    public void update(int delta, World world) {
    }

    /**
     * Move the player in a given direction.
     * Prevents the player from moving outside the map space, and also updates
     * the direction the player is facing.
     *
     * @param world The world the player is on (to check blocking).
     * @param dir_x The player's movement in the x axis (-1, 0 or 1).
     * @param dir_y The player's movement in the y axis (-1, 0 or 1).
     * @param delta Time passed since last frame (milliseconds).
     */
    public void move(World world, double dir_x, double dir_y, double delta) {
        float x = (float) (delta * speed * dir_x);
        float y = (float) (delta * speed * dir_y);
        if (x != 0 || y != 0) {
            super.move(world, new Vector2f(x, y));
        }
    }

    /**
     * Draw the player to the screen at the correct place.
     *
     * @param g      The current Graphics context.
     * @param camera The camera
     */
    public void render(Graphics g, Camera camera) {
        super.render(g, camera);
    }

    public int[] getInventory() {
        return inventory;
    }
}
