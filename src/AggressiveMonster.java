/* SWEN20003 - Object Oriented Software Development
 * RPG Game Engine
 * Author: James Stone <stone1> 761353
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

public class AggressiveMonster extends Monster {

    private float speed = (float) 0.25;

    public AggressiveMonster(Vector2f position, Image image, Stats stats) {
        super(position, image, stats);
    }

    public void update(int delta, World world) {

    }

}
