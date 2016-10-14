/* SWEN20003 Object Oriented Software Development
 * RPG Game Engine
 * Author: James Stone 761353 stone1
 */

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ItemManager {
    private List<Item> items         = new ArrayList<Item>();
    private List<Item> deletionStack = new ArrayList<Item>();

    public ItemManager() {
        load();
    }

    /**
     * Renders all items
     * @param g the graphics to render to
     * @param camera the camera
     */
    public void render(Graphics g, Camera camera) {
        for (Item item : items) {
            item.render(camera);
        }
    }


    /**
     * Gets all items within a certain distance of a point
     * @param point the point
     * @param distance the distance an item can be from the point (px)
     * @return items within that distance
     */
    public List<Item> getItemsNear(Vector2f point, float distance) {
        return items.stream().filter(item -> item.near(point, distance)).collect(Collectors.toList());
    }

    /**
     * Remove an item from the Item Manager
     * @param item the item to remove
     */
    public void removeItem(Item item) {
        deletionStack.add(item);
        items.remove(item);
    }

    private void load() {
        try {
            items.addAll(Arrays.asList(
                    new AmuletOfVitalitiy(new Vector2f(965, 3563)),
                    new SwordOfStrength(new Vector2f(546, 6707)),
                    new TomeOfAgility(new Vector2f(4791, 1253)),
                    new ElixirOfLife(new Vector2f(1976, 402))
            ));
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

}

