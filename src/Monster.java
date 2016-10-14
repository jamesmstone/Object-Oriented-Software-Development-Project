/* SWEN20003 - Object Oriented Software Development
 * RPG Game Engine
 * Author: James Stone <stone1> 761353
 */

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

abstract public class Monster extends Unit {


    public static final float ATTACK_DISTANCE = 50; // distance (pxs) at which monster attacks
    abstract public float getSpeed();
    public Monster(Vector2f position, Image image, Stats stats) {
        super(position, image, stats);
    }

    public void render(Graphics g, Camera camera) {
        super.render(g, camera);
    }

    public void update(int delta, World world) {
        super.update(delta,world);
    }

    public void onDeath(World world) {
        world.getUnitManager().removeMonster(this);
    }

    public Vector2f getDirectionToPlayer(Vector2f playerPosition) {

        float    amount        = getSpeed();
        float    distance      = playerPosition.distance(getPosition());
        Vector2f vectorBetween = playerPosition.sub(getPosition());
        float    x             = vectorBetween.getX() / distance * amount;
        float    y             = vectorBetween.getY() / distance * amount;
        return new Vector2f(x, y);
    }
    public Vector2f getDirectionFromPlayer(Vector2f playerPosition){
        return getDirectionToPlayer(playerPosition).negate();
    }
}
