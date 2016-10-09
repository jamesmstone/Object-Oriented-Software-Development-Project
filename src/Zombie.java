/* SWEN20003 - Object Oriented Software Development
 * RPG Game Engine
 * Author: James Stone <stone1> 761353
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Zombie extends AggressiveMonster {
    public static final int initialCooldown = 800;
    public static final int initialDamage   = 10;
    public static final int initialMaxHP    = 60;
    public static final int initialHP       = 60;

    public Zombie(Vector2f position) throws SlickException {
        super(position, new Image(RPG.ASSETS_PATH + "/units/zombie.png"), new Stats(initialCooldown, initialDamage, initialMaxHP, initialHP));
    }

}
