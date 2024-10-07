package edu.sdccd.cisc191.template.OBJS;

import edu.sdccd.cisc191.template.GamePanel;
import edu.sdccd.cisc191.template.UtilityTool;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Represents an object in the game.
 */
public class SuperObject {

    /** The image of the object. */
    public BufferedImage image;

    /** The name of the object. */
    public String name;

    /** Whether the object has collision enabled. */
    public boolean collision = false;

    /** The object's position in the world. */
    public int worldX, worldY;

    /** The solid area for collision detection. */
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;
    UtilityTool uTool = new UtilityTool();

    /**
     * Draws the objects on the screen.
     *
     * @param g2 The graphics context.
     * @param gp The game panel.
     */
    public void draw(Graphics2D g2, GamePanel gp) {
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if(worldX + gp.tileSize> gp.player.worldX - gp.player.screenX &&
                worldY + gp.tileSize> gp.player.worldY - gp.player.screenY &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY){

            g2.drawImage(image,screenX,screenY,gp.tileSize,gp.tileSize,null);
        }
    }
}
