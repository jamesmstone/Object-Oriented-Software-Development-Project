/* SWEN20003 - Object Oriented Software Development
 * RPG Game Engine
 * Author: James Stone <stone1> 761353
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Garth extends NPC {

    public static final int initialCooldown = 0;
    public static final int initialDamage   = 0;
    public static final int initialMaxHP    = 0;
    public static final int initialHP       = 0;

    public Garth(Vector2f position) throws SlickException {
        super(position, new Image(RPG.ASSETS_PATH + "/units/peasant.png"), new Stats(initialCooldown, initialDamage, initialMaxHP, initialHP));
    }

    public String getText(int[] inventory) {
        return ""; // todo
    }

}
