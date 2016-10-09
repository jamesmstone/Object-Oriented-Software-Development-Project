/* SWEN20003 - Object Oriented Software Development
 * RPG Game Engine
 * Author: James Stone <stone1> 761353
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Zombie extends AggressiveMonster {
    public Zombie(Vector2f position) throws SlickException {
        super(position, new Image(RPG.ASSETS_PATH + "/units/zombie.png"));
    }

}
