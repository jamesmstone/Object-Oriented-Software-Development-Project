import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

/* SWEN20003 Object Oriented Software Development
 * RPG Game Engine
 * Author: James Stone 761353 stone1
 */
public class AmuletOfVitalitiy extends Item {

    private static final int efectOnHp        = 80;
    private static final int efectOnMaxHP     = 80;
    private static final int efectOnMaxDamage = 0;
    private static final int efectOnCooldown  = 0;

    AmuletOfVitalitiy(Vector2f position) throws SlickException {
        super(new Image(RPG.ASSETS_PATH + "/items/amulet.png"), position);
    }

    public void onPickup(Stats playerStats) {
        playerStats.modify(new Stats(efectOnCooldown, efectOnMaxDamage, efectOnMaxHP, efectOnHp));
    }
}
