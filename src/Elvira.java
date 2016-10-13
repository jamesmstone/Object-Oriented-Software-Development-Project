/* SWEN20003 - Object Oriented Software Development
 * RPG Game Engine
 * Author: James Stone <stone1> 761353
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import java.util.List;

public class Elvira extends NPC {
    public static final int initialCooldown = 0;
    public static final int initialDamage   = 0;
    public static final int initialMaxHP    = 1;
    public static final int initialHP       = 1;

    public Elvira(Vector2f position) throws SlickException {
        super(position, new Image(RPG.ASSETS_PATH + "/units/shaman.png"), new Stats(initialCooldown, initialDamage, initialMaxHP, initialHP));
    }

    public void interact(Player player) {
        super.interact(player);
        player.heal();
    }

    @Override
    public String getText(Player player) {
        if(player.getStats().getHp() == player.getStats().getMaxHP()) {
            return "Return to me if you ever need healing.";
        }
        else{
            return "You're looking much healthier now.";
        }
    }
}
