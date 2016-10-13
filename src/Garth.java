/* SWEN20003 - Object Oriented Software Development
 * RPG Game Engine
 * Author: James Stone <stone1> 761353
 */

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import java.util.List;

public class Garth extends NPC {

    public static final int initialCooldown = 0;
    public static final int initialDamage   = 0;
    public static final int initialMaxHP    = 1;
    public static final int initialHP       = 1;

    public Garth(Vector2f position) throws SlickException {
        super(position, new Image(RPG.ASSETS_PATH + "/units/peasant.png"), new Stats(initialCooldown, initialDamage, initialMaxHP, initialHP));
    }

    @Override
    public String getText(Player player) {
        List<Item> playerInventory = player.getInventory();

        if(!hasAmuletOfVitalitiy(playerInventory)){return "Find the Amulet of Vitality, across the river to the west.";}
        if(!hasSwordOfStrength(playerInventory)){return "Find the Sword of Strength - cross the bridge to the east, then head south.";}
        if(!hasTomeOfAgility(playerInventory)){return "Find the Tome of Agility, in the Land of Shadows.";}
        return "You have found all the treasure I know of.";
    }

    private boolean hasTomeOfAgility(List<Item> inventory) {
        for (Item item :inventory) {
            if(item instanceof TomeOfAgility){
                return true;
            }
        }
        return false;
    }

    private boolean hasSwordOfStrength(List<Item> inventory) {
        for (Item item :inventory) {
            if(item instanceof SwordOfStrength){
                return true;
            }
        }
        return false;
    }

    private boolean hasAmuletOfVitalitiy(List<Item> inventory){
        for (Item item :inventory) {
            if(item instanceof AmuletOfVitalitiy){
                return true;
            }
        }
        return false;
    }
}
