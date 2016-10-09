/* SWEN20003 - Object Oriented Software Development
 * RPG Game Engine
 * Author: James Stone <stone1> 761353
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Skeleton extends AggressiveMonster {
    public static final int initialCooldown = 500;
    public static final int initialDamage   = 16;
    public static final int initialMaxHP    = 100;
    public static final int initialHP       = 100;

    public Skeleton(Vector2f position) throws SlickException {
        super(position, new Image(RPG.ASSETS_PATH + "/units/skeleton.png"), new Stats(initialCooldown, initialDamage, initialMaxHP, initialHP));
    }

}
