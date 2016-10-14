/* SWEN20003 - Object Oriented Software Development
 * RPG Game Engine
 * Author: James Stone <stone1> 761353
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class PrinceAldric extends NPC {
    public static final int INITIAL_COOLDOWN = 0;
    public static final int INITIAL_DAMAGE   = 0;
    public static final int INITIAL_MAX_HP   = 1;
    public static final int INITIAL_HP       = 1;

    public PrinceAldric(Vector2f position) throws SlickException {
        super(position, new Image(RPG.ASSETS_PATH + "/units/prince.png"), new Stats(INITIAL_COOLDOWN, INITIAL_DAMAGE, INITIAL_MAX_HP, INITIAL_HP));
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
