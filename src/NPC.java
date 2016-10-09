/* SWEN20003 - Object Oriented Software Development
 * RPG Game Engine
 * Author: James Stone <stone1> 761353
 */

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

public class NPC extends Unit {
    private String  text;
    private boolean talking;

    public NPC(Vector2f position, Image image, Stats stats) {
        super(position, image, stats);
    }

    public void update(int delta, World world) {

    }

    public void talk(Player player) {

    }

    public void render(Graphics g, Camera camera) {
        super.render(g, camera);
    }

    public String getText(int[] inventory) {
        return "";
    }

    public void interact(Player player) {

    }

}
