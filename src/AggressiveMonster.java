/* SWEN20003 - Object Oriented Software Development
 * RPG Game Engine
 * Author: James Stone <stone1> 761353
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

abstract public class AggressiveMonster extends Monster {

    private       float speed                   = (float) 0.25;
    private final int   TOO_FAR_WALK_DISTANCE   = 150; // px
    private final int   TOO_CLOSE_WALK_DISTANCE = 50; // px


    /**
     * Generates an Aggressive Monster, only uses by subclasses as abstract
     *
     * @param position // The start position of the Aggressive Monster
     * @param image    // An image showing the monster
     * @param stats    // The monsters stats
     */
    public AggressiveMonster(Vector2f position, Image image, Stats stats) {
        super(position, image, stats);
    }

    /**
     * Update the game state for a frame.
     *
     * @param delta Time passed since last frame (milliseconds).
     * @param world The world object
     */
    public void update(int delta, World world) {
        float distance = world.getUnitManager().getPlayer().getPosition().distance(getPosition());
        if (distance <= TOO_FAR_WALK_DISTANCE && distance >= TOO_CLOSE_WALK_DISTANCE) {
            super.move(world, getDirectionToPlayer(world.getUnitManager().getPlayer().getPosition()).scale(delta * speed));
        }
        super.update(delta, world);
    }

    /**
     * Returns the aggressive monsters speed in pxs/ms
     * @return speed (px/ms)
     */
    public float getSpeed() {
        return speed;
    }

}
