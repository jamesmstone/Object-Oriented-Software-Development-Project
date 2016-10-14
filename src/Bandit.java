/* SWEN20003 - Object Oriented Software Development
 * RPG Game Engine
 * Author: James Stone <stone1> 761353
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Bandit extends AggressiveMonster {
    public static final int INITIAL_COOLDOWN = 200;
    public static final int INITIAL_DAMAGE   = 8;
    public static final int INITIAL_MAX_HP   = 40;
    public static final int INITIAL_HP       = 40;

    /**
     * Generates a Bandit Monster
     * @param position starting position of the bandit monster
     * @throws SlickException
     */
    public Bandit(Vector2f position) throws SlickException {
        super(position, new Image(RPG.ASSETS_PATH + "/units/bandit.png"), new Stats(INITIAL_COOLDOWN, INITIAL_DAMAGE, INITIAL_MAX_HP, INITIAL_HP));
    }

}
