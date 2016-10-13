/* SWEN20003 - Object Oriented Software Development
 * RPG Game Engine
 * Author: James Stone <stone1> 761353
 */

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

abstract public class NPC extends Unit {
    private static final int   talkDistance  = 50; // distance (px) within which talking is acceptable
    private static final float totalTalkTime = 4 * 1000; // time (ms) to chat for
    private String text;
    private float  talkTime;

    public NPC(Vector2f position, Image image, Stats stats) {
        super(position, image, stats);
    }

    public void update(Player player, boolean wannaTalk, int delta, World world) {
        if (wannaTalk && distanceFromPoint(player.getPosition()) < NPC.talkDistance) {
            interact(player);
        }
        talkTime = talkTime > 0 ? talkTime - delta : 0;
        super.update(delta, world);

    }

    public void talk(Player player) {
        talkTime = NPC.totalTalkTime;
        text = getText(player);
    }

    public void render(Graphics g, Camera camera) {
        if (talkTime > 0) {
            renderText(g);
        }
        super.render(g, camera);
    }

    public void onDeath(World world) {
    } // NPC can't die

    private void renderText(Graphics g) {
        // Panel colours
        Color VALUE   = new Color(1.0f, 1.0f, 1.0f);            // White
        Color TEXT_BG = new Color(0.0f, 0.0f, 0.0f, 0.8f);      // Black, transp

        // Variables for layout
        int text_x, text_y;         // Coordinates to draw text
        int bar_x, bar_y;           // Coordinates to draw rectangles
        int bar_width, bar_height;  // Size of rectangle to draw

        bar_width = g.getFont().getWidth(text) + 10;
        bar_height = 30;


        bar_x = (int) getPosition().getX() - bar_width / 2;
        bar_y = (int) (getPosition().getY() - this.getImageHeight() / 2 - bar_height - 40);

        text_x = bar_x + (bar_width - g.getFont().getWidth(text)) / 2;
        text_y = bar_y + (bar_height - g.getFont().getLineHeight()) / 2;

        g.setColor(TEXT_BG);
        g.fillRect(bar_x, bar_y, bar_width, bar_height);
        g.setColor(VALUE);
        g.drawString(text, text_x, text_y);

    }

    abstract public String getText(Player player);

    public void interact(Player player) {
        talk(player);
    }

}
