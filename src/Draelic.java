/* SWEN20003 - Object Oriented Software Development
 * RPG Game Engine
 * Author: James Stone <stone1> 761353
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Draelic extends AggressiveMonster {
    public static final int initialCooldown = 400;
    public static final int initialDamage   = 30;
    public static final int initialMaxHP    = 140;
    public static final int initialHP       = 140;

    public Draelic(Vector2f position) throws SlickException {
        super(position, new Image(RPG.ASSETS_PATH + "/units/necromancer.png"), new Stats(initialCooldown, initialDamage, initialMaxHP, initialHP));
    }

}
