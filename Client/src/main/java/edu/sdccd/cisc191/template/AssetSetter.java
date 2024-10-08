package edu.sdccd.cisc191.template;

import edu.sdccd.cisc191.template.OBJS.OBJ_Blueheart;
import edu.sdccd.cisc191.template.OBJS.OBJ_Chest;
import edu.sdccd.cisc191.template.OBJS.OBJ_Door;
import edu.sdccd.cisc191.template.OBJS.OBJ_Key;

/**
 * The AssetSetter class is responsible for placing game objects such as keys, door, chest,
 * blue heart in the game world.
 */
public class AssetSetter {

    GamePanel gp;

    /**
     * Constructs a new AssetSetter instance and associates it with a specific GamePanel
     *
     * @param gp The GamePanel instance that this AssetSetter interacts with.
     */
    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    /**
     * (Module 1)
     * Places objects like keys, doors, chests, and blue hearts in the game world.
     * Each object is placed at a specific location based on the world coordinates.
     */
    public void setObject(){
        // Keys
        gp.obj[0] = new OBJ_Key(gp);
        gp.obj[0].worldX = 23 * gp.tileSize;
        gp.obj[0].worldY = 7 * gp.tileSize;

        gp.obj[1] = new OBJ_Key(gp);
        gp.obj[1].worldX = 23 * gp.tileSize;
        gp.obj[1].worldY = 40 * gp.tileSize;

        gp.obj[2] = new OBJ_Key(gp);
        gp.obj[2].worldX = 38 * gp.tileSize;
        gp.obj[2].worldY = 8 * gp.tileSize;

        gp.obj[3] = new OBJ_Door(gp);
        gp.obj[3].worldX = 10 * gp.tileSize;
        gp.obj[3].worldY = 11 * gp.tileSize;

        gp.obj[4] = new OBJ_Door(gp);
        gp.obj[4].worldX = 8 * gp.tileSize;
        gp.obj[4].worldY = 28 * gp.tileSize;

        gp.obj[5] = new OBJ_Door(gp);
        gp.obj[5].worldX = 12 * gp.tileSize;
        gp.obj[5].worldY = 22 * gp.tileSize;

        gp.obj[6] = new OBJ_Chest(gp);
        gp.obj[6].worldX = 10 * gp.tileSize;
        gp.obj[6].worldY = 7 * gp.tileSize;

        gp.obj[7] = new OBJ_Blueheart(gp);
        gp.obj[7].worldX = 37 * gp.tileSize;
        gp.obj[7].worldY = 42 * gp.tileSize;

    }
}
