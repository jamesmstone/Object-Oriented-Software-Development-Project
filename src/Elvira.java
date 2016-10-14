/* SWEN20003 - Object Oriented Software Development
 * RPG Game Engine
 * Author: James Stone <stone1> 761353
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Elvira extends NPC {
    public static final int INITIAL_COOLDOWN = 0;
    public static final int INITIAL_DAMAGE   = 0;
    public static final int INITIAL_MAX_HP   = 1;
    public static final int INITIAL_HP       = 1;

    /**
     * Generates Elvira
     * @param position starting position of Elvira
     * @throws SlickException
     */
    public Elvira(Vector2f position) throws SlickException {
        super(position, new Image(RPG.ASSETS_PATH + "/units/shaman.png"), new Stats(INITIAL_COOLDOWN, INITIAL_DAMAGE, INITIAL_MAX_HP, INITIAL_HP));
    }

    /**
     * Starts an interaction
     * @param player the player to interact with
     */
    public void interact(Player player) {
        super.interact(player);
        player.heal();
    }

    /**
     * The text to display
     * @param player the player you are interacting with
     * @return the convo
     */
    public String getText(Player player) {
        if(player.getStats().getHp() == player.getStats().getMaxHP()) {
            return "Return to me if you ever need healing.";
        }
        else{
            return "You're looking much healthier now.";
        }
    }
}
