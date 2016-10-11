/* SWEN20003 - Object Oriented Software Development
 * RPG Game Engine
 * Author: James Stone <stone1> 761353
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Elvira extends NPC {
    public static final int initialCooldown = 0;
    public static final int initialDamage   = 0;
    public static final int initialMaxHP    = 1;
    public static final int initialHP       = 1;

    public Elvira(Vector2f position) throws SlickException {
        super(position, new Image(RPG.ASSETS_PATH + "/units/shaman.png"), new Stats(initialCooldown, initialDamage, initialMaxHP, initialHP));
    }

    public String getText(int[] inventory) {
        return ""; // todo
    }

    public void interact(Player player) {

    }

}
