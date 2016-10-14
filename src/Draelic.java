/* SWEN20003 - Object Oriented Software Development
 * RPG Game Engine
 * Author: James Stone <stone1> 761353
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Draelic extends AggressiveMonster {
    public static final int INITIAL_COOLDOWN = 400;
    public static final int INITIAL_DAMAGE   = 30;
    public static final int INITIAL_MAX_HP   = 140;
    public static final int INITIAL_HP       = 140;

    /**
     * Generates a Draelic Monster
     * @param position starting position of the bandit monster
     * @throws SlickException
     */
    public Draelic(Vector2f position) throws SlickException {
        super(position, new Image(RPG.ASSETS_PATH + "/units/necromancer.png"), new Stats(INITIAL_COOLDOWN, INITIAL_DAMAGE, INITIAL_MAX_HP, INITIAL_HP));
    }

}
