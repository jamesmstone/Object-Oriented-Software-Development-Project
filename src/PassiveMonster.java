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
    private       float speed         = (float) 0.2; // speed (px/ms)
    private final int   moveFrequency = 3; // frequency of movement (s) todo * 1000  actually in ms
    private final int   timeRunning   = 5 * 1000; // how long to run away for (ms)

    public PassiveMonster(Vector2f position, Image image, Stats stats) {
        super(position, image, stats);
    }


    public void update(int delta, World world) {
        attackedTime = (attackedTime > 0 ? attackedTime - delta : 0);
        moveTime = (moveTime > 0 ? moveTime - delta : moveFrequency);
        if (moveTime <= 0) {
            super.move(world, getDirection(world.getUnitManager().getPlayer().getPosition()).scale(delta * speed));
        }
        super.update(delta, world);
    }

    public void onAttacked(int damage) {
        attackedTime = timeRunning;
        super.onAttacked(damage);
    }

    private Vector2f getDirection(Vector2f playerPosition) {
        float direction;
        if (attackedTime == 0) {
            // not under attack
            direction = ThreadLocalRandom.current().nextInt(0, 360);
        } else {
            // under attack
            direction = (float) playerPosition.add(getPosition()).getTheta(); // player to monster direction
        }
        return super.getDirection(direction);
    }
}
