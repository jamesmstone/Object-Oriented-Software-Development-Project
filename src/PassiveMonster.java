/* SWEN20003 - Object Oriented Software Development
 * RPG Game Engine
 * Author: James Stone <stone1> 761353
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

import java.util.concurrent.ThreadLocalRandom;

abstract public class PassiveMonster extends Monster {

    private int attackedTime;
    private int moveTime;
    private       float    speed            = (float) 0.2; // speed (px/ms)
    private final int      MOVE_FREQUENCY   = 3 * 1000; // frequency of movement (ms)
    private final int      TIME_RUNNING     = 5 * 1000; // how long to run away for (ms)
    private       Vector2f currentDirection = getPassiveMovement();

    public PassiveMonster(Vector2f position, Image image, Stats stats) {
        super(position, image, stats);
    }

    /**
     * Updates a Passive Monster
     * @param delta how long since last update
     * @param world the world where the monster is
     */
    public void update(int delta, World world) {
        attackedTime = (attackedTime > 0 ? attackedTime - delta : 0);
        moveTime = (moveTime > 0 ? moveTime - delta : MOVE_FREQUENCY);
        if (attackedTime == 0) {
            super.move(world, currentDirection.copy().scale(delta * speed));
        } else {
            super.move(world, getDirectionFromPlayer(world.getUnitManager().getPlayer().getPosition()).copy().scale(delta * speed));
        }
        if (moveTime <= 0) {
            currentDirection = getPassiveMovement();
        }
        super.update(delta, world);
    }

    /**
     * What happens when attacked
     * @param damage the amount of damage to give to this unit
     */
    public void onAttacked(int damage) {
        attackedTime = TIME_RUNNING;
        super.onAttacked(damage);
    }

    /**
     * get the speed of the monster
     * @return the monsters speed (px/ms)
     */
    public float getSpeed() {
        return speed;
    }

    private Vector2f getPassiveMovement() {
        int direction = ThreadLocalRandom.current().nextInt(0, 9);

        switch (direction) {
            case 0:
                // Right
                return new Vector2f(1, 0);
            case 1:
                // Up-Right
                return new Vector2f(1, -1);
            case 2:
                // Up
                return new Vector2f(0, -1);
            case 3:
                // Up-Left
                return new Vector2f(-1, -1);
            case 4:
                // Left
                return new Vector2f(-1, 0);
            case 5:
                // Down-Left
                return new Vector2f(-1, 1);
            case 6:
                // Down
                return new Vector2f(0, 1);
            case 7:
                // Down-Right
                return new Vector2f(1, 1);
            default:
                // No Movement
                return new Vector2f(0, 0);
        }
    }

}
