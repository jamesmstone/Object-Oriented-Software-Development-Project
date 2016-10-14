/* SWEN20003 - Object Oriented Software Development
 * RPG Game Engine
 * Author: James Stone <stone1> 761353
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Zombie extends AggressiveMonster {
    public static final int INITIAL_COOLDOWN = 800;
    public static final int INITIAL_DAMAGE   = 10;
    public static final int INITIAL_MAX_HP   = 60;
    public static final int INITIAL_HP       = 60;

    public Zombie(Vector2f position) throws SlickException {
        super(position, new Image(RPG.ASSETS_PATH + "/units/zombie.png"), new Stats(INITIAL_COOLDOWN, INITIAL_DAMAGE, INITIAL_MAX_HP, INITIAL_HP));
    }

}
