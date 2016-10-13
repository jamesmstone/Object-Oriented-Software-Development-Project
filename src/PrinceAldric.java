/* SWEN20003 - Object Oriented Software Development
 * RPG Game Engine
 * Author: James Stone <stone1> 761353
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import java.util.List;

public class PrinceAldric extends NPC {
    public static final int initialCooldown = 0;
    public static final int initialDamage   = 0;
    public static final int initialMaxHP    = 1;
    public static final int initialHP       = 1;

    public PrinceAldric(Vector2f position) throws SlickException {
        super(position, new Image(RPG.ASSETS_PATH + "/units/prince.png"), new Stats(initialCooldown, initialDamage, initialMaxHP, initialHP));
    }

    @Override
    public String getText(Player player) {
        for (Item item :player.getInventory()) {
            if(item instanceof ElixirOfLife){
                return "The elixir! My father is cured! Thank you!";
            }
        }
        return "Please seek out the Elixir of Life to cure the king.";
    }
}
