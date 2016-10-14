/* SWEN20003 - Object Oriented Software Development
 * RPG Game Engine
 * Author: James Stone <stone1> 761353
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class GiantBat extends PassiveMonster {
    public static final int INITIAL_COOLDOWN = 0;
    public static final int INITIAL_DAMAGE   = 0;
    public static final int INITIAL_MAX_HP   = 40;
    public static final int INITIAL_HP       = 40;

    /**
     * Generates a Giat Bat Monster
     * @param position starting position of the giant bat monster
     * @throws SlickException
     */
    public GiantBat(Vector2f position) throws SlickException {
        super(position, new Image(RPG.ASSETS_PATH + "/units/dreadbat.png"), new Stats(INITIAL_COOLDOWN, INITIAL_DAMAGE, INITIAL_MAX_HP, INITIAL_HP));
    }
}
