/* SWEN20003 - Object Oriented Software Development
 * RPG Game Engine
 * Author: James Stone <stone1> 761353
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

import java.util.concurrent.ThreadLocalRandom;

public class AggressiveMonster extends Monster {

    private       float speed                = (float) 0.25;
    private final int   tooFarWalkDistance   = 150; // px
    private final int   tooCloseWalkDistance = 50; // px


    public AggressiveMonster(Vector2f position, Image image, Stats stats) {
        super(position, image, stats);
    }

    public void update(int delta, World world) {
        float distance = world.getUnitManager().getPlayer().getPosition().distance(getPosition());
        if (distance <= tooFarWalkDistance && distance >= tooCloseWalkDistance) {
            super.move(world, getDirection(world.getUnitManager().getPlayer().getPosition()).scale(delta * speed));
        }
    }

    private Vector2f getDirection(Vector2f playerPosition) {
        float direction = (float) getPosition().add(playerPosition).getTheta(); // monster to player direction
        return super.getDirection(direction);
    }

}
