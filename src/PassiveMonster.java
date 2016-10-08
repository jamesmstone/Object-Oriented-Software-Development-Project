/* SWEN20003 - Object Oriented Software Development
 * RPG Game Engine
 * Author: James Stone <stone1> 761353
 */

import org.newdawn.slick.geom.Vector2f;

public class PassiveMonster extends Monster {

    private boolean attacked;
    private int attackedTime;
    private int moveTime;
    private Vector2f direction;


    public void update(int delta, World world) {

    }

    public void onAttacked() {

    }

    private int getDirection() {
        return 0; // todo
    }
}
