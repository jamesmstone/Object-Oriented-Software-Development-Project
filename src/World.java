/* 433-294 Object Oriented Software Development
 * RPG Game Engine
 * Author: Matt Giuca <mgiuca>
 * Modified: James Stone 761353 stone1
 */

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 * Represents the entire game world.
 * (Designed to be instantiated just once for the whole game).
 */
public class World {
    private static final int PLAYER_START_X = 756, PLAYER_START_Y = 684;

    private Player      player = null;
    private UnitManager units  = null;
    private final ItemManager items;
    private TiledMap map    = null;
    private Camera   camera = null;

    /**
     * Map width, in pixels.
     */
    private int getMapWidth() {
        return map.getWidth() * getTileWidth();
    }

    /**
     * Map height, in pixels.
     */
    private int getMapHeight() {
        return map.getHeight() * getTileHeight();
    }

    /**
     * Tile width, in pixels.
     */
    private int getTileWidth() {
        return map.getTileWidth();
    }

    /**
     * Tile height, in pixels.
     */
    private int getTileHeight() {
        return map.getTileHeight();
    }

    /**
     * Create a new World object.
     */
    public World() throws SlickException {
        map = new TiledMap(RPG.ASSETS_PATH + "/map.tmx", RPG.ASSETS_PATH);
        units = new UnitManager();
        items = new ItemManager();
        camera = new Camera(units.getPlayer(), RPG.SCREEN_WIDTH, RPG.SCREEN_HEIGHT);
    }

    /**
     * Update the game state for a frame.
     *
     * @param dir_x The player's movement in the x axis (-1, 0 or 1).
     * @param dir_y The player's movement in the y axis (-1, 0 or 1).
     * @param delta Time passed since last frame (milliseconds).
     */
    public void update(int dir_x, int dir_y, int delta)
            throws SlickException {
        units.getPlayer().move(this, dir_x, dir_y, delta);
        camera.update();
        units.update(delta, this);
    }

    /**
     * Render the entire screen, so it reflects the current game state.
     *
     * @param g The Slick graphics object, used for drawing.
     */
    public void render(Graphics g)
            throws SlickException {
        // Render the relevant section of the map
        int x  = -(camera.getMinX() % getTileWidth());
        int y  = -(camera.getMinY() % getTileHeight());
        int sx = camera.getMinX() / getTileWidth();
        int sy = camera.getMinY() / getTileHeight();
        int w  = (camera.getMaxX() / getTileWidth()) - (camera.getMinX() / getTileWidth()) + 1;
        int h  = (camera.getMaxY() / getTileHeight()) - (camera.getMinY() / getTileHeight()) + 1;
        map.render(x, y, sx, sy, w, h);

        // Translate the Graphics object
        g.translate(-camera.getMinX(), -camera.getMinY());

        // Render the Units
        units.render(g, camera);
        // Render the Items
        items.render(camera);

        // Render Panel
        g.translate(+camera.getMinX(), +camera.getMinY());
        this.renderPanel(g);

    }

    /**
     * Determines whether a particular map coordinate blocks movement.
     *
     * @param x Map x coordinate (in pixels).
     * @param y Map y coordinate (in pixels).
     * @return true if the coordinate blocks movement.
     */
    public boolean terrainBlocks(double x, double y) {
        // Check we are within the bounds of the map
        if (x < 0 || y < 0 || x > getMapWidth() || y > getMapHeight()) {
            return true;
        }

        // Check the tile properties
        int    tile_x = (int) x / getTileWidth();
        int    tile_y = (int) y / getTileHeight();
        int    tileid = map.getTileId(tile_x, tile_y, 0);
        String block  = map.getTileProperty(tileid, "block", "0");
        return !block.equals("0");
    }

    /**
     * Renders the player's status panel.
     *
     * @param g The current Slick graphics context.
     */
    public void renderPanel(Graphics g) {
        // Panel colours
        Color LABEL  = new Color(0.9f, 0.9f, 0.4f);            // Gold
        Color VALUE  = new Color(1.0f, 1.0f, 1.0f);            // White
        Color BAR_BG = new Color(0.0f, 0.0f, 0.0f, 0.8f);      // Black, transp
        Color BAR    = new Color(0.8f, 0.0f, 0.0f, 0.8f);      // Red, transp

        // Variables for layout
        String text;                   // Text to display
        int    text_x, text_y;         // Coordinates to draw text
        int    bar_x, bar_y;           // Coordinates to draw rectangles
        int    bar_width, bar_height;  // Size of rectangle to draw
        int    hp_bar_width;           // Size of red (HP) rectangle
        int    inv_x, inv_y;           // Coordinates to draw inventory item

        Player player      = units.getPlayer();
        Stats  playerStats = player.getStats();

        float health_percent;       // Player's health, as a percentage

        // Panel background image
        player.panel.draw(0, RPG.SCREEN_HEIGHT - RPG.PANEL_HEIGHT);

        // Display the player's health
        text_x = 15;
        text_y = RPG.SCREEN_HEIGHT - RPG.PANEL_HEIGHT + 25;
        g.setColor(LABEL);
        g.drawString("Health:", text_x, text_y);
        text = playerStats.getHp() + "/" + playerStats.getMaxHP();

        bar_x = 90;
        bar_y = RPG.SCREEN_HEIGHT - RPG.PANEL_HEIGHT + 20;
        bar_width = 90;
        bar_height = 30;
        health_percent = playerStats.getHp() / playerStats.getMaxHP();
        hp_bar_width = (int) (bar_width * health_percent);
        text_x = bar_x + (bar_width - g.getFont().getWidth(text)) / 2;
        g.setColor(BAR_BG);
        g.fillRect(bar_x, bar_y, bar_width, bar_height);
        g.setColor(BAR);
        g.fillRect(bar_x, bar_y, hp_bar_width, bar_height);
        g.setColor(VALUE);
        g.drawString(text, text_x, text_y);

        // Display the player's damage and cooldown
        text_x = 200;
        g.setColor(LABEL);
        g.drawString("Damage:", text_x, text_y);
        text_x += 80;
        text = String.valueOf(playerStats.getMaxDamage());
        g.setColor(VALUE);
        g.drawString(text, text_x, text_y);
        text_x += 40;
        g.setColor(LABEL);
        g.drawString("Rate:", text_x, text_y);
        text_x += 55;
        text = String.valueOf(playerStats.getCooldown());
        g.setColor(VALUE);
        g.drawString(text, text_x, text_y);

        // Display the player's inventory
        g.setColor(LABEL);
        g.drawString("Items:", 420, text_y);
        bar_x = 490;
        bar_y = RPG.SCREEN_HEIGHT - RPG.PANEL_HEIGHT + 10;
        bar_width = 288;
        bar_height = bar_height + 20;
        g.setColor(BAR_BG);
        g.fillRect(bar_x, bar_y, bar_width, bar_height);

        inv_x = 490;
        inv_y = RPG.SCREEN_HEIGHT - RPG.PANEL_HEIGHT
                + ((RPG.PANEL_HEIGHT - 72) / 2);
        for (int item : player.getInventory()) {
            // Render the item to (inv_x, inv_y)
            // TODO
            inv_x += 72;
        }
    }
}
