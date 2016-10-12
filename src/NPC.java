/* SWEN20003 - Object Oriented Software Development
 * RPG Game Engine
 * Author: James Stone <stone1> 761353
 */

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

import java.util.List;

public class NPC extends Unit {
    private static final int   talkDistance  = 50; // distance (px) within which talking is acceptable
    private static final float totalTalkTime = 4 * 1000; // time (ms) to chat for
    private String  text;
    private boolean talking;
    private float   talkTime;

    public NPC(Vector2f position, Image image, Stats stats) {
        super(position, image, stats);
    }

    public void update(Player player, boolean wannaTalk, int delta, World world) {
        if (wannaTalk && distanceFromPoint(player.getPosition()) < NPC.talkDistance) {
            interact(player, delta);
        }
        super.update(delta, world);

    }

    public void talk(Player player) {
        talking = true;
        talkTime = NPC.totalTalkTime;
        text = getText(player.getInventory());
    }

    public void render(Graphics g, Camera camera) {
        if (talking) {
            renderText();
        }
        super.render(g, camera);
    }

    public void onDeath(World world) {} // NPC can't die

    private void renderText() {

    }

    private String getText(List<Item> inventory) {
        return "";
    }

    public void interact(Player player, int delta) {
        if (!talking) {
            talk(player);
        }
        talkTime -= delta;
    }

}
