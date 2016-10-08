/* SWEN20003 Object Oriented Software Development
 * RPG Game Engine
 * Author: James Stone 761353 stone1
 */

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.tests.xml.Item;

public class UnitManager {
    private Player player;
    private NPC[] npcs;
    private Monster[] monsters;
    private Monster[] deletionStack;

    public void update(int delta, World world) {

    }

    public void render(Graphics g, Camera camera) {

    }

    public void removeMonster(Monster monster){

    }

    public NPC[] getNPCsNear(Vector2f point){
        return npcs; // todo
    }

    public Monster[] getMonstersNear(Vector2f point){
        return monsters; // todo
    }

    public Player getPlayer(){
        return player; // todo
    }

    private void load() {
    
    }

}

