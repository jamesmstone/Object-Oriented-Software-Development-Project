/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * Author: Matt Giuca <mgiuca>
 * Modified: James Stone 761353 stone1
 */

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import java.util.ArrayList;
import java.util.List;

/**
 * The character which the user plays as.
 */
public class Player extends Unit {
    private static final double                  SPEED                = 0.25; // Pixels per millisecond
    public static final  int                     ATTACK_DISTANCE      = 50; //pixels todo
    public static final  int                     ITEM_PICKUP_DISTANCE = 50; //pixels todo
    public               org.newdawn.slick.Image panel                = new Image(RPG.ASSETS_PATH + "/panel.png");
    private              List<Item>              inventory            = new ArrayList<Item>();

    public static final int INITIAL_COOLDOWN = 600;
    public static final int INITIAL_DAMAGE   = 26;
    public static final int INITIAL_MAX_HP   = 100;
    public static final int INITIAL_HP       = 100;

    private Vector2f initialPosition;

    public Player(Vector2f position) throws SlickException {
        super(position, new Image(RPG.ASSETS_PATH + "/units/player.png"), new Stats(INITIAL_COOLDOWN, INITIAL_DAMAGE, INITIAL_MAX_HP, INITIAL_HP));
        initialPosition = position.copy();
    }

    public void update(int delta, World world) {
        List<Item> nearbyItems = world.getItemManager().getItemsNear(getPosition(), ITEM_PICKUP_DISTANCE);
        inventory.addAll(nearbyItems);
        for (Item item : nearbyItems) {
            world.getItemManager().removeItem(item);
            item.onPickup(getStats());
        }
        super.update(delta, world);
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
        float x = (float) (delta * SPEED * dir_x);
        float y = (float) (delta * SPEED * dir_y);
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

    public List<Item> getInventory() {
        return inventory;
    }

    public void onDeath(World world) {
        heal();
        this.setPosition(initialPosition);
    }

    public boolean hasItem(Class itemName) {
        for (Item item : inventory) {
            if (itemName.isInstance(item)) {
                return true;
            }
        }
        return false;
    }
}
