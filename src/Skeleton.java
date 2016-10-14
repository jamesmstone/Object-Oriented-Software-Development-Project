/* SWEN20003 - Object Oriented Software Development
 * RPG Game Engine
 * Author: James Stone <stone1> 761353
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Skeleton extends AggressiveMonster {
    public static final int INITIAL_COOLDOWN = 500;
    public static final int INITIAL_DAMAGE   = 16;
    public static final int INITIAL_MAX_HP   = 100;
    public static final int INITIAL_HP       = 100;

    public Skeleton(Vector2f position) throws SlickException {
        super(position, new Image(RPG.ASSETS_PATH + "/units/skeleton.png"), new Stats(INITIAL_COOLDOWN, INITIAL_DAMAGE, INITIAL_MAX_HP, INITIAL_HP));
    }

}
