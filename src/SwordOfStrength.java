import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

/* SWEN20003 Object Oriented Software Development
 * RPG Game Engine
 * Author: James Stone 761353 stone1
 */
public class SwordOfStrength extends Item {

    private static final int EFECT_ON_HP         = 0;
    private static final int EFECT_ON_MAX_HP     = 0;
    private static final int EFECT_ON_MAX_DAMAGE = 30;
    private static final int EFECT_ON_COOLDOWN   = 0;

    SwordOfStrength(Vector2f position) throws SlickException {
        super(new Image(RPG.ASSETS_PATH + "/items/sword.png"), position);
    }

    public void onPickup(Stats playerStats) {
        playerStats.modify(new Stats(EFECT_ON_COOLDOWN, EFECT_ON_MAX_DAMAGE, EFECT_ON_MAX_HP, EFECT_ON_HP));
    }
}
