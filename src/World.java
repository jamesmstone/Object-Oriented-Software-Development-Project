/* SWEN20003 - Object Oriented Software Development
 * World
 * Author: James Stone <stone1> 761353
 */

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 * Represents the entire game world.
 * (Designed to be instantiated just once for the whole game).
 */
public class World {
    protected static TiledMap background;
    private Player player;
    private Camera camera;


    /**
     * Create a new World object.
     */
    public World()
            throws SlickException {

    	// Initialise Game Objects
        background = new TiledMap("assets/map.tmx", "assets/");
        player = new Player(756, 684, new Image("assets/units/player.png"));
        camera = new Camera(player, RPG.SCREENWIDTH, RPG.SCREENHEIGHT, RPG.WORLDWIDTH, RPG.WORLDHEIGHT);

    }

    /**
     * Update the game state for a frame.
     *
     * @param dir_x The player's movement in the x axis (-1, 0 or 1).
     * @param dir_y The player's movement in the y axis (-1, 0 or 1).
     * @param delta Time passed since last frame (milliseconds).
     */
    public void update(double dir_x, double dir_y, int delta)
            throws SlickException {
        if (dir_x != 0) {
            player.moveX(delta * dir_x);
        }
        if (dir_y != 0) {
            player.moveY(delta * dir_y);
        }
        camera.update();
    }

    /**
     * Render the entire screen, so it reflects the current game state.
     *
     * @param g The Slick graphics object, used for drawing.
     */
    public void render(Graphics g)
            throws SlickException {
        int width = (int) (RPG.SCREENWIDTH / background.getTileWidth() + 2);
        int height = (int) (RPG.SCREENHEIGHT / background.getTileWidth() + 2);

        int sx = (int) (camera.getxPos() / background.getTileWidth());
        int sy = (int) (camera.getyPos() / background.getTileHeight());

        int x = (int) (camera.getxPos() % background.getTileWidth());
        int y = (int) (camera.getyPos() % background.getTileHeight());
        
        background.render(-x, -y, sx, sy, width, height);
        
        player.render(camera);
    }


}
