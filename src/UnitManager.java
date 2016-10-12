/* SWEN20003 Object Oriented Software Development
 * RPG Game Engine
 * Author: James Stone 761353 stone1
 */

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class UnitManager {
    private Player        player;
    private List<NPC>     npcs = new ArrayList<NPC>();
    private List<Monster> monsters = new ArrayList<Monster>();
    private List<Monster> deletionStack= new ArrayList<Monster>();

    public UnitManager() {
        load();

    }

    public void update(boolean playerAttack, boolean playerTalk, int delta, World world) {
        Vector2f playerPosition = getPlayer().getPosition();


        for (Monster monster : monsters) {
            monster.update(delta, world);
            if (playerAttack && monster.distanceFromPoint(playerPosition) <= Player.attackDistance) {
                player.attack(world, monster);
            }
            if (monster.distanceFromPoint(playerPosition) <= Monster.attackDistance) {
                monster.attack(world, player);
            }
        }


        for (NPC npc : npcs) {
            npc.update(player, playerTalk, delta, world);
        }

        player.update(delta, world);

    }

    public void render(Graphics g, Camera camera) {
        for (Monster monster : monsters) {
            monster.render(g, camera);
        }

        for (NPC npc : npcs) {
            npc.render(g, camera);
        }

        player.render(g, camera);
    }

    public void removeMonster(Monster monsterToRemove) {
        monsters = monsters.stream().filter(monster->!monster.equals(monsterToRemove)).collect(Collectors.toList());
    }

    public List<NPC> getNPCsNear(Vector2f point, float dist) {
        return npcs.stream().filter(npc -> npc.near(point, dist)).collect(Collectors.toList());
    }

    public List<Monster> getMonstersNear(Vector2f point, float dist) {
        return monsters.stream().filter(monster -> monster.near(point, dist)).collect(Collectors.toList());
    }

    public Player getPlayer() {
        return player;
    }

    private void load() {
        loadMonsters();
        loadNPCs();
        loadPlayer();
    }

    private void loadMonsters() {
        try {
            monsters.addAll(Arrays.asList(
                new GiantBat(new Vector2f(1431, 864)),
                new GiantBat(new Vector2f(1154, 1321)),
                new GiantBat(new Vector2f(807, 2315)),
                new GiantBat(new Vector2f(833, 2657)),
                new GiantBat(new Vector2f(1090, 3200)),
                new GiantBat(new Vector2f(676, 3187)),
                new GiantBat(new Vector2f(836, 3966)),
                new GiantBat(new Vector2f(653, 4367)),
                new GiantBat(new Vector2f(1343, 2731)),
                new GiantBat(new Vector2f(1835, 3017)),
                new GiantBat(new Vector2f(1657, 3954)),
                new GiantBat(new Vector2f(1054, 5337)),
                new GiantBat(new Vector2f(801, 5921)),
                new GiantBat(new Vector2f(560, 6682)),
                new GiantBat(new Vector2f(1275, 5696)),
                new GiantBat(new Vector2f(1671, 5991)),
                new GiantBat(new Vector2f(2248, 6298)),
                new GiantBat(new Vector2f(2952, 6373)),
                new GiantBat(new Vector2f(3864, 6695)),
                new GiantBat(new Vector2f(4554, 6443)),
                new GiantBat(new Vector2f(4683, 6228)),
                new GiantBat(new Vector2f(5312, 6606)),
                new GiantBat(new Vector2f(5484, 5946)),
                new GiantBat(new Vector2f(6371, 5634)),
                new GiantBat(new Vector2f(5473, 3544)),
                new GiantBat(new Vector2f(5944, 3339)),
                new GiantBat(new Vector2f(6301, 3414)),
                new GiantBat(new Vector2f(6388, 1994)),
                new GiantBat(new Vector2f(6410, 1584)),
                new GiantBat(new Vector2f(5314, 274)),

                new Zombie(new Vector2f(681, 3201)),
                new Zombie(new Vector2f(691, 4360)),
                new Zombie(new Vector2f(2166, 2650)),
                new Zombie(new Vector2f(2122, 2725)),
                new Zombie(new Vector2f(2284, 2962)),
                new Zombie(new Vector2f(2072, 4515)),
                new Zombie(new Vector2f(2006, 4568)),
                new Zombie(new Vector2f(2385, 4629)),
                new Zombie(new Vector2f(2446, 4590)),
                new Zombie(new Vector2f(2517, 4532)),
                new Zombie(new Vector2f(4157, 6730)),
                new Zombie(new Vector2f(4247, 6620)),
                new Zombie(new Vector2f(4137, 6519)),
                new Zombie(new Vector2f(4234, 6449)),
                new Zombie(new Vector2f(5879, 4994)),
                new Zombie(new Vector2f(5954, 4928)),
                new Zombie(new Vector2f(6016, 4866)),
                new Zombie(new Vector2f(5860, 4277)),
                new Zombie(new Vector2f(5772, 4277)),
                new Zombie(new Vector2f(5715, 4277)),
                new Zombie(new Vector2f(5653, 4277)),
                new Zombie(new Vector2f(5787, 797)),
                new Zombie(new Vector2f(5668, 720)),
                new Zombie(new Vector2f(5813, 454)),
                new Zombie(new Vector2f(5236, 917)),
                new Zombie(new Vector2f(5048, 1062)),
                new Zombie(new Vector2f(4845, 996)),
                new Zombie(new Vector2f(4496, 575)),
                new Zombie(new Vector2f(3457, 273)),
                new Zombie(new Vector2f(3506, 779)),
                new Zombie(new Vector2f(3624, 1192)),
                new Zombie(new Vector2f(2931, 1396)),
                new Zombie(new Vector2f(2715, 1326)),
                new Zombie(new Vector2f(2442, 1374)),
                new Zombie(new Vector2f(2579, 1159)),
                new Zombie(new Vector2f(2799, 1269)),
                new Zombie(new Vector2f(2768, 739)),
                new Zombie(new Vector2f(2099, 956)),

                new Bandit(new Vector2f(1889, 2581)),
                new Bandit(new Vector2f(4502, 6283)),
                new Bandit(new Vector2f(5248, 6581)),
                new Bandit(new Vector2f(5345, 6678)),
                new Bandit(new Vector2f(5940, 3412)),
                new Bandit(new Vector2f(6335, 3459)),
                new Bandit(new Vector2f(6669, 260)),
                new Bandit(new Vector2f(6598, 339)),
                new Bandit(new Vector2f(6598, 528)),
                new Bandit(new Vector2f(6435, 528)),
                new Bandit(new Vector2f(6435, 678)),
                new Bandit(new Vector2f(5076, 1082)),
                new Bandit(new Vector2f(5191, 1187)),
                new Bandit(new Vector2f(4940, 1175)),
                new Bandit(new Vector2f(4760, 1039)),
                new Bandit(new Vector2f(4883, 889)),
                new Bandit(new Vector2f(4427, 553)),
                new Bandit(new Vector2f(3559, 162)),
                new Bandit(new Vector2f(3779, 1553)),
                new Bandit(new Vector2f(3573, 1553)),
                new Bandit(new Vector2f(3534, 2464)),
                new Bandit(new Vector2f(3635, 2464)),
                new Bandit(new Vector2f(3402, 2861)),
                new Bandit(new Vector2f(3151, 2857)),
                new Bandit(new Vector2f(3005, 2997)),
                new Bandit(new Vector2f(2763, 2263)),
                new Bandit(new Vector2f(2648, 2263)),
                new Bandit(new Vector2f(2621, 1337)),
                new Bandit(new Vector2f(2907, 1270)),
                new Bandit(new Vector2f(2331, 598)),
                new Bandit(new Vector2f(2987, 394)),
                new Bandit(new Vector2f(1979, 394)),
                new Bandit(new Vector2f(2045, 693)),
                new Bandit(new Vector2f(2069, 1028)),

                new Skeleton(new Vector2f(1255, 2924)),
                new Skeleton(new Vector2f(2545, 4708)),
                new Skeleton(new Vector2f(4189, 6585)),
                new Skeleton(new Vector2f(5720, 622)),
                new Skeleton(new Vector2f(5649, 767)),
                new Skeleton(new Vector2f(5291, 312)),
                new Skeleton(new Vector2f(5256, 852)),
                new Skeleton(new Vector2f(4790, 976)),
                new Skeleton(new Vector2f(4648, 401)),
                new Skeleton(new Vector2f(3628, 1181)),
                new Skeleton(new Vector2f(3771, 1181)),
                new Skeleton(new Vector2f(3182, 2892)),
                new Skeleton(new Vector2f(3116, 3033)),
                new Skeleton(new Vector2f(2803, 2901)),
                new Skeleton(new Vector2f(2850, 2426)),
                new Skeleton(new Vector2f(2005, 1524)),
                new Skeleton(new Vector2f(2132, 1427)),
                new Skeleton(new Vector2f(2242, 1343)),
                new Skeleton(new Vector2f(2428, 771)),
                new Skeleton(new Vector2f(2427, 907)),
                new Skeleton(new Vector2f(2770, 613)),
                new Skeleton(new Vector2f(2915, 477)),
                new Skeleton(new Vector2f(1970, 553)),
                new Skeleton(new Vector2f(2143, 1048)),

                new Draelic(new Vector2f(2069, 510))
            ));
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    private void loadNPCs() {
        try {
            npcs.addAll(Arrays.asList(
                    new PrinceAldric(new Vector2f(467, 679)),
                    new Elvira(new Vector2f(738, 549)),
                    new Garth(new Vector2f(756, 870))
            ));
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    private void loadPlayer() {
        try {
            player = new Player(new Vector2f(756, 684));
        } catch (SlickException e) {
            e.printStackTrace();
        }

    }

}

